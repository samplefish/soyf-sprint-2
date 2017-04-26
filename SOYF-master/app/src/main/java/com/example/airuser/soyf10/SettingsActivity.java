package com.example.airuser.soyf10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button button = (Button) findViewById(R.id.buttonTutorial);
        Button profiles = (Button) findViewById(R.id.profilesButton);

        profiles.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                goToProfilesActivity();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTutorialActivity();
            }
        });
    }

    private void goToProfilesActivity() {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    private void goToTutorialActivity() {
        Intent intent = new Intent(this, Tutorial.class);
        startActivity(intent);
    }

}
