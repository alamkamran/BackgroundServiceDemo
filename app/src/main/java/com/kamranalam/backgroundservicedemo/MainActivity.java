package com.kamranalam.backgroundservicedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.hi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyService mSensorService = new MyService(getApplicationContext());
                Intent mServiceIntent = new Intent(getApplicationContext(), mSensorService.getClass());
                if (!isMyServiceRunning(mSensorService.getClass())) {
                    startService(mServiceIntent);
                } else {
                    Toast.makeText(MainActivity.this, "Service Already running", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                Log.i("isMyServiceRunning?", true + "");
                return true;
            }
        }
        Log.i("isMyServiceRunning?", false + "");
        return false;
    }
}
