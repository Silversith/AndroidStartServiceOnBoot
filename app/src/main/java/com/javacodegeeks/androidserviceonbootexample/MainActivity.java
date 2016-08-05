package com.javacodegeeks.androidserviceonbootexample;

        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.widget.Toast;

public class MainActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}

//cd C:\Users\bbdnet1370\AppData\Local\Android\sdk\platform-tools
//adb shell am broadcast -a android.intent.action.BOOT_COMPLETED com.javacodegeeks.androidserviceonbootexample
//Ctrl + C

