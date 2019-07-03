package com.example.intrustcommunications;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ServicesFragment extends Fragment implements View.OnClickListener {


    public ServicesFragment() {
        // Required empty public constructor
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

    private void setOnClickListeners(View view) {
        //telesales know more button
        Button kmTelesales = (Button) view.findViewById(R.id.inboundKnowMore);
        kmTelesales.setOnClickListener(this);

        //webchat know more button
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
        int id = view.getId();

        if (id == R.id.inboundKnowMore) {
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain, new TelesalesFragment());
            ft.commit();
        } else if (id == R.id.chatWebKnowMore) {
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain, new WebChatFragment());
            ft.commit();
        } else if (id == R.id.backOfficeKnowMore) {
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain, new BackOfficeFragment());
            ft.commit();
        } else if (id == R.id.customerServiceKnowMore) {
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain, new BackOfficeFragment());
            ft.commit();
        } else if (id == R.id.customerRetentionKnowMore) {
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain, new CustomerRetentionFragment());
            ft.commit();
        } else if (id == R.id.leadGenerationKnowMore) {
            FragmentTransaction ft = getActivity(). getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain, new LeadGenerationFragment());
            ft.commit();
        }
    }

}
