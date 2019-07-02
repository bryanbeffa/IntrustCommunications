package com.example.intrustcommunications;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends Fragment {


    public AboutUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View aboutUsView = inflater.inflate(R.layout.fragment_about_us, container, false);

        //set focus up
        ScrollView scrollView = aboutUsView.findViewById(R.id.about_us_view);
        scrollView.fling(0);
        scrollView.smoothScrollTo(0, 0);

        return aboutUsView;
    }

}
