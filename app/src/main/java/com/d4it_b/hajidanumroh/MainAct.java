package com.d4it_b.hajidanumroh;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.d4it_b.hajidanumroh.fragment.FragmentSubMenu;
import com.d4it_b.hajidanumroh.model.SubMenuContent;

import java.util.ArrayList;
import java.util.List;

public class MainAct extends AppCompatActivity implements FragmentSubMenu.Detail{

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
        fragmentHaji.setDetail(this);
        adapter.addFragment(fragmentHaji, "HAJI");

        FragmentSubMenu fragmentSholat = new FragmentSubMenu();
//        fragmentHaji.setDetail(this);
        adapter.addFragment(fragmentSholat, "Sholat");
//
        FragmentSubMenu fragmentUmroh = new FragmentSubMenu();
//        fragmentHaji.setDetail(this);
        adapter.addFragment(fragmentUmroh, "Umroh");

        FragmentSubMenu fragmentDoa = new FragmentSubMenu();
//        fragmentHaji.setDetail(this);
        adapter.addFragment(fragmentDoa, "DOA");

        FragmentSubMenu fragmentDAM = new FragmentSubMenu();
//        fragmentHaji.setDetail(this);
        adapter.addFragment(fragmentDAM, "DAM");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void detail(SubMenuContent content) {
        Intent intent = new Intent(MainAct.this, DetailHajiActivity.class);
        Bundle bundle = new Bundle();

        bundle.putInt("IdDetailHaji", content.getId());
        intent.putExtras(bundle);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), content.getId() + " , "+ content.getStrContent(), Toast.LENGTH_SHORT).show();
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
