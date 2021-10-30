package com.example.dinhvi;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;

public class MainActivity extends AppCompatActivity{
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected Context context;
    private MyMap myMapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = this.getSupportFragmentManager();
        this.myMapFragment = (MyMap) fragmentManager.findFragmentById(R.id.map);

        getLocationCurrent();

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void getLocationCurrent(){
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            Log.d("IF","true");
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},1);
        }
        locationListener = new MyLocationListener();
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

    }



//    private void accept(){
//        try {
//            ActivityResultLauncher<String[]> locationPermissionRequest =
//                    registerForActivityResult(new ActivityResultContracts
//                                    .RequestMultiplePermissions(), result -> {
//                                Boolean fineLocationGranted = null;
//                                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
//                                    fineLocationGranted = result.getOrDefault(
//                                            Manifest.permission.ACCESS_FINE_LOCATION, false);
//                                }
//                                Boolean coarseLocationGranted = null;
//                                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
//                                    coarseLocationGranted = result.getOrDefault(
//                                            Manifest.permission.ACCESS_COARSE_LOCATION,false);
//                                }
//                                if (fineLocationGranted != null && fineLocationGranted) {
//                                    // Precise location access granted.
//                                } else if (coarseLocationGranted != null && coarseLocationGranted) {
//                                    // Only approximate location access granted.
//                                } else {
//                                    // No location access granted.
//                                }
//                            }
//                    );
//
//// ...
//
//// Before you perform the actual permission request, check whether your app
//// already has the permissions, and whether your app needs to show a permission
//// rationale dialog. For more details, see Request permissions.
//            locationPermissionRequest.launch(new String[] {
//                    Manifest.permission.ACCESS_FINE_LOCATION,
//                    Manifest.permission.ACCESS_COARSE_LOCATION
//            });
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }
//    @Override
//    protected void onPause() {
//        super.onPause();
//        if (ContextCompat.checkSelfPermission(this,
//                Manifest.permission.ACCESS_FINE_LOCATION)
//                == PackageManager.PERMISSION_GRANTED) {
//
//            locationManager.removeUpdates(this);
//        }
//    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (ContextCompat.checkSelfPermission(this,
//                Manifest.permission.ACCESS_FINE_LOCATION)
//                == PackageManager.PERMISSION_GRANTED) {
//
//            locationManager.removeUpdates(this);
//        }
//    }



}