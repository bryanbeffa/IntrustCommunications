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
public class ServicesFragment extends Fragment implements View.OnClickListener {

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
    public ServicesFragment(CurrentFragmentManager cfManager, NavigationView navigationView) {
        // Required empty public constructor
        this.cfManager = cfManager;
        this.navigationView = navigationView;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View servicesView = inflater.inflate(R.layout.fragment_services, container, false);

        //set listeners
        setOnClickListeners(servicesView);

        return servicesView;
    }

    /**
     * Method that set the listeners to the elements.
     *
     * @param view that contains the elements.
     */
    private void setOnClickListeners(View view) {
        //telesales know more button
        Button kmTelesales = view.findViewById(R.id.inboundKnowMore);
        kmTelesales.setOnClickListener(this);

        //web chat know more button
        Button kmWebChat = view.findViewById(R.id.chatWebKnowMore);
        kmWebChat.setOnClickListener(this);

        //back office know more button
        Button kmBackOffice = view.findViewById(R.id.backOfficeKnowMore);
        kmBackOffice.setOnClickListener(this);

        //customer retention know more button
        Button kmCustomerRetention = view.findViewById(R.id.customerRetentionKnowMore);
        kmCustomerRetention.setOnClickListener(this);

        //customer service know more button
        Button kmCustomerService = view.findViewById(R.id.customerServiceKnowMore);
        kmCustomerService.setOnClickListener(this);

        //customer service know more button
        Button kmLeadGeneration = view.findViewById(R.id.leadGenerationKnowMore);
        kmLeadGeneration.setOnClickListener(this);

        //contact us button
        Button contactUsButton = view.findViewById(R.id.contactUsButton);
        contactUsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        //get view id
        int id = view.getId();

        //check if the inbound know more button is clicked
        if (id == R.id.inboundKnowMore) {

            cfManager.setCurrentFragment(-1);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain, new TelesalesFragment(cfManager, navigationView)).addToBackStack(null);
            ft.commit();
        }
        //check if the chat web know more button is clicked
        else if (id == R.id.chatWebKnowMore) {

            cfManager.setCurrentFragment(-1);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain, new WebChatFragment(cfManager, navigationView)).addToBackStack(null);
            ft.commit();
        }
        //check if the back office know more button is clicked
        else if (id == R.id.backOfficeKnowMore) {

            cfManager.setCurrentFragment(-1);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain, new BackOfficeFragment(cfManager, navigationView)).addToBackStack(null);
            ft.commit();
        }
        //check if the customer service know more button is clicked
        else if (id == R.id.customerServiceKnowMore) {

            cfManager.setCurrentFragment(-1);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain, new BackOfficeFragment(cfManager, navigationView)).addToBackStack(null);
            ft.commit();
        }
        //check if the customer retention know more button is clicked
        else if (id == R.id.customerRetentionKnowMore) {

            cfManager.setCurrentFragment(-1);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain, new CustomerRetentionFragment(cfManager, navigationView)).addToBackStack(null);
            ft.commit();
        }
        //check if the lead generation know more button is clicked
        else if (id == R.id.leadGenerationKnowMore) {

            cfManager.setCurrentFragment(-1);
            FragmentTransaction ft = getActivity(). getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain, new LeadGenerationFragment(cfManager, navigationView)).addToBackStack(null);
            ft.commit();
        }
        //check if the contact us know more button is clicked
        else if (id == R.id.contactUsButton) {

            //check if is the current fragment
            if(cfManager.getCurrentFragment() != CONTACT_US_ID) {

                //replace the current fragment with the contact us fragment
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
