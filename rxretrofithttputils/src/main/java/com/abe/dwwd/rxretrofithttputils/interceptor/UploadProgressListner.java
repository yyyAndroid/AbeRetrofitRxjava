package com.abe.dwwd.rxretrofithttputils.interceptor;

/**
 * Created by abe on 2017/7/31.
 */

public interface UploadProgressListner {
    void onRequestProgress(long bytesWritten,long contentLength);
}
