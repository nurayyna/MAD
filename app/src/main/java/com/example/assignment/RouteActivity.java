package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RouteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,
                    new fragment_item()).commit();
        }
    }
}