package com.example.thepr.activitytrackingapp;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Created by thepr on 4/9/2018.
 */

public class MainPortal extends TabActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainportal);

        TabHost tabHost = getTabHost();
        TabHost.TabSpec spec; //Resuable for each tab

        Intent intent; //Resuable for each tab

        intent = new Intent().setClass(this, TabStart.class);
        spec = tabHost.newTabSpec("start").setIndicator("Start").setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, TabSettings.class);
        spec = tabHost.newTabSpec("settings").setIndicator("Settings").setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, TabHistory.class);
        spec = tabHost.newTabSpec("history").setIndicator("History").setContent(intent);
        tabHost.addTab(spec);

        tabHost.setCurrentTab(1);

    }
}
