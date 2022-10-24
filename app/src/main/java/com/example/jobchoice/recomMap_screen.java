package com.example.jobchoice;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class recomMap_screen extends AppCompatActivity implements OnMapReadyCallback{
    GoogleMap mMap;
    Button goback_btn;
    FirstRecommend_screen firstrecommend_screen = new FirstRecommend_screen();
    SecondRecommend_screen secondRecommend_screen = new SecondRecommend_screen();
    ThirdRecommend_screen thirdRecommend_screen = new ThirdRecommend_screen();
    FourthRecommend_screen fourthRecommend_screen = new FourthRecommend_screen();
    FifthRecommend_screen fifthRecommend_screen = new FifthRecommend_screen();
    int CASE;
    double latitude = 0;
    double longtitude = 0;
    private static final int REQUEST_CODE = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recom_map_screen);

        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(this);
        CASE = getIntent().getIntExtra("CASE",0);
        /*goback_btn = findViewById(R.id.goback_btn);
        goback_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });*/
    }

    public void onMapReady(GoogleMap googleMap){
        mMap = googleMap;
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE);
            return;
        }
        mMap.setMyLocationEnabled(true);
        getLocation();
    }

    public void getLocation(){
        if(CASE == 0){
            Toast.makeText(this, "Cannot open the google map", Toast.LENGTH_SHORT).show();
        }else if(CASE == 1){
            latitude = firstrecommend_screen.ReturnLat();
            longtitude = firstrecommend_screen.ReturnLong();
            Toast.makeText(this, "Location : " + latitude + " , " + longtitude, Toast.LENGTH_SHORT).show();
            LatLng latLng = new LatLng(latitude, longtitude);
            MarkerOptions markerOptions = new MarkerOptions().position(latLng);
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longtitude), 16.0f));
            mMap.addMarker(markerOptions);
        }else if(CASE == 2){
            latitude = secondRecommend_screen.ReturnLat();
            longtitude = secondRecommend_screen.ReturnLong();
            Toast.makeText(this, "Location : " + latitude + " , " + longtitude, Toast.LENGTH_SHORT).show();
            LatLng latLng = new LatLng(latitude, longtitude);
            MarkerOptions markerOptions = new MarkerOptions().position(latLng);
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longtitude), 16.0f));
            mMap.addMarker(markerOptions);
        }else if(CASE == 3){
            latitude = thirdRecommend_screen.ReturnLat();
            longtitude = thirdRecommend_screen.ReturnLong();
            Toast.makeText(this, "Location : " + latitude + " , " + longtitude, Toast.LENGTH_SHORT).show();
            LatLng latLng = new LatLng(latitude, longtitude);
            MarkerOptions markerOptions = new MarkerOptions().position(latLng);
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longtitude), 16.0f));
            mMap.addMarker(markerOptions);
        }else if(CASE == 4){
            latitude = fourthRecommend_screen.ReturnLat();
            longtitude = fourthRecommend_screen.ReturnLong();
            Toast.makeText(this, "Location : " + latitude + " , " + longtitude, Toast.LENGTH_SHORT).show();
            LatLng latLng = new LatLng(latitude, longtitude);
            MarkerOptions markerOptions = new MarkerOptions().position(latLng);
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longtitude), 16.0f));
            mMap.addMarker(markerOptions);
        }
        else if(CASE == 5){
            latitude = fifthRecommend_screen.ReturnLat();
            longtitude = fifthRecommend_screen.ReturnLong();
            Toast.makeText(this, "Location : " + latitude + " , " + longtitude, Toast.LENGTH_SHORT).show();
            LatLng latLng = new LatLng(latitude, longtitude);
            MarkerOptions markerOptions = new MarkerOptions().position(latLng);
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longtitude), 16.0f));
            mMap.addMarker(markerOptions);
        }
    }

    /*public void goBack(){
        if(CASE == 1){
            Intent intent = new Intent(this, FirstRecommend_screen.class);
            startActivity(intent);
        }else if(CASE == 2){
            Intent intent = new Intent(this, SecondRecommend_screen.class);
            startActivity(intent);
        }
    }

    <androidx.appcompat.widget.AppCompatButton
    android:layout_below="@id/map"
    android:id="@+id/goback_btn"
    android:layout_width="match_parent"
    android:layout_height="50dp"
    android:background="@color/colorYellow"
    android:drawableLeft="@drawable/ic_baseline_arrow_back_ios_new_24"
    android:fontFamily="sans-serif-condensed-light"
    android:gravity="center"
    android:paddingLeft="10dp"
    android:text="GO BACK"
    android:textColor="@color/black"
    android:textSize="18sp"
    android:textStyle="bold" />*/
}