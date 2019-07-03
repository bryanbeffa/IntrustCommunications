package com.example.intrustcommunications;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CareersFragment extends Fragment implements View.OnClickListener {


    public CareersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View careersView = inflater.inflate(R.layout.fragment_careers, container, false);

        //set listeners
        setOnClickListeners(careersView);

        return careersView;
    }

    private void setOnClickListeners(View view) {
        //first job button
        TextView firstJobButton = (TextView) view.findViewById(R.id.firstJobButton);
        firstJobButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.firstJobButton) {
            RelativeLayout relativeLayout = (RelativeLayout) getView().findViewById(R.id.firstJobContent);

            int visible = relativeLayout.getVisibility();
            if(visible == View.GONE) {
                relativeLayout.setVisibility(View.VISIBLE);
            } else {
                relativeLayout.setVisibility(View.GONE);
            }
        }
    }

}
