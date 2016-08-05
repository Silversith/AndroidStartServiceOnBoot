package com.javacodegeeks.androidserviceonbootexample;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.List;

public class AndroidServiceStartOnBoot extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Service Running!")
                .setMessage("You are running Silversith Service!")
                .create();

        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();

        StartServiceCheck();
    }


    public void StartServiceCheck(){
        if (IsApplicationRunning("youtube")) // && checkConnectionState())
        {
            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    .setTitle("ALERT!")
                    .setMessage("You are running youtube and not connected to WiFi!")
                    .create();

            alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
            alertDialog.show();
        }
        Handler newHandler = new Handler(Looper.getMainLooper());
        newHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                StartServiceCheck();
            }
        }, 30000);
    }

    public boolean IsApplicationRunning(String appName){
        ActivityManager am = (ActivityManager) getSystemService(Activity.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> processes = am.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo process: processes
                ) {
            if (process.processName.toString().toLowerCase().contains(appName)){
                return true;
            }
        };
        return false;
    }

    private boolean checkConnectionState() {
        ConnectivityManager connManager = (ConnectivityManager) getApplicationContext().getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        return mWifi.isConnected();
    };
}