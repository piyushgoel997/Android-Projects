package com.example.piyush.googleapis;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng delhi = new LatLng(28.1, 77.10);
        mMap.addMarker(new MarkerOptions().position(delhi).title("Marker in Delhi").snippet("Welcome to Delhi"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(delhi));

        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setCompassEnabled(!mMap.getUiSettings().isCompassEnabled()); // Toggle compass

//        CameraUpdate cu = CameraUpdateFactory.newLatLng(new LatLng(22, 77));
//        CameraUpdate cu2 = CameraUpdateFactory.zoomTo(14);
        CameraUpdate cu3 = CameraUpdateFactory.newCameraPosition(new CameraPosition(new LatLng(22, 77), 10, 2, 5));

//        mMap.animateCamera(cu);
        mMap.animateCamera(cu3, 200, new GoogleMap.CancelableCallback() {
            @Override
            public void onFinish() {

            }

            @Override
            public void onCancel() {

            }
        });

        // Instantiates a new Polyline object and adds points to define a rectangle
        PolylineOptions polyLine = new PolylineOptions()
                .add(new LatLng(28, 77))
                .add(new LatLng(30, 80));
        Polyline polyline = mMap.addPolyline(polyLine);
    }
}
