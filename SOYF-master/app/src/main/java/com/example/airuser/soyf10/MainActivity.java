package com.example.airuser.soyf10;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private TextView textView2;

    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, StepCounterService.class);
        startService(intent);
        SharedPreferences settings = getSharedPreferences("Pref_data", 0);
        editor = settings.edit();

        Calendar calendar = Calendar.getInstance();
        int day = settings.getInt("dayOfYear", 0);
        int year = settings.getInt("year", 0);
        if(calendar.get(Calendar.DAY_OF_YEAR) != day || calendar.get(Calendar.YEAR) != year){
            editor.putInt("dailyStep", 0);
        }

        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("dayOfYear", calendar.get(Calendar.DAY_OF_YEAR));
        editor.putInt("year", calendar.get(Calendar.YEAR));
        editor.commit();

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToSettingsActivity();
            }
        });

        int total = settings.getInt("totalSteps", -1);
        int daily = settings.getInt("totalSteps", -1);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);

        textView.setText("Total steps: " + total +" Daily steps: " + daily);


    }





    protected void onStop() {
        super.onStop();


    }

    private void goToSettingsActivity() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}

