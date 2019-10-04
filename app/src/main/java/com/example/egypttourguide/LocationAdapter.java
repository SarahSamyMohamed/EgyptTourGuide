package com.example.egypttourguide;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Location> {
    public LocationAdapter(Activity context, ArrayList<Location> locations) {
        super(context, 0, locations);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Location currentLocation = getItem(position);

        ImageView imageView = listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentLocation.getImageResourceId());

        TextView MainTitleTextView = listItemView.findViewById(R.id.title);
        MainTitleTextView.setText(currentLocation.getMainTitle());

        TextView SubTitleTextView = listItemView.findViewById(R.id.subtitle);
        SubTitleTextView.setText(currentLocation.getSubTitle());

        return listItemView;
    }
}
