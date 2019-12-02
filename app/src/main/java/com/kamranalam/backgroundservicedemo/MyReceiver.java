package com.kamranalam.backgroundservicedemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(MyReceiver.class.getSimpleName(), "Service Stops.");
        context.startService(new Intent(context, MyService.class));
    }
}
