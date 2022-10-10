package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    //states
    private SensorManager sensorManager;
    Sensor accelerometer;
    TextView xValue;
    TextView yValue;
    TextView zValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //skapa appen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hämta textvyerna och lagra dem i variabler
        xValue = (TextView) findViewById(R.id.xValue);
        yValue = (TextView) findViewById(R.id.yValue);
        zValue = (TextView) findViewById(R.id.zValue);

        //Skapar sensor
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Log.d("MainActivity", "OnCreate sensor");

        //skapar accelerator genom sensorn
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //registrerar en "listner" som letar efter mina två metoder "onSensorChanged" & "onAccuracyChanged"
        sensorManager.registerListener(MainActivity.this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        Log.d("MainActivity", "OnCreate: registered accelerometer");

    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        Log.d("MainActivity", "x: " + sensorEvent.values[0] + " y: " + sensorEvent.values[1] + " z: " + sensorEvent.values[2]);

        xValue.setText("xValue: " + sensorEvent.values[0]);
        yValue.setText("yValue: " + sensorEvent.values[1]);
        zValue.setText("zValue: " + sensorEvent.values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}