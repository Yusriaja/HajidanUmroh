package com.d4it_b.hajidanumroh;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.d4it_b.hajidanumroh.db.DbQueries;
import com.d4it_b.hajidanumroh.fragment.FragmentSubMenu;

import java.util.ArrayList;
import java.util.List;

public class MainAct extends AppCompatActivity{


    DbQueries dbQueries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        dbQueries = new DbQueries(this);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        TextView text = (TextView) findViewById(R.id.activityLabel);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Honej.ttf");
        text.setTypeface(tf);
    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        FragmentSubMenu fragmentHaji = new FragmentSubMenu();
        fragmentHaji.setRetainInstance(true);
        fragmentHaji.setIndexMain(2);
        adapter.addFragment(fragmentHaji, "HAJI");

        FragmentSubMenu fragmentSholat = new FragmentSubMenu();
        fragmentSholat.setRetainInstance(true);
        fragmentSholat.setIndexMain(3);
        adapter.addFragment(fragmentSholat, "Sholat");
//
        FragmentSubMenu fragmentUmroh = new FragmentSubMenu();
        fragmentUmroh.setRetainInstance(true);
        fragmentUmroh.setIndexMain(1);
        adapter.addFragment(fragmentUmroh, "Umroh");

        FragmentSubMenu fragmentDoa = new FragmentSubMenu();
        fragmentDoa.setRetainInstance(true);
        fragmentDoa.setIndexMain(4);
        adapter.addFragment(fragmentDoa, "DOA");

        FragmentSubMenu fragmentDAM = new FragmentSubMenu();
        fragmentDAM.setRetainInstance(true);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.profile:
                Intent intent = new Intent(MainAct.this, ProfileActivity.class);
                startActivity(intent);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private boolean isExternalStrorageWriteable(){
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            return true;
        }else {
            return false;
        }
    }
}
