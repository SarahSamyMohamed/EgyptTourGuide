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
public class RestaurantsAndCafesFragment extends Fragment {


    public RestaurantsAndCafesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.locations_list, container, false);

        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(R.drawable.karam_elshaam, getString(R.string.karam_elshaam), getString(R.string.alexandria), getString(R.string.karam_elshaam_details)));
        locations.add(new Location(R.drawable.farsha, getString(R.string.farsha), getString(R.string.sharm_al_shiekh), getString(R.string.farsha_details)));
        locations.add(new Location(R.drawable.zahret_demshq, getString(R.string.zahret_demshq), getString(R.string.alexandria), getString(R.string.zahret_demshq_details)));


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
