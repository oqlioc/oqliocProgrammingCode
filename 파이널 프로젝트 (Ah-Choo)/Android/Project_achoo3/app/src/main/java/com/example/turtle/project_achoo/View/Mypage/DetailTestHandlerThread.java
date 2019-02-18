package com.example.turtle.project_achoo.View.Mypage;


import android.os.Handler;
import android.os.Message;

public class DetailTestHandlerThread implements Runnable {

    Handler handler;

    DetailTestHandlerThread(Handler handler) {
        this.handler=handler;
    }

    @Override
    public void run() {
        Message message=new Message();
        message.what=0;
        handler.sendMessage(message);
    }
}
