package com.example.intrustcommunications;

import android.net.Uri;
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
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        //set the video source
        setVideoView();

        //set listeners
        setOnClickListeners();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


    }

    private void setVideoView() {

        //find element
        VideoView video = (VideoView) findViewById(R.id.mickVideo);

        //create controller
        MediaController controller = new MediaController(MainActivity.this);

        //set video source
        String path = "android.resource://com.example.intrustcommunications/" + R.raw.prova;
        Uri uri = Uri.parse(path);
        video.setVideoURI(uri);

        //set media controller
        video.setMediaController(controller);
        controller.setAnchorView(video);
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

    private void setOnClickListeners() {
        //telesales know more button
        Button kmTelesales = (Button) findViewById(R.id.inboundKnowMore);
        kmTelesales.setOnClickListener(MainActivity.this);

        //webchat know more button
        Button kmWebChat = (Button) findViewById(R.id.chatWebKnowMore);
        kmWebChat.setOnClickListener(MainActivity.this);


        //back office know more button
        Button kmBackOffice = (Button) findViewById(R.id.backOfficeKnowMore);
        kmBackOffice.setOnClickListener(MainActivity.this);

        //customer retention know more button
        Button kmCustomerRetention = (Button) findViewById(R.id.customerRetentionKnowMore);
        kmCustomerRetention.setOnClickListener(MainActivity.this);

        //customer service know more button
        Button kmCustomerService = (Button) findViewById(R.id.customerServiceKnowMore);
        kmCustomerService.setOnClickListener(MainActivity.this);

        //customer service know more button
        Button kmLeadGeneration = (Button) findViewById(R.id.leadGenerationKnowMore);
        kmLeadGeneration.setOnClickListener(MainActivity.this);
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
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain, new HomeFragment());
            ft.commit();
        } else if (id == R.id.nav_about_us) {
            //FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //ft.replace(R.id.flMain, new AboutUsFragment());
            //ft.commit();
        } else if (id == R.id.nav_services) {

        } else if (id == R.id.nav_clients) {

        } else if (id == R.id.nav_career) {

        } else if (id == R.id.nav_contact_us) {

        } else if (id == R.id.nav_map) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.inboundKnowMore) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain, new TelesalesFragment());
            ft.commit();
        } else if (id == R.id.chatWebKnowMore) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain, new WebChatFragment());
            ft.commit();
        } else if (id == R.id.backOfficeKnowMore) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain, new BackOfficeFragment());
            ft.commit();
        } else if (id == R.id.customerServiceKnowMore) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain, new BackOfficeFragment());
            ft.commit();
        }
    }
}
