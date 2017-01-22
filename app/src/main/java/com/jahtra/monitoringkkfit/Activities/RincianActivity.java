package com.jahtra.monitoringkkfit.Activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.jahtra.monitoringkkfit.Adapters.ViewPagerAdapter;
import com.jahtra.monitoringkkfit.Base.Base;
import com.jahtra.monitoringkkfit.Fragments.DummyFragment;
import com.jahtra.monitoringkkfit.R;

public class RincianActivity extends AppCompatActivity {

    private Base base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rincian);
        base = new Base(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tabanim_toolbar);
        setSupportActionBar(toolbar);
        ViewPager viewPager = (ViewPager) findViewById(R.id.tabanim_viewpager);
        setupViewPager(viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabanim_tabs);
        tabLayout.setupWithViewPager(viewPager);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle extras = getIntent().getExtras();
        int position = extras.getInt("position");
        String title = extras.getString("title");
        base.changeBarColor(toolbar, tabLayout, position);
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new DummyFragment(), "Penelitian");
        adapter.addFrag(new DummyFragment(), "Publikasi");
        adapter.addFrag(new DummyFragment(), "Pengmas");
        adapter.addFrag(new DummyFragment(), "Seminar");
        viewPager.setAdapter(adapter);
    }
}
