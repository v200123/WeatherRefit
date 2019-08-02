package com.example.weatherrefit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.example.weatherrefit.Weather.Weather;
import com.example.weatherrefit.utils.GPSUtils;

public class MainActivity extends AppCompatActivity {

    private static final Handler sHandler = new Handler(Looper.getMainLooper());
    public static final String TAG = "com.lc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new
                    String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }


        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(MainActivity.this, new
                    String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }
        start();

    }


    private void start(){
        sHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, Weather.class);
                startActivity(i);
            }
        },1000);
    }
}
