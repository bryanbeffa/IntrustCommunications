package com.example.intrustcommunications;


import android.graphics.Camera;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap googleMap;
    private MapView mapView;
    private int type = GoogleMap.MAP_TYPE_NORMAL;

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        //set listeners
        setOnClickListeners(view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapView = (MapView) view.findViewById(R.id.mapLayout);
        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());

        this.googleMap = googleMap;
        this.googleMap.setMapType(type);

        this.googleMap.addMarker(new MarkerOptions().position(new LatLng(51.8926602, -8.364457921))
                .title("Intrust Communications"));

        CameraPosition intrust = CameraPosition.builder().target(new LatLng(51.8926602, -8.364457921)).zoom(16)
                .bearing(0).tilt(45).build();

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(intrust));
    }

    private void setOnClickListeners(View view) {

        //normal map button
        Button normal = (Button) view.findViewById(R.id.normalMap);
        normal.setOnClickListener(this);

        //normal map button
        Button satellite = (Button) view.findViewById(R.id.satelliteMap);
        satellite.setOnClickListener(this);

        //terrain map button
        Button terrain = (Button) view.findViewById(R.id.terrainMap);
        terrain.setOnClickListener(this);

        //hybrid map button
        Button hybrid = (Button) view.findViewById(R.id.hybridMap);
        hybrid.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        //get buttons
        Button normal = (Button) getView().findViewById(R.id.normalMap);
        Button satellite = (Button) getView().findViewById(R.id.satelliteMap);
        Button terrain = (Button) getView().findViewById(R.id.terrainMap);
        Button hybrid = (Button) getView().findViewById(R.id.hybridMap);

        //set colors
        normal.setBackgroundColor(getResources().getColor(R.color.details_color));
        satellite.setBackgroundColor(getResources().getColor(R.color.details_color));
        terrain.setBackgroundColor(getResources().getColor(R.color.details_color));
        hybrid.setBackgroundColor(getResources().getColor(R.color.details_color));

        if(id == R.id.normalMap) {

            //set normal map
            type = GoogleMap.MAP_TYPE_NORMAL;
            normal.setBackgroundColor(getResources().getColor(R.color.button_selected));

        } else if(id == R.id.satelliteMap) {

            //set satellite map
            type = GoogleMap.MAP_TYPE_SATELLITE;
            satellite.setBackgroundColor(getResources().getColor(R.color.button_selected));

        } else if(id == R.id.terrainMap) {

            //set satellite map
            type = GoogleMap.MAP_TYPE_TERRAIN;
            terrain.setBackgroundColor(getResources().getColor(R.color.button_selected));

        } else if(id == R.id.hybridMap) {

            //set satellite map
            type = GoogleMap.MAP_TYPE_HYBRID;
            hybrid.setBackgroundColor(getResources().getColor(R.color.button_selected));
        }

        googleMap.setMapType(type);
    }
}
