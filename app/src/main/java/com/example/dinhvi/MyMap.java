package com.example.dinhvi;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MyMap extends SupportMapFragment implements OnMapReadyCallback {

    private GoogleMap googleMap;

    public MyMap()  {
        getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap gmap) {
        this.googleMap = gmap;

        // Set default position
        // Add a marker in Sydney and move the camera
        LatLng vietnam = new LatLng(13.312603, 109.216048); // 14.0583° N, 108.2772° E
        this.googleMap.addMarker(new MarkerOptions().position(vietnam).title("Vị Trí Của Bạn"));
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(vietnam));

//        this.googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
//            @Override
//            public void onMapClick(LatLng latLng) {
//                MarkerOptions markerOptions = new MarkerOptions();
//                markerOptions.position(latLng);
//                markerOptions.title(latLng.latitude + " : "+ latLng.longitude);
//                // Clear previously click position.
//                googleMap.clear();
//                // Zoom the Marker
//                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
//                // Add Marker on Map
//                googleMap.addMarker(markerOptions);
//            }
//        });
    }
}