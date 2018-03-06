package com.d4it_b.hajidanumroh;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.d4it_b.hajidanumroh.fragment.FragmentSubMenu;

import java.util.ArrayList;
import java.util.List;

public class MainAct extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        setupViewPager(viewPager);
//        adapter.addFragment(new FragmentSubMenu(), "Doa");
//        adapter.addFragment(new FragmentSubMenu(), "Umroh");
//        adapter.addFragment(new FragmentSubMenu(), "Hajii");
//        adapter.addFragment(new FragmentSubMenu(), "Sholat");
//        adapter.addFragment(new FragmentSubMenu(), "DAM");
//        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        FragmentSubMenu fragmentHaji = new FragmentSubMenu();
        fragmentHaji.setIndexMain(2);
        adapter.addFragment(fragmentHaji, "HAJI");

        FragmentSubMenu fragmentSholat = new FragmentSubMenu();
        fragmentSholat.setIndexMain(3);
        adapter.addFragment(fragmentSholat, "Sholat");
//
        FragmentSubMenu fragmentUmroh = new FragmentSubMenu();
        fragmentUmroh.setIndexMain(1);
        adapter.addFragment(fragmentUmroh, "Umroh");

        FragmentSubMenu fragmentDoa = new FragmentSubMenu();
        fragmentDoa.setIndexMain(4);
        adapter.addFragment(fragmentDoa, "DOA");

        FragmentSubMenu fragmentDAM = new FragmentSubMenu();
        fragmentDAM.setIndexMain(5);
        adapter.addFragment(fragmentDAM, "DAM");
        viewPager.setAdapter(adapter);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
