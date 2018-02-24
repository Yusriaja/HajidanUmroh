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

import com.d4it_b.hajidanumroh.fragment.FragmentDAM;
import com.d4it_b.hajidanumroh.fragment.FragmentDoa;
import com.d4it_b.hajidanumroh.fragment.FragmentHaji;
import com.d4it_b.hajidanumroh.fragment.FragmentSholat;
import com.d4it_b.hajidanumroh.fragment.FragmentUmroh;
import com.d4it_b.hajidanumroh.model.haji.Haji;

import java.util.ArrayList;
import java.util.List;

public class PanduanActivity extends AppCompatActivity implements FragmentHaji.Detail{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panduan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        setupViewPager(viewPager);
//        adapter.addFragment(new FragmentDoa(), "Doa");
//        adapter.addFragment(new FragmentUmroh(), "Umroh");
//        adapter.addFragment(new FragmentHaji(), "Haji");
//        adapter.addFragment(new FragmentSholat(), "Sholat");
//        adapter.addFragment(new FragmentDAM(), "DAM");
//        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        FragmentHaji fragmentHaji = new FragmentHaji();
        fragmentHaji.setDetail(this);
        adapter.addFragment(fragmentHaji, "HAJI");

        FragmentSholat fragmentSholat = new FragmentSholat();
//        fragmentHaji.setDetail(this);
        adapter.addFragment(fragmentSholat, "Sholat");

        FragmentUmroh fragmentUmroh = new FragmentUmroh();
//        fragmentHaji.setDetail(this);
        adapter.addFragment(fragmentUmroh, "Umroh");

        FragmentDoa fragmentDoa = new FragmentDoa();
//        fragmentHaji.setDetail(this);
        adapter.addFragment(fragmentDoa, "DOA");

        FragmentDAM fragmentDAM = new FragmentDAM();
//        fragmentHaji.setDetail(this);
        adapter.addFragment(fragmentDAM, "DAM");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void detail(Haji haji) {
        Intent intent = new Intent(PanduanActivity.this, DetailHajiActivity.class);
        Bundle bundle = new Bundle();

        bundle.putInt("IdDetailHaji", haji.getId_haji());
        intent.putExtras(bundle);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), haji.getId_haji() + " , "+ haji.getString_haji(), Toast.LENGTH_SHORT).show();
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
