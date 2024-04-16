package com.example.study_math;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons
        Button btnEasy = findViewById(R.id.btnEasy);
        Button btnMedium = findViewById(R.id.btnMedium);
        Button btnHard = findViewById(R.id.btnHard);

        // Set click listeners for each button
        btnEasy.setOnClickListener(v -> startActivityForLevel(EasyActivity.class));
        btnMedium.setOnClickListener(v -> startActivityForLevel(MediumActivity.class));
        btnHard.setOnClickListener(v -> startActivityForLevel(HardActivity.class));
    }

    // Method to start activity based on the button clicked
    private void startActivityForLevel(Class<?> activityClass) {
        startActivity(new Intent(MainActivity.this, activityClass));
    }
}