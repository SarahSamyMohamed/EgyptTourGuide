package com.example.egypttourguide;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class FragmentAdapter extends androidx.fragment.app.FragmentStatePagerAdapter {
    private Context context;

    public FragmentAdapter(Context context, FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HistoricalSitesFragment();
        } else if (position == 1) {
            return new RestaurantsAndCafesFragment();
        } else if (position == 2) {
            return new AttractionsFragment();
        } else if (position == 3) {
            return new HotelsFragment();
        } else {
            return new MallsFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Historical Sites";
        } else if (position == 1) {
            return "Restaurants And Cafes";
        } else if (position == 2) {
            return "Attractions";
        } else if (position == 3) {
            return "Hotels";
        } else {
            return "Malls";
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
