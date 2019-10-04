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
public class AttractionsFragment extends Fragment {


    public AttractionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.locations_list, container, false);

        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(R.drawable.islamic_cairo, getString(R.string.islamic_cairo), getString(R.string.cairo), getString(R.string.islamic_cairo_details)));
        locations.add(new Location(R.drawable.the_nile_cruising, getString(R.string.the_nile_cruising), getString(R.string.cairo_to_aswan), getString(R.string.the_nile_cruising_details)));
        locations.add(new Location(R.drawable.white_desert, getString(R.string.white_desert), getString(R.string.the_western_desert), getString(R.string.white_desert_details)));
        locations.add(new Location(R.drawable.siwa_oasis, getString(R.string.siwa_oasis), getString(R.string.the_western_desert), getString(R.string.siwa_oasis_details)));
        locations.add(new Location(R.drawable.bibliotheca_alexandria, getString(R.string.bibliotheca_alexandria), getString(R.string.alexandria), getString(R.string.bibliotheca_alexandria_details)));
        locations.add(new Location(R.drawable.dahab, getString(R.string.dahab), getString(R.string.south_sinai), getString(R.string.dahab_details)));

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
