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
public class MallsFragment extends Fragment {


    public MallsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.locations_list, container, false);

        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(R.drawable.concord_plaza_mall, getString(R.string.concord_plaza_mall), getString(R.string.new_cairo), getString(R.string.concord_plaza_mall_details)));
        locations.add(new Location(R.drawable.cairo_festival_city_mall, getString(R.string.cairo_festival_city_mall), getString(R.string.cairo), getString(R.string.cairo_festival_city_mall_details)));
        locations.add(new Location(R.drawable.san_stefano_grand_plaza, getString(R.string.san_stefano_grand_plaza), getString(R.string.alexandria), getString(R.string.san_stefano_grand_plaza_details)));

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
