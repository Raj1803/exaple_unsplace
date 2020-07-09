package com.example.example_bipolar_factory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabsAccessorAdaptor extends FragmentPagerAdapter {

    public TabsAccessorAdaptor(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int pos) {

        switch (pos){
            case 0 : PetsFragment petsFragment = new PetsFragment();
                return petsFragment;

            case 1 : NatureFragment natureFragment= new NatureFragment();
                return natureFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0 : return "Pets";

            case 1 :
                return "Nature";

            default:
                return null;
        }
    }
}
