package com.example.intrustcommunications;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUsFragment extends Fragment {

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


        return contactUs;
    }

}
