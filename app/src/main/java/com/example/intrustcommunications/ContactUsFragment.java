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
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

/**
 * @author Bryan Beffa
 * @version 01.07.2019
 */
public class ContactUsFragment extends Fragment implements View.OnClickListener {

    /**
     * Constant that defines the fixed number.
     * Value 00353212355310.
     */
    private final String FIXED_NUMBER = "00353212355310";

    /**
     * Constant that defines the mobile number.
     * Value 00353872877025.
     */
    private final String MOBILE_NUMBER = "00353872877025";

    /**
     * Constant that defines the 'Intrust Communications' email.
     * Value mick.hull@intrustcommunications.ie
     */
    private final String MAIL_TO = "mick.hull@intrustcommunications.ie";

    /**
     * Constant that defines the map id.
     * Default value 5.
     */
    private final int MAP_ID = 5;

    /**
     * Attribute that defines the CurrentFragmentManager object.
     * Used to set the current item in the menu.
     */
    private CurrentFragmentManager cfManager;

    /**
     * Attribute that defines the navigationView.
     */
    private NavigationView navigationView;

    /**
     * Constructor that requires the CurrentFragmentManager and the NavigationView objects.
     *
     * @param cfManager      CurrentFragmentManager to set to cfManager attribute.
     * @param navigationView NavigationView to set to navigationView attribute.
     */
    public ContactUsFragment(CurrentFragmentManager cfManager, NavigationView navigationView) {
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

    /**
     * Method that set the listeners to the elements.
     *
     * @param view that contains the elements.
     */
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

        //get view id
        int id = view.getId();

        //check if the fixed label is clicked
        if (id == R.id.fixedLabel) {

            //call the fixed number
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
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // do nothing
                        }
                    }).show();

        }
        //check if the mobile label is clicked
        else if (id == R.id.mobileLabel) {

            //call the mobile number
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
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // do nothing
                        }
                    }).show();
        }
        //check if the mail label is clicked
        else if (id == R.id.mailLabel) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("Do you want to send an email?\n")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            //send email
                            Intent i = new Intent(Intent.ACTION_SEND);
                            i.setType("message/rfc822");
                            i.putExtra(Intent.EXTRA_EMAIL, new String[]{MAIL_TO});
                            try {
                                startActivity(Intent.createChooser(i, "Send mail..."));
                            } catch (android.content.ActivityNotFoundException ex) {
                            }
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // do nothing
                        }
                    }).show();
        }
        //check if the mapImage label is clicked
        else if (id == R.id.mapImage) {

            //replace the current fragment with the map fragment
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
