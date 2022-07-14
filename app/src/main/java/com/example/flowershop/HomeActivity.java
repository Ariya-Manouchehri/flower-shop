package com.example.flowershop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    private static final int TIME_TO_EXIT = 2000;
    private long backPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public void onBackPressed() {
        if (backPressed + TIME_TO_EXIT > System.currentTimeMillis()) {
            super.onBackPressed();
        } else {
            Toast.makeText(HomeActivity.this, "press back again to exit !", Toast.LENGTH_SHORT).show();
        }
        backPressed = System.currentTimeMillis();
    }
}