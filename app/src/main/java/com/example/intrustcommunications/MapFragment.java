package com.example.intrustcommunications;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * @author Bryan Beffa
 * @version 01.07.2019
 */
public class MapFragment extends Fragment implements OnMapReadyCallback, View.OnClickListener {

    /**
     * Attribute that defines the GoogleMap object.
     */
    private GoogleMap googleMap;

    /**
     * Attribute that defines the MapView object.
     */
    private MapView mapView;

    /**
     * Attribute that defines the current type of the google map.
     * Default value GoogleMap.MAP_TYPE_NORMAL (1).
     */
    private int type = GoogleMap.MAP_TYPE_NORMAL;

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
        this.googleMap.addMarker(new MarkerOptions().position(new LatLng(51.89268467972574, -8.364436626434326))
                .title("Intrust Communications"));

        CameraPosition intrust = CameraPosition.builder().target(new LatLng(51.89268467972574, -8.364436626434326)).zoom(16)
                .bearing(0).tilt(45).build();

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(intrust));
    }

    /**
     * Method that set the listeners to the elements.
     *
     * @param view that contains the elements.
     */
    private void setOnClickListeners(View view) {

        //normal map button
        Button normal = view.findViewById(R.id.normalMap);
        normal.setOnClickListener(this);

        //normal map button
        Button satellite = view.findViewById(R.id.satelliteMap);
        satellite.setOnClickListener(this);

        //terrain map button
        Button terrain = view.findViewById(R.id.terrainMap);
        terrain.setOnClickListener(this);

        //hybrid map button
        Button hybrid = view.findViewById(R.id.hybridMap);
        hybrid.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        //get view id
        int id = view.getId();

        //get buttons
        Button normal = getView().findViewById(R.id.normalMap);
        Button satellite = getView().findViewById(R.id.satelliteMap);
        Button terrain = getView().findViewById(R.id.terrainMap);
        Button hybrid = getView().findViewById(R.id.hybridMap);

        //set colors
        normal.setBackgroundColor(getResources().getColor(R.color.details_color));
        satellite.setBackgroundColor(getResources().getColor(R.color.details_color));
        terrain.setBackgroundColor(getResources().getColor(R.color.details_color));
        hybrid.setBackgroundColor(getResources().getColor(R.color.details_color));

        //check if the normal map button is clicked
        if (id == R.id.normalMap) {

            //set normal map
            if (type != GoogleMap.MAP_TYPE_NORMAL) {
                type = GoogleMap.MAP_TYPE_NORMAL;
                googleMap.setMapType(type);
            }
            normal.setBackgroundColor(getResources().getColor(R.color.button_selected));

        }
        //check if the satellite map button is clicked
        else if (id == R.id.satelliteMap) {

            //set satellite map
            if (type != GoogleMap.MAP_TYPE_SATELLITE) {
                type = GoogleMap.MAP_TYPE_SATELLITE;
                googleMap.setMapType(type);
            }
            satellite.setBackgroundColor(getResources().getColor(R.color.button_selected));

        }
        //check if the terrain map button is clicked
        else if (id == R.id.terrainMap) {

            //set satellite map
            if (type != GoogleMap.MAP_TYPE_TERRAIN) {
                type = GoogleMap.MAP_TYPE_TERRAIN;
                googleMap.setMapType(type);
            }
            terrain.setBackgroundColor(getResources().getColor(R.color.button_selected));

        }
        //check if the hybrid map button is clicked
        else if (id == R.id.hybridMap) {

            //set satellite map
            if (type != GoogleMap.MAP_TYPE_HYBRID) {
                type = GoogleMap.MAP_TYPE_HYBRID;
                googleMap.setMapType(type);
            }
            hybrid.setBackgroundColor(getResources().getColor(R.color.button_selected));
        }
    }
}
