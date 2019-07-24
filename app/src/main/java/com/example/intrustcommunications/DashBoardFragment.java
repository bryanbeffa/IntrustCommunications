package com.example.intrustcommunications;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.google.android.material.navigation.NavigationView;

/**
 * @author Bryan Beffa
 * @version 01.07.2019
 */
public class DashBoardFragment extends Fragment implements View.OnClickListener {

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
     * Attribute that defines the CurrentFragmentManager object.
     * Used to set the current item in the menu.
     */
    private CurrentFragmentManager cfManager;

    /**
     * Attribute that defines the navigationView.
     */
    private NavigationView navigationView;

    /**
     * Constructor that requires the CurrentFragmentManager and the NavigationView objects.
     *
     * @param cfManager      CurrentFragmentManager to set to cfManager attribute.
     * @param navigationView NavigationView to set to navigationView attribute.
     */
    public DashBoardFragment(CurrentFragmentManager cfManager, NavigationView navigationView) {
        this.cfManager = cfManager;
        this.navigationView = navigationView;
    }

    /**
     * Method that set the listeners to the elements.
     *
     * @param view that contains the elements.
     */
    @SuppressLint("ClickableViewAccessibility")
    private void setOnClickListeners(View view) {
        //home layout
        final CardView homeLayout = (CardView) view.findViewById(R.id.homeLayout);
        homeLayout.setOnClickListener(this);

        homeLayout.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    homeLayout.setCardBackgroundColor(getResources().getColor(R.color.selected_dash_dark));
                }
                return false;
            }
        });

        //about us layout
        final CardView aboutUsLayout = (CardView) view.findViewById(R.id.aboutUsLayout);
        aboutUsLayout.setOnClickListener(this);

        aboutUsLayout.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    aboutUsLayout.setCardBackgroundColor(getResources().getColor(R.color.selected_dash_light));

                }
                return false;
            }
        });

        //services layout
        final CardView servicesLayout = (CardView) view.findViewById(R.id.servicesLayout);
        servicesLayout.setOnClickListener(this);

        servicesLayout.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    servicesLayout.setCardBackgroundColor(getResources().getColor(R.color.selected_dash_light));

                }
                return false;
            }
        });

        //clients layout
        final CardView clientsLayout = (CardView) view.findViewById(R.id.clientsLayout);
        clientsLayout.setOnClickListener(this);

        clientsLayout.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    clientsLayout.setCardBackgroundColor(getResources().getColor(R.color.selected_dash_dark));

                }
                return false;
            }
        });

        //careers layout
        final CardView careersLayout = (CardView) view.findViewById(R.id.careersLayout);
        careersLayout.setOnClickListener(this);

        careersLayout.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    careersLayout.setCardBackgroundColor(getResources().getColor(R.color.selected_dash_dark));

                }
                return false;
            }
        });

        //contact layout
        final CardView contactLayout = (CardView) view.findViewById(R.id.contactLayout);
        contactLayout.setOnClickListener(this);

        contactLayout.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    contactLayout.setCardBackgroundColor(getResources().getColor(R.color.selected_dash_light));
                }
                return false;
            }
        });

        //map layout
        final CardView mapLayout = (CardView) view.findViewById(R.id.mapLayout);
        mapLayout.setOnClickListener(this);

        mapLayout.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    mapLayout.setCardBackgroundColor(getResources().getColor(R.color.selected_dash_dark));
                }
                return false;
            }
        });

        //map layout
        final ScrollView main = (ScrollView) view.findViewById(R.id.scrollView);
        main.setOnClickListener(this);

        main.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    homeLayout.setCardBackgroundColor(getResources().getColor(R.color.details_color));
                    aboutUsLayout.setCardBackgroundColor(getResources().getColor(R.color.bg_color));
                    servicesLayout.setCardBackgroundColor(getResources().getColor(R.color.bg_color));
                    clientsLayout.setCardBackgroundColor(getResources().getColor(R.color.details_color));
                    careersLayout.setCardBackgroundColor(getResources().getColor(R.color.details_color));
                    contactLayout.setCardBackgroundColor(getResources().getColor(R.color.bg_color));
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

        //get view id
        int id = view.getId();

        //check if the home layout is clicked
        if (id == R.id.homeLayout) {
            cfManager.setCurrentFragment(HOME_ID);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.slide_in_right, 0);
            ft.replace(R.id.flMain, new HomeFragment(cfManager, navigationView));
            ft.commit();

            //set checked item
            navigationView.setCheckedItem(R.id.nav_home);
        }
        //check if the about us layout is clicked
        else if (id == R.id.aboutUsLayout) {
            cfManager.setCurrentFragment(ABOUT_US_ID);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.slide_in_right, 0);
            ft.replace(R.id.flMain, new AboutUsFragment(cfManager, navigationView));
            ft.commit();

            //set checked item
            navigationView.setCheckedItem(R.id.nav_about_us);
        }
        //check if the services layout is clicked
        else if (id == R.id.servicesLayout) {
            cfManager.setCurrentFragment(SERVICES_ID);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.slide_in_right, 0);
            ft.replace(R.id.flMain, new ServicesFragment(cfManager, navigationView));
            ft.commit();

            //set checked item
            navigationView.setCheckedItem(R.id.nav_services);
        }
        //check if the clients layout is clicked
        else if (id == R.id.clientsLayout) {
            cfManager.setCurrentFragment(CLIENTS_ID);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.slide_in_right, 0);
            ft.replace(R.id.flMain, new ClientsFragment(cfManager, navigationView));
            ft.commit();

            //set checked item
            navigationView.setCheckedItem(R.id.nav_clients);
        }
        //check if the careers layout is clicked
        else if (id == R.id.careersLayout) {
            cfManager.setCurrentFragment(CAREERS_ID);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.slide_in_right, 0);
            ft.replace(R.id.flMain, new CareersFragment());
            ft.commit();

            //set checked item
            navigationView.setCheckedItem(R.id.nav_career);
        }
        //check if the contact layout is clicked
        else if (id == R.id.contactLayout) {
            cfManager.setCurrentFragment(CONTACT_US_ID);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.slide_in_right, 0);
            ft.replace(R.id.flMain, new ContactUsFragment(cfManager, navigationView));
            ft.commit();

            //set checked item
            navigationView.setCheckedItem(R.id.nav_contact_us);
        }
        //check if the map layout is clicked
        else if (id == R.id.mapLayout) {

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
