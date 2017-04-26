package com.example.airuser.soyf10;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class StepCounterService extends Service implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mStepDetectorSensor;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        mSensorManager = (SensorManager)
                getSystemService(Context.SENSOR_SERVICE);
        mStepDetectorSensor = mSensorManager
                .getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        mSensorManager.registerListener(this, mStepDetectorSensor, SensorManager.SENSOR_DELAY_NORMAL);

        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;

        if (sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            SharedPreferences settings = getSharedPreferences("Pref_data", 0);
            int total = settings.getInt("totalSteps", -1);
            int daily = settings.getInt("dailySteps", -1);
            total++;
            daily++;
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("totalSteps", total);
            editor.putInt("dailySteps", daily);
            editor.commit();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
