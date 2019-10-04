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
public class HistoricalSitesFragment extends Fragment {


    public HistoricalSitesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.locations_list, container, false);

        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(R.drawable.pyramids, getString(R.string.pyramids), getString(R.string.giza), getString(R.string.pyramids_details)));
        locations.add(new Location(R.drawable.karnak_temple, getString(R.string.karnak_temple), getString(R.string.luxor), getString(R.string.karnak_temple_details)));
        locations.add(new Location(R.drawable.abu_simbel, getString(R.string.abu_simbel), getString(R.string.aswan), getString(R.string.abu_simbel_details)));
        locations.add(new Location(R.drawable.egyptian_museum, getString(R.string.egyptian_museum), getString(R.string.cairo), getString(R.string.egyptian_museum_details)));
        locations.add(new Location(R.drawable.catherine_monastery, getString(R.string.catherine_monastery), getString(R.string.sinai), getString(R.string.catherine_monastery_details)));
        locations.add(new Location(R.drawable.abydos_temple, getString(R.string.abydos_temple), getString(R.string.sohag), getString(R.string.abydos_temple_details)));
        locations.add(new Location(R.drawable.saqqara_pyramid, getString(R.string.saqqara_pyramid), getString(R.string.giza), getString(R.string.saqqara_pyramid_details)));

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
