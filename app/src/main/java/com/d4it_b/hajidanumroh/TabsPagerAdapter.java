package com.d4it_b.hajidanumroh;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.d4it_b.hajidanumroh.fragment.FragmentDAM;
import com.d4it_b.hajidanumroh.fragment.FragmentDoa;
import com.d4it_b.hajidanumroh.fragment.FragmentHaji;
import com.d4it_b.hajidanumroh.fragment.FragmentSholat;
import com.d4it_b.hajidanumroh.fragment.FragmentUmroh;

/**
 * Created by M N D on 23/02/2018.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Doa fragment activity
                return new FragmentDoa();
            case 1:
                // Haji fragment activity
                return new FragmentHaji();
            case 2:
                // Umroh fragment activity
                return new FragmentUmroh();
            case 3:
                // Sholat fragment activity
                return new FragmentSholat();
            case 4:
                // DAM fragment activity
                return new FragmentDAM();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 5;
    }
}
