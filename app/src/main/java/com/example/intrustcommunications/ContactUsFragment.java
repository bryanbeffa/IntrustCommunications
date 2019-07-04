package com.example.intrustcommunications;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUsFragment extends Fragment implements View.OnClickListener{

    private CurrentFragmentManager cfManager;

    public ContactUsFragment(CurrentFragmentManager cfManager) {
        // Required empty public constructor
        this.cfManager = cfManager;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View contactUs = inflater.inflate(R.layout.fragment_contact_us, container, false);

        setOnClickListeners(contactUs);

        return contactUs;
    }

    private void setOnClickListeners(View view) {
        //fixed label
        TextView fixedLabel = (TextView) view.findViewById(R.id.fixedLabel);
        fixedLabel.setOnClickListener(this);

        //mobile label
        TextView mobileLabel = (TextView) view.findViewById(R.id.mobileLabel);
        mobileLabel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.fixedLabel) {

        }
    }
}
