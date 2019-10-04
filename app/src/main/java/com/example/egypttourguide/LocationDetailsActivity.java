package com.example.egypttourguide;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LocationDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_details_activity);

        Intent intent = getIntent();
        Location location = intent.getParcelableExtra("Location Details");

        int locationImage = location.getImageResourceId();
        ImageView locationImageTextView = findViewById(R.id.location_image);
        locationImageTextView.setImageResource(locationImage);

        String locationMainTitle = location.getMainTitle();
        TextView locationMainTitleTextView = findViewById(R.id.location_main_title);
        locationMainTitleTextView.setText(locationMainTitle);

        String locationSubTitle = location.getSubTitle();
        TextView locationSubTitleTextView = findViewById(R.id.location_sub_title);
        locationSubTitleTextView.setText(locationSubTitle);

        String locationDetails = location.getLocationDetails();
        TextView locationDetailsTextView = findViewById(R.id.location_details);
        locationDetailsTextView.setText(locationDetails);
    }
}
