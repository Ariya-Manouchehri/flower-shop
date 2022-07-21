package com.example.flowershop.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.flowershop.Fragment.CartFragment;
import com.example.flowershop.Fragment.CategoryFragment;
import com.example.flowershop.Fragment.HomeFragment;
import com.example.flowershop.Fragment.ProfileFragment;
import com.example.flowershop.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private static final int TIME_TO_EXIT = 2000;
    private long backPressed;
    BottomNavigationView bottomNavigation;
    public static boolean checkBackPressed = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  WindowManager.LayoutParams.FLAG_FULLSCREEN);

        bottomNavigation = findViewById(R.id.bottomNavigation);

        getSupportFragmentManager().beginTransaction().add(R.id.container, new HomeFragment(), getString(R.string.HomeFragmentTag)).commit();
        bottomNavigation.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        if (checkBackPressed) {
            if (backPressed + TIME_TO_EXIT > System.currentTimeMillis()) {
                super.onBackPressed();
            } else {
                Toast.makeText(HomeActivity.this, "press back again to exit !", Toast.LENGTH_SHORT).show();
            }
            backPressed = System.currentTimeMillis();
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment(), getString(R.string.HomeFragmentTag)).commit();
                checkBackPressed = true;
                bottomNavigation.setVisibility(View.VISIBLE);
                break;
            case R.id.category:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new CategoryFragment(), getString(R.string.CategoryFragmentTag)).commit();
                checkBackPressed = true;
                bottomNavigation.setVisibility(View.VISIBLE);
                break;
            case R.id.cart:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new CartFragment(), getString(R.string.CartFragmentTag)).commit();
                checkBackPressed = true;
                bottomNavigation.setVisibility(View.VISIBLE);
                break;
            case R.id.profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new ProfileFragment(), getString(R.string.ProfileFragmentTag)).commit();
                checkBackPressed = true;
                bottomNavigation.setVisibility(View.VISIBLE);
                break;
        }
        return true;
    }
}