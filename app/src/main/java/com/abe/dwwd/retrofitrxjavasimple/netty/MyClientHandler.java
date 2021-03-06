package com.abe.dwwd.retrofitrxjavasimple.netty;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.abe.dwwd.retrofitrxjavasimple.activity.NettyActivity;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MyClientHandler extends SimpleChannelInboundHandler<String> {
    private Context ctx;
    private Handler handler;
  
    public MyClientHandler(Context context, Handler handler) {  
        this.ctx = context;  
        this.handler = handler;  
    }  
  
    @Override  
    protected void channelRead0(ChannelHandlerContext ctx, String msg)
            throws Exception {  
        Log.d("MyHelloClientHandler", "channelRead0->msg="+msg);
        Message m = new Message();
        m.what = NettyActivity.MSG_REC;
        m.obj = msg;  
        handler.sendMessage(m);  
    }  
  
    @Override  
    public void channelActive(ChannelHandlerContext ctx) throws Exception {  
        System.out.println("Client active");  
        super.channelActive(ctx);  
    }  
  
    @Override  
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {  
        System.out.println("Client close ");  
        super.channelInactive(ctx);  
    }  
  
}  