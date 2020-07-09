package com.example.example_bipolar_factory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private Toolbar mtoolbar;
    private ViewPager myviewPager;
    private TabLayout mytablayout;
    TabsAccessorAdaptor myTabsAccessorAdaptor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtoolbar = findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setTitle("Unsplash");


        myviewPager = findViewById(R.id.main_tab_pager);
        myTabsAccessorAdaptor = new TabsAccessorAdaptor(getSupportFragmentManager());
        myviewPager.setAdapter(myTabsAccessorAdaptor);


        mytablayout = findViewById(R.id.main_tabs);
        mytablayout.setupWithViewPager(myviewPager);

    }
}
