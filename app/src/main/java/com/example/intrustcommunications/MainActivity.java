package com.example.intrustcommunications;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;


import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private final int HOME_ID = 0;
    private final int ABOUT_US_ID = 1;
    private final int SERVICES_ID = 2;
    private final int CLIENTS_ID = 3;
    private final int CAREERS_ID = 4;
    private final int MAP_ID = 5;
    private final int CONTACT_US_ID = 6;

    private CurrentFragmentManager cfManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        //set current fragment manager
        cfManager = new CurrentFragmentManager();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flMain, new HomeFragment(cfManager));
        ft.commit();

        cfManager.setCurrentFragment(HOME_ID);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            //check if is the current fragment
            if(cfManager.getCurrentFragment() != HOME_ID) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.anim.slide_in_right, 0);
                HomeFragment home = new HomeFragment(cfManager);
                ft.replace(R.id.flMain, home);
                ft.commit();

                //check if the current is the last fragment
                cfManager.setCurrentFragment(HOME_ID);
            }
        } else if (id == R.id.nav_about_us) {

            //check if is the current fragment
            if(cfManager.getCurrentFragment() != ABOUT_US_ID) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.anim.slide_in_right, 0);
                ft.replace(R.id.flMain, new AboutUsFragment());
                ft.commit();

                //check if the current is the last fragment
                cfManager.setCurrentFragment(ABOUT_US_ID);
            }

        } else if (id == R.id.nav_services) {

            //check if is the current fragment
            if(cfManager.getCurrentFragment() != SERVICES_ID) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.anim.slide_in_right, 0);
                ft.replace(R.id.flMain, new ServicesFragment());
                ft.commit();

                //check if the current is the last fragment
                cfManager.setCurrentFragment(SERVICES_ID);
            }

        } else if (id == R.id.nav_clients) {

        } else if (id == R.id.nav_career) {
            //check if is the current fragment
            if(cfManager.getCurrentFragment() != CAREERS_ID) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.anim.slide_in_right, 0);
                ft.replace(R.id.flMain, new CareersFragment());
                ft.commit();

                //check if the current is the last fragment
                cfManager.setCurrentFragment(CAREERS_ID);
            }

        } else if (id == R.id.nav_contact_us) {

        } else if (id == R.id.nav_map) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
