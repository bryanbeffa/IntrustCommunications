package com.example.intrustcommunications;


import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;


/**
 * @author Bryan Beffa
 * @version 01.07.2019
 */
public class ContactUsFragment extends Fragment implements View.OnClickListener{

    private final String FIXED_NUMBER = "00353212355310";
    private final String MOBILE_NUMBER = "00353872877025";
    private final String MAIL_TO = "mick.hull@intrustcommunications.ie";
    private final int MAP_ID = 5;

    private CurrentFragmentManager cfManager;
    private NavigationView navigationView;

    public ContactUsFragment(CurrentFragmentManager cfManager, NavigationView navigationView) {
        // Required empty public constructor
        this.cfManager = cfManager;
        this.navigationView = navigationView;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View contactUs = inflater.inflate(R.layout.fragment_contact_us, container, false);

        //set listeners
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

        //email field
        TextView emailLabel = (TextView) view.findViewById(R.id.mailLabel);
        emailLabel.setOnClickListener(this);

        //map image
        ImageView map = (ImageView) view.findViewById(R.id.mapImage);
        map.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.fixedLabel) {

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("Do you want to call this number?\n" + FIXED_NUMBER)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            //call the fixed number
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
        } else if (id == R.id.mailLabel) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("Do you want to send an email?\n")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            //send email
                            Intent i = new Intent(Intent.ACTION_SEND);
                            i.setType("message/rfc822");
                            i.putExtra(Intent.EXTRA_EMAIL  , new String[]{MAIL_TO});
                            try {
                                startActivity(Intent.createChooser(i, "Send mail..."));
                            } catch (android.content.ActivityNotFoundException ex) {
                            }
                        }
                    })
                    .setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // do nothing
                        }
                    }).show();
        } else if (id == R.id.mapImage) {
            cfManager.setCurrentFragment(MAP_ID);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.slide_in_right, 0);
            ft.replace(R.id.flMain, new MapFragment());
            ft.commit();

            //set checked item
            navigationView.setCheckedItem(R.id.nav_map);
        }
    }
}
