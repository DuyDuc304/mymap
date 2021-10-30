package com.example.dinhvi;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

import androidx.core.content.ContextCompat;

public class MyLocationListener implements LocationListener {
    @Override
    public void onLocationChanged(Location location) {
        Log.d("Location","=============================================");
        Log.d("Location","Lat: "+location.getLatitude()+" ,Long: "+location.getLongitude());

    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
