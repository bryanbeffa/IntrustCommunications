package com.example.intrustcommunications;


import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
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

    private final String FIXED_NUMBER = "00353212355310";
    private final String MOBILE_NUMBER = "00353872877025";

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

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("Do you want to call this number?\n" + FIXED_NUMBER)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            //call the mobile number
                            Intent i = new Intent(Intent.ACTION_DIAL);
                            String num = "tel:" + FIXED_NUMBER;
                            i.setData(Uri.parse(num));
                            startActivity(i);
                        }
                    })
                    .setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // do nothing
                        }
                    }).show();

        } else if(id == R.id.mobileLabel) {

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("Do you want to call this number?\n" + MOBILE_NUMBER)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            //call the mobile number
                            Intent i = new Intent(Intent.ACTION_DIAL);
                            String num = "tel:" + MOBILE_NUMBER;
                            i.setData(Uri.parse(num));
                            startActivity(i);
                        }
                    })
                    .setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // do nothing
                        }
            }).show();
        }
    }
}
