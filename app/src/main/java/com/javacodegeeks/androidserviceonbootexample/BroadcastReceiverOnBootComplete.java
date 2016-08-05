package com.javacodegeeks.androidserviceonbootexample;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.List;

public class BroadcastReceiverOnBootComplete extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, intent.getAction(), Toast.LENGTH_LONG).show();
        if (intent.getAction().equalsIgnoreCase(Intent.ACTION_BOOT_COMPLETED)) {
            Intent serviceIntent = new Intent(context, AndroidServiceStartOnBoot.class);
            context.startService(serviceIntent);
        }
    }
}

