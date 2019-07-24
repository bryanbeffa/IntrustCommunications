package com.example.intrustcommunications;

import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;

/**
 * @author Bryan Beffa
 * @version 01.07.2019
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /**
     * Constant that defines the home id.
     * Default value 0.
     */
    private final int HOME_ID = 0;

    /**
     * Constant that defines the about us id.
     * Default value 1.
     */
    private final int ABOUT_US_ID = 1;

    /**
     * Constant that defines the services id.
     * Default value 2.
     */
    private final int SERVICES_ID = 2;

    /**
     * Constant that defines the clients id.
     * Default value 3.
     */
    private final int CLIENTS_ID = 3;

    /**
     * Constant that defines the careers id.
     * Default value 4.
     */
    private final int CAREERS_ID = 4;

    /**
     * Constant that defines the map id.
     * Default value 5.
     */
    private final int MAP_ID = 5;

    /**
     * Constant that defines the contact us id.
     * Default value 6.
     */
    private final int CONTACT_US_ID = 6;

    /**
     * Constant that defines the dashboard id.
     * Default value 10.
     */
    private final int DASH_ID = 10;

    /**
     * Constant that defines the 'Intrust Communications' email.
     * Value mick.hull@intrustcommunications.ie
     */
    private final String MAIL_TO = "mick.hull@intrustcommunications.ie";

    /**
     * Attribute that defines the CurrentFragmentManager object.
     * Used to set the current item in the menu.
     */
    private CurrentFragmentManager cfManager;

    /**
     * Attribute that defines the navigationView.
     */
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        //set current fragment manager
        cfManager = new CurrentFragmentManager();

        //set home fragment
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flMain, new DashBoardFragment(cfManager, navigationView));
        ft.commit();

        //set selected item menu
        navigationView.setCheckedItem(R.id.nav_dashboard);
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
        //getMenuInflater().inflate(R.menu.main, menu);
        //return true;
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //check if the nav home is selected
        if (id == R.id.nav_home) {

            //check if is the current fragment
            if (cfManager.getCurrentFragment() != HOME_ID) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.anim.slide_in_right, 0);
                HomeFragment home = new HomeFragment(cfManager, navigationView);
                ft.replace(R.id.flMain, home);
                ft.commit();

                //check if the current is the last fragment
                cfManager.setCurrentFragment(HOME_ID);

            }

        }
        //check if the nav dashboard is selected
        else if (id == R.id.nav_dashboard) {

            //check if is the current fragment
            if (cfManager.getCurrentFragment() != DASH_ID) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.anim.slide_in_right, 0);
                ft.replace(R.id.flMain, new DashBoardFragment(cfManager, navigationView));
                ft.commit();

                //check if the current is the last fragment
                cfManager.setCurrentFragment(DASH_ID);

            }

        }
        //check if the nav about us is selected
        else if (id == R.id.nav_about_us) {

            //check if is the current fragment
            if (cfManager.getCurrentFragment() != ABOUT_US_ID) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.anim.slide_in_right, 0);
                ft.replace(R.id.flMain, new AboutUsFragment(cfManager, navigationView));
                ft.commit();

                //check if the current is the last fragment
                cfManager.setCurrentFragment(ABOUT_US_ID);

            }

        }
        //check if the nav services is selected
        else if (id == R.id.nav_services) {

            //check if is the current fragment
            if (cfManager.getCurrentFragment() != SERVICES_ID) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.anim.slide_in_right, 0);
                ft.replace(R.id.flMain, new ServicesFragment(cfManager, navigationView));
                ft.commit();

                //check if the current is the last fragment
                cfManager.setCurrentFragment(SERVICES_ID);

            }

        }
        //check if the nav clients is selected
        else if (id == R.id.nav_clients) {

            //check if is the current fragment
            if (cfManager.getCurrentFragment() != CLIENTS_ID) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.anim.slide_in_right, 0);
                ft.replace(R.id.flMain, new ClientsFragment(cfManager, navigationView));
                ft.commit();

                //check if the current is the last fragment
                cfManager.setCurrentFragment(CLIENTS_ID);

            }

        }
        //check if the nav career is selected
        else if (id == R.id.nav_career) {
            //check if is the current fragment
            if (cfManager.getCurrentFragment() != CAREERS_ID) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.anim.slide_in_right, 0);
                ft.replace(R.id.flMain, new CareersFragment());
                ft.commit();

                //check if the current is the last fragment
                cfManager.setCurrentFragment(CAREERS_ID);

            }

        }
        //check if the nav contact us is selected
        else if (id == R.id.nav_contact_us) {

            //check if is the current fragment
            if (cfManager.getCurrentFragment() != CONTACT_US_ID) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.anim.slide_in_right, 0);
                ft.replace(R.id.flMain, new ContactUsFragment(cfManager, navigationView));
                ft.commit();

                //check if the current is the last fragment
                cfManager.setCurrentFragment(CONTACT_US_ID);
            }

        }
        //check if the nav map is selected
        else if (id == R.id.nav_map) {
            //check if is the current fragment
            if (cfManager.getCurrentFragment() != MAP_ID) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.anim.slide_in_right, 0);
                ft.replace(R.id.flMain, new MapFragment());
                ft.commit();

                //check if the current is the last fragment
                cfManager.setCurrentFragment(MAP_ID);
            }
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
