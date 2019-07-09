package com.example.intrustcommunications;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.android.material.navigation.NavigationView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoardFragment extends Fragment implements View.OnClickListener {

    private final int HOME_ID = 0;
    private final int ABOUT_US_ID = 1;
    private final int SERVICES_ID = 2;
    private final int CLIENTS_ID = 3;
    private final int CAREERS_ID = 4;
    private final int MAP_ID = 5;
    private final int CONTACT_US_ID = 6;

    private CurrentFragmentManager cfManager;
    private NavigationView navigationView;

    public DashBoardFragment(CurrentFragmentManager cfManager, NavigationView navigationView) {
        // Required empty public constructor
        this.cfManager = cfManager;
        this.navigationView = navigationView;
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setOnClickListeners(View view) {
        //home layout
        final CardView homeLayout = (CardView) view.findViewById(R.id.homeLayout);
        homeLayout.setOnClickListener(this);

        homeLayout.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    homeLayout.setCardBackgroundColor(getResources().getColor(R.color.selected_dash));

                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    homeLayout.setCardBackgroundColor(getResources().getColor(R.color.details_color));
                }
                return false;
            }
        });

        //about us layout
        final CardView aboutUsLayout = (CardView) view.findViewById(R.id.aboutUsLayout);
        aboutUsLayout.setOnClickListener(this);

        aboutUsLayout.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    aboutUsLayout.setCardBackgroundColor(getResources().getColor(R.color.selected_dash));

                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    aboutUsLayout.setCardBackgroundColor(getResources().getColor(R.color.bg_color));
                }
                return false;
            }
        });

        //services layout
        final CardView servicesLayout = (CardView) view.findViewById(R.id.servicesLayout);
        servicesLayout.setOnClickListener(this);

        servicesLayout.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    servicesLayout.setCardBackgroundColor(getResources().getColor(R.color.selected_dash));

                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    servicesLayout.setCardBackgroundColor(getResources().getColor(R.color.bg_color));
                }
                return false;
            }
        });

        //clients layout
        final CardView clientsLayout = (CardView) view.findViewById(R.id.clientsLayout);
        clientsLayout.setOnClickListener(this);

        clientsLayout.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    clientsLayout.setCardBackgroundColor(getResources().getColor(R.color.selected_dash));

                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    clientsLayout.setCardBackgroundColor(getResources().getColor(R.color.details_color));
                }
                return false;
            }
        });

        //careers layout
        final CardView careersLayout = (CardView) view.findViewById(R.id.careersLayout);
        careersLayout.setOnClickListener(this);

        careersLayout.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    careersLayout.setCardBackgroundColor(getResources().getColor(R.color.selected_dash));

                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    careersLayout.setCardBackgroundColor(getResources().getColor(R.color.details_color));
                }
                return false;
            }
        });

        //contact layout
        final CardView contactLayout = (CardView) view.findViewById(R.id.contactLayout);
        contactLayout.setOnClickListener(this);

        contactLayout.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    contactLayout.setCardBackgroundColor(getResources().getColor(R.color.selected_dash));

                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    contactLayout.setCardBackgroundColor(getResources().getColor(R.color.bg_color));
                }
                return false;
            }
        });

        //map layout
        final CardView mapLayout = (CardView) view.findViewById(R.id.mapLayout);
        mapLayout.setOnClickListener(this);

        mapLayout.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    mapLayout.setCardBackgroundColor(getResources().getColor(R.color.selected_dash));

                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    mapLayout.setCardBackgroundColor(getResources().getColor(R.color.details_color));
                }
                return false;
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View dashView = inflater.inflate(R.layout.fragment_dash_board, container, false);

        //set listeners
        setOnClickListeners(dashView);

        return dashView;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.homeLayout) {
            cfManager.setCurrentFragment(HOME_ID);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.slide_in_right, 0);
            ft.replace(R.id.flMain, new HomeFragment(cfManager));
            ft.commit();

            //set checked item
            navigationView.setCheckedItem(R.id.nav_home);
        } else if(id == R.id.aboutUsLayout) {
            cfManager.setCurrentFragment(ABOUT_US_ID);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.slide_in_right, 0);
            ft.replace(R.id.flMain, new AboutUsFragment(cfManager));
            ft.commit();

            //set checked item
            navigationView.setCheckedItem(R.id.nav_about_us);
        } else if(id == R.id.servicesLayout) {
            cfManager.setCurrentFragment(SERVICES_ID);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.slide_in_right, 0);
            ft.replace(R.id.flMain, new ServicesFragment(cfManager));
            ft.commit();

            //set checked item
            navigationView.setCheckedItem(R.id.nav_services);
        } else if(id == R.id.clientsLayout) {

        } else if(id == R.id.careersLayout) {
            cfManager.setCurrentFragment(CAREERS_ID);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.slide_in_right, 0);
            ft.replace(R.id.flMain, new CareersFragment());
            ft.commit();

            //set checked item
            navigationView.setCheckedItem(R.id.nav_career);
        } else if(id == R.id.contactLayout) {
            cfManager.setCurrentFragment(CONTACT_US_ID);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.slide_in_right, 0);
            ft.replace(R.id.flMain, new ContactUsFragment(cfManager));
            ft.commit();

            //set checked item
            navigationView.setCheckedItem(R.id.nav_contact_us);
        } else if(id == R.id.mapLayout) {

            cfManager.setCurrentFragment(MAP_ID);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.slide_in_right, 0);
            ft.replace(R.id.flMain, new MapFragment());
            ft.commit();

            //set checked item
            navigationView.setCheckedItem(R.id.nav_map);
        }
    }
}
