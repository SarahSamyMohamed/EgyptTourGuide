package com.example.egypttourguide;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelsFragment extends Fragment {


    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.locations_list, container, false);

        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(R.drawable.caves_beach_resort, getString(R.string.caves_beach_resort), getString(R.string.red_sea), getString(R.string.caves_beach_resort_details)));
        locations.add(new Location(R.drawable.al_alamein_hotel, getString(R.string.al_alamein_hotel), getString(R.string.matrouh), getString(R.string.al_alamein_hotel_details)));
        locations.add(new Location(R.drawable.windsor_palace_hotel, getString(R.string.windsor_palace_hotel), getString(R.string.alexandria), getString(R.string.windsor_palace_hotel_details)));
        locations.add(new Location(R.drawable.steigenberger_aqua_magic_hotel, getString(R.string.steigenberger_aqua_magic_hotel), getString(R.string.hurghada), getString(R.string.steigenberger_aqua_magic_hotel_details)));
        locations.add(new Location(R.drawable.four_seasons_hotel, getString(R.string.four_seasons_hotel), getString(R.string.alexandria), getString(R.string.four_seasons_hotel_details)));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), LocationDetailsActivity.class);
                intent.putExtra("Location Details", locations.get(position));
                startActivity(intent);
            }
        });

        return rootView;
    }

}
