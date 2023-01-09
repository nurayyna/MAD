package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;


public class DriverProfile extends AppCompatActivity {
    RatingBar ratingBar;
    Button btSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_profile);

        RatingBar ratingBar = findViewById(R.id.rating_Bar);
        Button btSubmit = findViewById(R.id.bt_Submit);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplicationContext(), s + "Star"
                        , Toast.LENGTH_SHORT).show();

            }
        });
    }
}