package com.example.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends AppCompatActivity {

    private GoogleMap mMap;
    Button Route1, Route2, Route3, Route4, Route5, Route6, Route7;
    SupportMapFragment supportMapFragment;
    FusedLocationProviderClient fusedLocationProviderClient;
    double currentLat = 0, currentLong = 0;
    int buttonclick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Route1 = findViewById(R.id.Route1);
        Route2 = findViewById(R.id.Route2);
        Route3 = findViewById(R.id.Route3);
        Route4 = findViewById(R.id.Route4);
        Route5 = findViewById(R.id.Route5);
        Route6 = findViewById(R.id.Route6);
        Route7 = findViewById(R.id.Route7);
        supportMapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.FragMap);
        fusedLocationProviderClient =
                LocationServices.getFusedLocationProviderClient(this);

        if (ActivityCompat.checkSelfPermission(MapsActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED) {
            getCurrentLocation();
        } else {
            ActivityCompat.requestPermissions(MapsActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 99);
        }

        Route1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mMap.clear();
                buttonclick = 1;
                direction();
            }
        });

        Route2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mMap.clear();
                buttonclick = 2;
                direction();
            }
        });

        Route3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mMap.clear();
                buttonclick = 3;
                direction();
            }
        });

        Route4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mMap.clear();
                buttonclick = 4;
                direction();
            }
        });

        Route5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mMap.clear();
                buttonclick = 5;
                direction();
            }
        });

        Route6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mMap.clear();
                buttonclick = 6;
                direction();
            }
        });

        Route7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mMap.clear();
                buttonclick = 7;
                direction();
            }
        });

    }

    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MapsActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 99);
            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null){
                    currentLat = location.getLatitude();
                    currentLong = location.getLongitude();
                    supportMapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(@NonNull GoogleMap googleMap) {
                            mMap = googleMap;
                            //mMap.getUiSettings().setZoomControlsEnabled(true);
                            LatLng curLatLng = new LatLng(currentLat, currentLong);
                            googleMap.addMarker(new MarkerOptions()
                                    .position(curLatLng)
                                    .title("Your Current Location")
                                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                                    new LatLng(currentLat, currentLong), 10));
                        }
                    });
                }
            }
        });
    }

    private void direction() {
        switch (buttonclick) {
            case 1:
                mMap.clear();
                String route1 = Uri.parse("https://maps.googleapis.com/maps/api/directions/json?" +
                                "origin=KL1109 Perpustakaan Um, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur&" +
                                "destination=KL1109 Perpustakaan Um, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "&waypoints=Pusat Asasi Sains (Dari Stn), 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|KL1110 Stadium Hoki KL, 59100 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|KL1803 KTM Angkasapuri, 58000 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|KL2129 Flat Sri Angkasa 2, 59200 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|KL1438 Bangsar South, Bangsar South, 59200 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|KL1103 Kolej Kediaman Pertama, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|KL1104 Jabatan Bioperubatan Um, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "&key=AIzaSyADRZgcBOKUBEgrMIOQ8jYSktygPI6T3dE")
                        .buildUpon()
                        .toString();
                RequestQueue requestQueue = Volley.newRequestQueue(this);
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, route1,
                        null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String status = response.getString("status");
                            if (status.equals("OK")) {
                                JSONArray routes = response.getJSONArray("routes");

                                ArrayList<LatLng> points;
                                PolylineOptions polylineOptions = null;

                                for (int i = 0; i < routes.length(); i++) {
                                    points = new ArrayList<>();
                                    polylineOptions = new PolylineOptions();
                                    JSONArray legs = routes.getJSONObject(i).getJSONArray("legs");

                                    for (int j = 0; j < legs.length(); j++) {
                                        JSONArray steps = legs.getJSONObject(j).getJSONArray("steps");

                                        for (int k = 0; k < steps.length(); k++) {
                                            String polyline = steps.getJSONObject(k).getJSONObject("polyline").getString("points");
                                            List<LatLng> list = decodePoly(polyline);

                                            for (int l = 0; l < list.size(); l++) {
                                                LatLng position = new LatLng((list.get(l)).latitude, (list.get(l)).longitude);
                                                points.add(position);
                                            }
                                        }
                                    }
                                    polylineOptions.addAll(points);
                                    polylineOptions.width(10);
                                    polylineOptions.color(ContextCompat.getColor(MapsActivity.this, R.color.purple_500));
                                    polylineOptions.geodesic(true);
                                }

                                mMap.addPolyline(polylineOptions);
                                mMap.addMarker(new MarkerOptions().position(new LatLng(3.1211240222960965, 101.65358479484728)).title("UM CENTRAL"));
                                mMap.addMarker(new MarkerOptions().position(new LatLng(3.1190387216498525, 101.65554380024646)).title("FACULTY OF ENGINEERING"));
                                mMap.addMarker(new MarkerOptions().position(new LatLng(3.118114144533776, 101.6593005050642)).title("TUANKU ABDUL RAHMAN RC (KK1)"));
                                mMap.addMarker(new MarkerOptions().position(new LatLng(3.1089164766156214, 101.66792998528508)).title("BANGSAR SOUTH"));
                                mMap.addMarker(new MarkerOptions().position(new LatLng(3.1074716106714577, 101.67094712293039)).title("PANTAI PERMAI"));
                                mMap.addMarker(new MarkerOptions().position(new LatLng(3.1123475108954652, 101.67346373191913)).title("ANGKASAPURI"));
                                mMap.addMarker(new MarkerOptions().position(new LatLng(3.118485194093005, 101.66502668467804)).title("STADIUM HOCKEY"));
                                mMap.addMarker(new MarkerOptions().position(new LatLng(3.121811438400477, 101.65826774245986)).title("PASUM"));
                                mMap.addMarker(new MarkerOptions().position(new LatLng(3.1211240222960965, 101.65358479484728)).title("UM CENTRAL"));
                                mMap.addMarker(new MarkerOptions().position(new LatLng(3.1218164273502196, 101.65707183555861)).title("CLOSEST BUS").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

                                LatLngBounds bounds = new LatLngBounds.Builder()
                                        .include(new LatLng(3.118485194093005, 101.66502668467804))
                                        .include(new LatLng(3.121811438400477, 101.65826774245986))
                                        .include(new LatLng(3.1211240222960965, 101.65358479484728)).build();
                                Point point = new Point();
                                getWindowManager().getDefaultDisplay().getSize(point);
                                mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, point.x, 150, 30));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                RetryPolicy retryPolicy = new DefaultRetryPolicy(30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                jsonObjectRequest.setRetryPolicy(retryPolicy);
                requestQueue.add(jsonObjectRequest);
                break;
            case 2:
                mMap.clear();
                String route2 = Uri.parse("https://maps.googleapis.com/maps/api/directions/json?" +
                                "origin=KL1109 Perpustakaan Um, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "&destination=KL1109 Perpustakaan Um, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "&waypoints=Rumah Antarabangsa Universiti Malaya, Jalan 17/2, Seksyen 17, 46400 Petaling Jaya, Selangor" +
                                "|533, Jalan 17/13, Seksyen 17, 46400 Petaling Jaya, Selangor" +
                                "|Happy Mansion Apartment, Seksyen 17, 46400 Petaling Jaya, Selangor" +
                                "|PJ220 Apartment Happy, Seksyen 17, 46400 Petaling Jaya, Selangor" +
                                "|PJ233 Shell Seksyen 17 (Opp), Seksyen 17, 46400 Petaling Jaya, Selangor" +
                                "|UIA PJ (Barat), Seksyen 17, 46350 Petaling Jaya, Selangor" +
                                "&key=AIzaSyADRZgcBOKUBEgrMIOQ8jYSktygPI6T3dE")
                        .buildUpon()
                        .toString();
                requestQueue = Volley.newRequestQueue(this);
                jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, route2,
                        null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String status = response.getString("status");
                            if (status.equals("OK")) {
                                JSONArray routes = response.getJSONArray("routes");

                                ArrayList<LatLng> points;
                                PolylineOptions polylineOptions = null;

                                for (int i = 0; i < routes.length(); i++) {
                                    points = new ArrayList<>();
                                    polylineOptions = new PolylineOptions();
                                    JSONArray legs = routes.getJSONObject(i).getJSONArray("legs");

                                    for (int j = 0; j < legs.length(); j++) {
                                        JSONArray steps = legs.getJSONObject(j).getJSONArray("steps");

                                        for (int k = 0; k < steps.length(); k++) {
                                            String polyline = steps.getJSONObject(k).getJSONObject("polyline").getString("points");
                                            List<LatLng> list = decodePoly(polyline);

                                            for (int l = 0; l < list.size(); l++) {
                                                LatLng position = new LatLng((list.get(l)).latitude, (list.get(l)).longitude);
                                                points.add(position);
                                            }
                                        }
                                    }
                                    polylineOptions.addAll(points);
                                    polylineOptions.width(10);
                                    polylineOptions.color(ContextCompat.getColor(MapsActivity.this, R.color.purple_500));
                                    polylineOptions.geodesic(true);
                                }
                                mMap.addPolyline(polylineOptions);
                                mMap.addMarker(new MarkerOptions().position(new LatLng(3.1211240222960965, 101.65358479484728)).title("UM CENTRAL"));
                                mMap.addMarker(new MarkerOptions().position(new LatLng(3.120766322355105, 101.63843569928407)).title("UIA PJ (BARAT)"));
                                mMap.addMarker(new MarkerOptions().position(new LatLng(3.1247187623224844, 101.63674612028392)).title("PJ233 SHELL 17/22"));
                                mMap.addMarker(new MarkerOptions().position(new LatLng(3.124716357835702, 101.63457518955354)).title("PJ220 HAPPY APARTMENT"));
                                mMap.addMarker(new MarkerOptions().position(new LatLng(3.123387083186662, 101.63401875024694)).title("PJ219 HAPPY MANSION"));
                                mMap.addMarker(new MarkerOptions().position(new LatLng(3.1222279273874554, 101.63393757850491)).title("SK SRI DAMAI"));
                                mMap.addMarker(new MarkerOptions().position(new LatLng(3.1198503844048298, 101.63704744302359)).title("INTERNATIONAL HOUSE"));
                                mMap.addMarker(new MarkerOptions().position(new LatLng(3.1211240222960965, 101.65358479484728)).title("UM CENTRAL"));
                                mMap.addMarker(new MarkerOptions().position(new LatLng(3.122672863454659, 101.63415188227286)).title("CLOSEST BUS").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

                                LatLngBounds bounds = new LatLngBounds.Builder()
                                        .include(new LatLng(3.1222279273874554, 101.63393757850491))
                                        .include(new LatLng(3.1198503844048298, 101.63704744302359))
                                        .include(new LatLng(3.1211240222960965, 101.65358479484728)).build();
                                Point point = new Point();
                                getWindowManager().getDefaultDisplay().getSize(point);
                                mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, point.x, 150, 30));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                retryPolicy = new DefaultRetryPolicy(30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                jsonObjectRequest.setRetryPolicy(retryPolicy);
                requestQueue.add(jsonObjectRequest);                break;
            case 3:
                mMap.clear();
                String route3 = Uri.parse("\n" +
                                "https://maps.googleapis.com/maps/api/directions/json?" +
                                "origin=KL1109 Perpustakaan Um, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "&destination=KL1109 Perpustakaan Um, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "&waypoints=kk9, 11, Jalan 16/4, Seksyen 16, 46350 Petaling Jaya, Federal Territory of Kuala Lumpur" +
                                "&key=AIzaSyADRZgcBOKUBEgrMIOQ8jYSktygPI6T3dE")
                        .buildUpon()
                        .toString();
                requestQueue = Volley.newRequestQueue(this);
                jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, route3,
                        null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String status = response.getString("status");
                            if (status.equals("OK")) {
                                JSONArray routes = response.getJSONArray("routes");

                                ArrayList<LatLng> points;
                                PolylineOptions polylineOptions = null;

                                for (int i = 0; i < routes.length(); i++) {
                                    points = new ArrayList<>();
                                    polylineOptions = new PolylineOptions();
                                    JSONArray legs = routes.getJSONObject(i).getJSONArray("legs");

                                    for (int j = 0; j < legs.length(); j++) {
                                        JSONArray steps = legs.getJSONObject(j).getJSONArray("steps");

                                        for (int k = 0; k < steps.length(); k++) {
                                            String polyline = steps.getJSONObject(k).getJSONObject("polyline").getString("points");
                                            List<LatLng> list = decodePoly(polyline);

                                            for (int l = 0; l < list.size(); l++) {
                                                LatLng position = new LatLng((list.get(l)).latitude, (list.get(l)).longitude);
                                                points.add(position);
                                            }
                                        }
                                    }
                                    polylineOptions.addAll(points);
                                    polylineOptions.width(10);
                                    polylineOptions.color(ContextCompat.getColor(MapsActivity.this, R.color.purple_500));
                                    polylineOptions.geodesic(true);
                                }
                                mMap.addPolyline(polylineOptions);
                                mMap.addMarker(new MarkerOptions().position(new LatLng(3.1211240222960965, 101.65358479484728)).title("UM CENTRAL"));
                                mMap.addMarker(new MarkerOptions().position(new LatLng(3.1202264622450238, 101.64647257596764)).title("TUN SYED ZAHIRUDDIN RC (KK9)"));
                                mMap.addMarker(new MarkerOptions().position(new LatLng(3.1211240222960965, 101.65358479484728)).title("UM CENTRAL"));
                                mMap.addMarker(new MarkerOptions().position(new LatLng(3.119939640458714, 101.64740285555766)).title("CLOSEST BUS").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));


                                LatLngBounds bounds = new LatLngBounds.Builder()
                                        .include(new LatLng(3.1202264622450238, 101.64647257596764))
                                        .include(new LatLng(3.1211240222960965, 101.65358479484728)).build();
                                Point point = new Point();
                                getWindowManager().getDefaultDisplay().getSize(point);
                                mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, point.x, 150, 30));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                retryPolicy = new DefaultRetryPolicy(30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                jsonObjectRequest.setRetryPolicy(retryPolicy);
                requestQueue.add(jsonObjectRequest);                break;

            case 4:
                mMap.clear();
                String route4 = Uri.parse("https://maps.googleapis.com/maps/api/directions/json?" +
                                "origin=KL1109 Perpustakaan Um, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "&destination=KL1109 Perpustakaan Um, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "&waypoints=Kolej Kediaman Keempat, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|Kolej Kediaman Kesepuluh, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|Padang B, Universiti Malaya, Lingkungan Budi, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|Pusat Sukan Um, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|Lingkaran Wawasan, 50603 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur" +
                                "|KL1103 Kolej Kediaman Pertama, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|Fakulti Kejuruteraan (Utara), 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "&key=AIzaSyADRZgcBOKUBEgrMIOQ8jYSktygPI6T3dE")
                        .buildUpon()
                        .toString();
                /* RequestQueue */ requestQueue = Volley.newRequestQueue(this);
                /*  JsonObjectRequest */ jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, route4,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        String status = response.getString("status");
                        if (status.equals("OK")) {
                            JSONArray routes = response.getJSONArray("routes");

                            ArrayList<LatLng> points;
                            PolylineOptions polylineOptions = null;

                            for (int i = 0; i < routes.length(); i++) {
                                points = new ArrayList<>();
                                polylineOptions = new PolylineOptions();
                                JSONArray legs = routes.getJSONObject(i).getJSONArray("legs");

                                for (int j = 0; j < legs.length(); j++) {
                                    JSONArray steps = legs.getJSONObject(j).getJSONArray("steps");

                                    for (int k = 0; k < steps.length(); k++) {
                                        String polyline = steps.getJSONObject(k).getJSONObject("polyline").getString("points");
                                        List<LatLng> list = decodePoly(polyline);

                                        for (int l = 0; l < list.size(); l++) {
                                            LatLng position = new LatLng((list.get(l)).latitude, (list.get(l)).longitude);
                                            points.add(position);
                                        }
                                    }
                                }
                                polylineOptions.addAll(points);
                                polylineOptions.width(10);
                                polylineOptions.color(ContextCompat.getColor(MapsActivity.this, R.color.purple_500));
                                polylineOptions.geodesic(true);
                            }

                            mMap.addPolyline(polylineOptions);
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1211240222960965, 101.65358479484728)).title("UM CENTRAL"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.119147533915066, 101.65554071643992)).title("FACULTY OF ENGINEERING"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1181874370688125, 101.65931455280479)).title("TUANKU ABDUL RAHMAN RC (KK1)"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1246137103601006, 101.66015483238992)).title("RAJA DR NAZRIN SHAH RC (KK12)"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.129173476891792, 101.66018834158484)).title("UNGKU AZIZ RC (KK11)"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1318711277407982, 101.65893591777935)).title("ACADEMY OF ISLAMIC STUDIES (API)"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.129862344452848, 101.65052535209972)).title("KINABALU/TUN AHMAD ZAIDI (KK8/10)"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1243616647361843, 101.65142092345111)).title("KURSHIAH/BESTARI/ZA'BA (KK3/4/7)"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1211240222960965, 101.65358479484728)).title("UM CENTRAL"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1266257945922606, 101.65138797784925)).title("CLOSEST BUS").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

                            LatLngBounds bounds = new LatLngBounds.Builder()
                                    .include(new LatLng(3.1243616647361843, 101.65142092345111))
                                    .include(new LatLng(3.1211240222960965, 101.65358479484728)).build();
                            Point point = new Point();
                            getWindowManager().getDefaultDisplay().getSize(point);
                            mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, point.x, 150, 30));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
                retryPolicy = new DefaultRetryPolicy(30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                jsonObjectRequest.setRetryPolicy(retryPolicy);
                requestQueue.add(jsonObjectRequest);
                break;

            case 5:
                mMap.clear();
                String route5 = Uri.parse("https://maps.googleapis.com/maps/api/directions/json?" +
                                "origin=KL1109 Perpustakaan Um, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "&destination=KL1109 Perpustakaan Um, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "&waypoints=Pusat Asasi Sains (Dari Stn), 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|Kolej Kediaman Kelima, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|Padang B, Universiti Malaya, Lingkungan Budi, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|Kolej Kediaman Kesepuluh, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|Fakulti Pengajian Melayu, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|Kolej Kediaman Keempat, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "&key=AIzaSyADRZgcBOKUBEgrMIOQ8jYSktygPI6T3dE")
                        .buildUpon()
                        .toString();
                /* RequestQueue */ requestQueue = Volley.newRequestQueue(this);
                /*  JsonObjectRequest */ jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, route5,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        String status = response.getString("status");
                        if (status.equals("OK")) {
                            JSONArray routes = response.getJSONArray("routes");

                            ArrayList<LatLng> points;
                            PolylineOptions polylineOptions = null;

                            for (int i = 0; i < routes.length(); i++) {
                                points = new ArrayList<>();
                                polylineOptions = new PolylineOptions();
                                JSONArray legs = routes.getJSONObject(i).getJSONArray("legs");

                                for (int j = 0; j < legs.length(); j++) {
                                    JSONArray steps = legs.getJSONObject(j).getJSONArray("steps");

                                    for (int k = 0; k < steps.length(); k++) {
                                        String polyline = steps.getJSONObject(k).getJSONObject("polyline").getString("points");
                                        List<LatLng> list = decodePoly(polyline);

                                        for (int l = 0; l < list.size(); l++) {
                                            LatLng position = new LatLng((list.get(l)).latitude, (list.get(l)).longitude);
                                            points.add(position);
                                        }
                                    }
                                }
                                polylineOptions.addAll(points);
                                polylineOptions.width(10);
                                polylineOptions.color(ContextCompat.getColor(MapsActivity.this, R.color.purple_500));
                                polylineOptions.geodesic(true);
                            }

                            mMap.addPolyline(polylineOptions);
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1211240222960965, 101.65358479484728)).title("UM CENTRAL"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1243616647361843, 101.65142092345111)).title("KURSHIAH/BESTARI/ZA'BA (KK3/4/7)"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.12618075749087, 101.65153991506988)).title("ACADEMY OF MALAY STUDIES (APM)"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.129862344452848, 101.65052535209972)).title("KINABALU/TUN AHMAD ZAIDI (KK8/10)"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1318711277407982, 101.65893591777935)).title("ACADEMY OF ISLAMIC STUDIES (API)"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.12668725353438, 101.65978710287438)).title("DAYASARI RC (KK5)"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.121698087122053, 101.65820308361941)).title("PASUM"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1211240222960965, 101.65358479484728)).title("UM CENTRAL"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.127012882105684, 101.65986185111491)).title("CLOSEST BUS").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

                            LatLngBounds bounds = new LatLngBounds.Builder()
                                    .include(new LatLng(3.1243616647361843, 101.65142092345111))
                                    .include(new LatLng(3.1211240222960965, 101.65358479484728)).build();
                            Point point = new Point();
                            getWindowManager().getDefaultDisplay().getSize(point);
                            mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, point.x, 150, 30));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
                retryPolicy = new DefaultRetryPolicy(30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                jsonObjectRequest.setRetryPolicy(retryPolicy);
                requestQueue.add(jsonObjectRequest);
                break;

            case 6:
                mMap.clear();
                String route6 = Uri.parse("\n" +
                                "https://maps.googleapis.com/maps/api/directions/json?" +
                                "origin=KL1109 Perpustakaan Um, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "&destination=KL1109 Perpustakaan Um, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "&waypoints=Pusat Asasi Sains (Dari Stn), 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|KL1803 KTM Angkasapuri, 58000 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|KL1437 Taman Bukit Angkasa (Timur), 59200 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|KL1441 KL Gateway - LRT Universiti, 59200 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|KL1103 Kolej Kediaman Pertama, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|Fakulti Kejuruteraan (Utara), 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "&key=AIzaSyADRZgcBOKUBEgrMIOQ8jYSktygPI6T3dE")
                        .buildUpon()
                        .toString();
                /* RequestQueue */ requestQueue = Volley.newRequestQueue(this);
                /*  JsonObjectRequest */ jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, route6,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        String status = response.getString("status");
                        if (status.equals("OK")) {
                            JSONArray routes = response.getJSONArray("routes");

                            ArrayList<LatLng> points;
                            PolylineOptions polylineOptions = null;

                            for (int i = 0; i < routes.length(); i++) {
                                points = new ArrayList<>();
                                polylineOptions = new PolylineOptions();
                                JSONArray legs = routes.getJSONObject(i).getJSONArray("legs");

                                for (int j = 0; j < legs.length(); j++) {
                                    JSONArray steps = legs.getJSONObject(j).getJSONArray("steps");

                                    for (int k = 0; k < steps.length(); k++) {
                                        String polyline = steps.getJSONObject(k).getJSONObject("polyline").getString("points");
                                        List<LatLng> list = decodePoly(polyline);

                                        for (int l = 0; l < list.size(); l++) {
                                            LatLng position = new LatLng((list.get(l)).latitude, (list.get(l)).longitude);
                                            points.add(position);
                                        }
                                    }
                                }
                                polylineOptions.addAll(points);
                                polylineOptions.width(10);
                                polylineOptions.color(ContextCompat.getColor(MapsActivity.this, R.color.purple_500));
                                polylineOptions.geodesic(true);
                            }

                            mMap.addPolyline(polylineOptions);
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1211240222960965, 101.65358479484728)).title("UM CENTRAL"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1190964604523206, 101.65553477784502)).title("FACULTY OF ENGINEERING"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.11819120085033, 101.65932018245245)).title("TUANKU ABDUL RAHMAN RC (KK1)"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.114480129334815, 101.6623499258223)).title("LRT UNIVERSITI"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.107284630480498, 101.67186854480967)).title("PANTAI PERMAI"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1123543094788273, 101.6734558893469)).title("ANGKASAPURI)"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.121698087122053, 101.65820308361941)).title("PASUM"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1211240222960965, 101.65358479484728)).title("UM CENTRAL"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.118396882820065, 101.65846755366373)).title("CLOSEST BUS").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));


                            LatLngBounds bounds = new LatLngBounds.Builder()
                                    .include(new LatLng(3.1243616647361843, 101.65142092345111))
                                    .include(new LatLng(3.1211240222960965, 101.65358479484728)).build();
                            Point point = new Point();
                            getWindowManager().getDefaultDisplay().getSize(point);
                            mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, point.x, 150, 30));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
                retryPolicy = new DefaultRetryPolicy(30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                jsonObjectRequest.setRetryPolicy(retryPolicy);
                requestQueue.add(jsonObjectRequest);
                break;

            case 7:
                mMap.clear();
                String route7 = Uri.parse("https://maps.googleapis.com/maps/api/directions/json?" +
                                "origin=Fakulti Kejuruteraan (Utara), 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "&destination=Fakulti Kejuruteraan (Utara), 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "&waypoints=KL1107 Dewan Tunku Canselor Um, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|Kolej Kediaman Kelima, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|Padang B, Universiti Malaya, Lingkungan Budi, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|Kolej Kediaman Keempat, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|KL1109 Perpustakaan Um, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|Fakulti Perniagaan Dan Perakaunan, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "|MRT Phileo Damansara Pintu A, Pusat Perdagangan Phileo Damansara, 60000 Petaling Jaya, Selangor" +
                                "|Rumah Antarabangsa Universiti Malaya, Jalan 17/2, Seksyen 17, 46400 Petaling Jaya, Selangor" +
                                "|KL1109 Perpustakaan Um, 50603 Kuala Lumpur, Federal Territory of Kuala Lumpur" +
                                "&key=AIzaSyADRZgcBOKUBEgrMIOQ8jYSktygPI6T3dE")
                        .buildUpon()
                        .toString();
                /* RequestQueue */ requestQueue = Volley.newRequestQueue(this);
                /*  JsonObjectRequest */ jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, route7,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        String status = response.getString("status");
                        if (status.equals("OK")) {
                            JSONArray routes = response.getJSONArray("routes");

                            ArrayList<LatLng> points;
                            PolylineOptions polylineOptions = null;

                            for (int i = 0; i < routes.length(); i++) {
                                points = new ArrayList<>();
                                polylineOptions = new PolylineOptions();
                                JSONArray legs = routes.getJSONObject(i).getJSONArray("legs");

                                for (int j = 0; j < legs.length(); j++) {
                                    JSONArray steps = legs.getJSONObject(j).getJSONArray("steps");

                                    for (int k = 0; k < steps.length(); k++) {
                                        String polyline = steps.getJSONObject(k).getJSONObject("polyline").getString("points");
                                        List<LatLng> list = decodePoly(polyline);

                                        for (int l = 0; l < list.size(); l++) {
                                            LatLng position = new LatLng((list.get(l)).latitude, (list.get(l)).longitude);
                                            points.add(position);
                                        }
                                    }
                                }
                                polylineOptions.addAll(points);
                                polylineOptions.width(10);
                                polylineOptions.color(ContextCompat.getColor(MapsActivity.this, R.color.purple_500));
                                polylineOptions.geodesic(true);
                            }

                            mMap.addPolyline(polylineOptions);
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1218134966014675, 101.65718832437923)).title("DEWAN TUNKU CANSELOR"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1190964604523206, 101.65553477784502)).title("FACULTY OF ENGINEERING"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1266884822941385, 101.65979850340653)).title("DAYASARI RC (KK5)"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1319516154051317, 101.65944707550723)).title("ACADEMY OF ISLAMIC STUDIES (API)"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1211240222960965, 101.65358479484728)).title("UM CENTRAL"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1244140321798297, 101.6514342954637)).title("KURSHIAH/BESTARI/ZA'BA (KK3/4/7)"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1183852179812215, 101.65428030163632)).title("FACULTY OF BUSINESS AND ECONOMICS)"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1284819787631295, 101.64277871937624)).title("MRT PHILEO DAMANSARA"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1198540057295703, 101.6370487806087)).title("INTERNATIONAL HOUSE"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1211240222960965, 101.65358479484728)).title("UM CENTRAL"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1190964604523206, 101.65553477784502)).title("FACULTY OF ENGINEERING"));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(3.1187611221068843, 101.65446388047432)).title("CLOSEST BUS").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));


                            LatLngBounds bounds = new LatLngBounds.Builder()
                                    .include(new LatLng(3.1243616647361843, 101.65142092345111))
                                    .include(new LatLng(3.1211240222960965, 101.65358479484728)).build();
                            Point point = new Point();
                            getWindowManager().getDefaultDisplay().getSize(point);
                            mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, point.x, 150, 30));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
                retryPolicy = new DefaultRetryPolicy(30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                jsonObjectRequest.setRetryPolicy(retryPolicy);
                requestQueue.add(jsonObjectRequest);
                break;
        }
    }

    private List<LatLng> decodePoly (String encoded){
        List<LatLng> poly = new ArrayList<>();
        int index = 0, len = encoded.length();
        int lat = 0, lng = 0;
        while (index < len) {
            int b, shift = 0, result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            LatLng p = new LatLng((((double) lat / 1E5)),
                    (((double) lng / 1E5)));
            poly.add(p);
        }
        return poly;
    }
}
