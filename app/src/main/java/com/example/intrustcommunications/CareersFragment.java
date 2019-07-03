package com.example.intrustcommunications;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

        //third job button
        TextView thirdJobButton = (TextView) view.findViewById(R.id.thirdJobButton);
        thirdJobButton.setOnClickListener(this);

        //fourth job button
        TextView fourthJobButton = (TextView) view.findViewById(R.id.fourthJobButton);
        fourthJobButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        //get layouts
        RelativeLayout firstJobLayout = (RelativeLayout) getView().findViewById(R.id.firstJobContent);
        RelativeLayout secondJobLayout = (RelativeLayout) getView().findViewById(R.id.secondJobContent);
        RelativeLayout thirdJobLayout = (RelativeLayout) getView().findViewById(R.id.thirdJobContent);
        RelativeLayout fourthJobLayout = (RelativeLayout) getView().findViewById(R.id.fourthJobContent);

        //get buttons
        TextView firstButton = (TextView) getView().findViewById(R.id.firstJobButton);
        TextView secondButton = (TextView) getView().findViewById(R.id.secondJobButton);
        TextView thirdButton = (TextView) getView().findViewById(R.id.thirdJobButton);
        TextView fourthButton = (TextView) getView().findViewById(R.id.fourthJobButton);

        int id = view.getId();

        if (id == R.id.firstJobButton) {

            //get first layout visibility
            int visible = firstJobLayout.getVisibility();

            if(visible == View.GONE) {

                //set layouts visibility
                firstJobLayout.setVisibility(View.VISIBLE);
                firstButton.setText("-");
                secondJobLayout.setVisibility(View.GONE);
                secondButton.setText("+");
                thirdJobLayout.setVisibility(View.GONE);
                thirdButton.setText("+");
                fourthJobLayout.setVisibility(View.GONE);
                fourthButton.setText("+");

            } else {
                firstJobLayout.setVisibility(View.GONE);

                //set button text
                firstButton.setText("+");
            }
        } else if (id == R.id.secondJobButton) {

            //get layout visibility
            int visible = secondJobLayout.getVisibility();

            if(visible == View.GONE) {

                //set layouts visibility
                firstJobLayout.setVisibility(View.GONE);
                firstButton.setText("+");
                secondJobLayout.setVisibility(View.VISIBLE);
                secondButton.setText("-");
                thirdJobLayout.setVisibility(View.GONE);
                thirdButton.setText("+");
                fourthJobLayout.setVisibility(View.GONE);
                fourthButton.setText("+");

            } else {
                secondJobLayout.setVisibility(View.GONE);

                //set button text
                secondButton.setText("+");
            }
        } else if (id == R.id.thirdJobButton) {

            //get layout visibility
            int visible = thirdJobLayout.getVisibility();

            if(visible == View.GONE) {

                //set layouts visibility
                firstJobLayout.setVisibility(View.GONE);
                firstButton.setText("+");
                secondJobLayout.setVisibility(View.GONE);
                secondButton.setText("+");
                thirdJobLayout.setVisibility(View.VISIBLE);
                thirdButton.setText("-");
                fourthJobLayout.setVisibility(View.GONE);
                fourthButton.setText("+");

            } else {
                thirdJobLayout.setVisibility(View.GONE);

                //set button text
                thirdButton.setText("+");

            }
        } else if (id == R.id.fourthJobButton) {

            //get layout visibility
            int visible = fourthJobLayout.getVisibility();

            if(visible == View.GONE) {

                //set layouts visibility
                firstJobLayout.setVisibility(View.GONE);
                firstButton.setText("+");
                secondJobLayout.setVisibility(View.GONE);
                secondButton.setText("+");
                thirdJobLayout.setVisibility(View.GONE);
                thirdButton.setText("+");
                fourthJobLayout.setVisibility(View.VISIBLE);
                fourthButton.setText("-");

            } else {
                fourthJobLayout.setVisibility(View.GONE);

                //set button text
                fourthButton.setText("+");
            }
        }
    }

}
