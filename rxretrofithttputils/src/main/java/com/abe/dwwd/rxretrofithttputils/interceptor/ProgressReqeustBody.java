package com.abe.dwwd.rxretrofithttputils.interceptor;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/**
 * Created by abe on 2017/7/31.
 */

public class ProgressReqeustBody extends RequestBody {
    private RequestBody mRequestBody;
    private UploadProgressListner uploadProgressListner;
    private CountingSink countingSink;
    public ProgressReqeustBody(RequestBody mRequestBody, UploadProgressListner uploadProgressListner) {
        this.mRequestBody = mRequestBody;
        this.uploadProgressListner = uploadProgressListner;
    }

    @Override
    public MediaType contentType() {
        return mRequestBody.contentType();
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {
        BufferedSink bufferedSink;

        countingSink = new CountingSink(sink);
        bufferedSink = Okio.buffer(countingSink);

        mRequestBody.writeTo(bufferedSink);
        bufferedSink.flush();
    }

    @Override
    public long contentLength() throws IOException {
        try {
            return super.contentLength();

        }catch (IOException e){
            e.printStackTrace();
            return -1;
        }
    }

    class CountingSink extends ForwardingSink {

        private long bytesWritten = 0;

        public CountingSink(Sink delegate) {
            super(delegate);
        }

        @Override
        public void write(Buffer source, long byteCount) throws IOException {
            super.write(source, byteCount);
            bytesWritten += byteCount;
            uploadProgressListner.onRequestProgress(bytesWritten, contentLength());
        }
    }
}
