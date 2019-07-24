package com.example.intrustcommunications;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;

import com.google.android.material.navigation.NavigationView;

/**
 * @author Bryan Beffa
 * @version 01.07.2019
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

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
    public HomeFragment(CurrentFragmentManager cfManager, NavigationView navigationView) {
        this.cfManager = cfManager;
        this.navigationView = navigationView;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View homeView = inflater.inflate(R.layout.fragment_home, container, false);

        //set listeners
        setOnClickListeners(homeView);

        //set the video source
        //setVideoView(homeView);

        //set focus up
        ScrollView scrollView = homeView.findViewById(R.id.home_scroll_view);
        scrollView.fling(0);
        scrollView.smoothScrollTo(0, 0);

        return homeView;
    }

    /**
     * Method that set the listeners to the elements.
     *
     * @param view that contains the elements.
     */
    private void setOnClickListeners(View view) {
        //telesales know more button
        Button kmTelesales = (Button) view.findViewById(R.id.inboundKnowMore);
        kmTelesales.setOnClickListener(this);

        //web chat know more button
        Button kmWebChat = (Button) view.findViewById(R.id.chatWebKnowMore);
        kmWebChat.setOnClickListener(this);

        //back office know more button
        Button kmBackOffice = (Button) view.findViewById(R.id.backOfficeKnowMore);
        kmBackOffice.setOnClickListener(this);

        //customer retention know more button
        Button kmCustomerRetention = (Button) view.findViewById(R.id.customerRetentionKnowMore);
        kmCustomerRetention.setOnClickListener(this);

        //customer service know more button
        Button kmCustomerService = (Button) view.findViewById(R.id.customerServiceKnowMore);
        kmCustomerService.setOnClickListener(this);

        //customer service know more button
        Button kmLeadGeneration = (Button) view.findViewById(R.id.leadGenerationKnowMore);
        kmLeadGeneration.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        //get view id
        int id = view.getId();

        //check if the inbound know more button is clicked
        if (id == R.id.inboundKnowMore) {

            cfManager.setCurrentFragment(-1);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null);
            ft.replace(R.id.flMain, new TelesalesFragment(cfManager, navigationView));
            ft.commit();
        }
        //check if the web chat know more button is clicked
        else if (id == R.id.chatWebKnowMore) {

            cfManager.setCurrentFragment(-1);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null);
            ft.replace(R.id.flMain, new WebChatFragment(cfManager, navigationView));
            ft.commit();
        }
        //check if the back office know more button is clicked
        else if (id == R.id.backOfficeKnowMore) {

            cfManager.setCurrentFragment(-1);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null);
            ft.replace(R.id.flMain, new BackOfficeFragment(cfManager, navigationView));
            ft.commit();
        }
        //check if the customer know more button is clicked
        else if (id == R.id.customerServiceKnowMore) {

            cfManager.setCurrentFragment(-1);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null);
            ft.replace(R.id.flMain, new BackOfficeFragment(cfManager, navigationView));
            ft.commit();
        }
        //check if the customer know more button is clicked
        else if (id == R.id.customerRetentionKnowMore) {

            cfManager.setCurrentFragment(-1);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null);
            ft.replace(R.id.flMain, new CustomerRetentionFragment(cfManager, navigationView));
            ft.commit();
        }
        //check if the lead generation know more button is clicked
        else if (id == R.id.leadGenerationKnowMore) {

            cfManager.setCurrentFragment(-1);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null);
            ft.replace(R.id.flMain, new LeadGenerationFragment(cfManager, navigationView));
            ft.commit();
        }
    }
}
