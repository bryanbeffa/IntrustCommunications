package com.example.intrustcommunications;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

/**
 * @author Bryan Beffa
 * @version 01.07.2019
 */
public class ClientsFragment extends Fragment implements View.OnClickListener {

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
     * @param cfManager CurrentFragmentManager to set to cfManager attribute.
     * @param navigationView NavigationView to set to navigationView attribute.
     */
    public ClientsFragment(CurrentFragmentManager cfManager, NavigationView navigationView) {
        this.cfManager = cfManager;
        this.navigationView = navigationView;
    }

    /**
     * Method that set the listeners to the elements.
     *
     * @param view that contains the elements.
     */
    private void setOnClickListeners(View view) {
        //contact us button
        Button contactUsButton = (Button) view.findViewById(R.id.contactUsButton);
        contactUsButton.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View clientsView = inflater.inflate(R.layout.fragment_clients, container, false);

        //set listeners
        setOnClickListeners(clientsView);

        return clientsView;
    }

    @Override
    public void onClick(View view) {

        //get view id
        int id = view.getId();

        //check if the contact us button is clicked
        if (id == R.id.contactUsButton) {

            //check if is the current fragment
            if (cfManager.getCurrentFragment() != CONTACT_US_ID) {

                //replace the current fragment with the contact us fragment
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.anim.slide_in_right, 0);
                ft.replace(R.id.flMain, new ContactUsFragment(cfManager, navigationView));
                ft.commit();

                //check if the current is the last fragment
                cfManager.setCurrentFragment(CONTACT_US_ID);

                //set the contact us item
                navigationView.setCheckedItem(R.id.nav_contact_us);
            }
        }
    }
}
