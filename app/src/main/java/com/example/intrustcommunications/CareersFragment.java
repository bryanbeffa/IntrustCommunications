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

        //second job button
        TextView secondJobButton = (TextView) view.findViewById(R.id.secondJobButton);
        secondJobButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        //set layouts
        RelativeLayout firstJobLayout = (RelativeLayout) getView().findViewById(R.id.firstJobContent);
        RelativeLayout secondJobLayout = (RelativeLayout) getView().findViewById(R.id.secondJobContent);

        int id = view.getId();

        if (id == R.id.firstJobButton) {

            //get first layout visibility
            int visible = firstJobLayout.getVisibility();

            if(visible == View.GONE) {

                //set layouts visibility
                firstJobLayout.setVisibility(View.VISIBLE);
                secondJobLayout.setVisibility(View.GONE);

            } else {
                firstJobLayout.setVisibility(View.GONE);
            }
        } if (id == R.id.secondJobButton) {

            //get layout visibility
            int visible = secondJobLayout.getVisibility();

            if(visible == View.GONE) {

                //set layouts visibility
                firstJobLayout.setVisibility(View.GONE);
                secondJobLayout.setVisibility(View.VISIBLE);

            } else {
                secondJobLayout.setVisibility(View.GONE);
            }
        }
    }

}
