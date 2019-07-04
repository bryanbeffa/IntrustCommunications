package com.example.intrustcommunications;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends Fragment implements View.OnClickListener {

    private final int CONTACT_US_ID = 6;
    private CurrentFragmentManager cfManager;

    public AboutUsFragment(CurrentFragmentManager cfManager) {
        // Required empty public constructor
        this.cfManager = cfManager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View aboutUsView = inflater.inflate(R.layout.fragment_about_us, container, false);

        //set listeners
        setOnClickListeners(aboutUsView);

        return aboutUsView;
    }

    private void setOnClickListeners(View view) {
        //telesales know more button
        Button contactUsButton = (Button) view.findViewById(R.id.contactUsButton);
        contactUsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.contactUsButton) {

            cfManager.setCurrentFragment(CONTACT_US_ID);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.slide_in_right, 0);
            ft.replace(R.id.flMain, new ContactUsFragment(cfManager));
            ft.commit();

        }
    }
}
