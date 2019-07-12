package com.example.intrustcommunications;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeadGenerationFragment extends Fragment implements View.OnClickListener {

    private final int CONTACT_US_ID = 6;
    private CurrentFragmentManager cfManager;
    private NavigationView navigationView;

    public LeadGenerationFragment(CurrentFragmentManager cfManager, NavigationView navigationView) {
        this.cfManager = cfManager;
        this.navigationView = navigationView;
    }

    private void setOnClickListeners(View view) {
        //first job button
        TextView contactUsButton = (TextView) view.findViewById(R.id.contactUsButton);
        contactUsButton.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View leadView = inflater.inflate(R.layout.fragment_lead_generation, container, false);

        //set listeners
        setOnClickListeners(leadView);

        return leadView;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.contactUsButton) {

            //check if is the current fragment
            if (cfManager.getCurrentFragment() != CONTACT_US_ID) {

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.anim.slide_in_right, 0);
                ft.replace(R.id.flMain, new ContactUsFragment(cfManager, navigationView));
                ft.commit();

                //check if the current is the last fragment
                cfManager.setCurrentFragment(CONTACT_US_ID);
                navigationView.setCheckedItem(R.id.nav_contact_us);
            }
        }
    }

}
