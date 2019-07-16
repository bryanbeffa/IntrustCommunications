package com.example.intrustcommunications;


import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.VideoView;

import com.google.android.material.navigation.NavigationView;

import java.util.zip.Inflater;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private CurrentFragmentManager cfManager;
    private NavigationView navigationView;

    public HomeFragment(CurrentFragmentManager cfManager, NavigationView navigationView) {
        // Required empty public constructor
        this.cfManager = cfManager;
        this.navigationView = navigationView;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View homeView = inflater.inflate(R.layout.fragment_home, container, false);

        //set listeners
        setOnClickListeners(homeView);

        //set the video source
        //setVideoView(homeView);

        //set focus up
        ScrollView scrollView = homeView.findViewById(R.id.home_scroll_view);
        scrollView.fling(0);
        scrollView.smoothScrollTo(0, 0);

        return homeView;
    }

    /*private void setVideoView(View view) {
        //find element
        VideoView video = (VideoView) view.findViewById(R.id.mickVideo);

        //create controller
        MediaController controller = new MediaController(getActivity());

        //set video source
        String path = "android.resource://com.example.intrustcommunications/" + R.raw.prova;
        Uri uri = Uri.parse(path);
        video.setVideoURI(uri);

        //set media controller
        video.setMediaController(controller);
        controller.setAnchorView(video);
    }*/

    private void setOnClickListeners(View view) {
        //telesales know more button
        Button kmTelesales = (Button) view.findViewById(R.id.inboundKnowMore);
        kmTelesales.setOnClickListener(this);

        //webchat know more button
        Button kmWebChat = (Button) view.findViewById(R.id.chatWebKnowMore);
        kmWebChat.setOnClickListener(this);

        //back office know more button
        Button kmBackOffice = (Button) view.findViewById(R.id.backOfficeKnowMore);
        kmBackOffice.setOnClickListener(this);

        //customer retention know more button
        Button kmCustomerRetention = (Button) view.findViewById(R.id.customerRetentionKnowMore);
        kmCustomerRetention.setOnClickListener(this);

        //customer service know more button
        Button kmCustomerService = (Button) view.findViewById(R.id.customerServiceKnowMore);
        kmCustomerService.setOnClickListener(this);

        //customer service know more button
        Button kmLeadGeneration = (Button) view.findViewById(R.id.leadGenerationKnowMore);
        kmLeadGeneration.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.inboundKnowMore) {

            cfManager.setCurrentFragment(-1);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null);
            ft.replace(R.id.flMain, new TelesalesFragment(cfManager, navigationView));
            ft.commit();
        } else if (id == R.id.chatWebKnowMore) {

            cfManager.setCurrentFragment(-1);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null);
            ft.replace(R.id.flMain, new WebChatFragment(cfManager, navigationView));
            ft.commit();
        } else if (id == R.id.backOfficeKnowMore) {

            cfManager.setCurrentFragment(-1);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null);
            ft.replace(R.id.flMain, new BackOfficeFragment(cfManager, navigationView));
            ft.commit();
        } else if (id == R.id.customerServiceKnowMore) {

            cfManager.setCurrentFragment(-1);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null);
            ft.replace(R.id.flMain, new BackOfficeFragment(cfManager, navigationView));
            ft.commit();
        } else if (id == R.id.customerRetentionKnowMore) {

            cfManager.setCurrentFragment(-1);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null);
            ft.replace(R.id.flMain, new CustomerRetentionFragment(cfManager, navigationView));
            ft.commit();
        } else if (id == R.id.leadGenerationKnowMore) {

            cfManager.setCurrentFragment(-1);
            FragmentTransaction ft = getActivity(). getSupportFragmentManager().beginTransaction().addToBackStack(null);
            ft.replace(R.id.flMain, new LeadGenerationFragment(cfManager, navigationView));
            ft.commit();
        }
    }
}
