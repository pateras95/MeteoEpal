package com.example.meteoepal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.method.LinkMovementMethod;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
//import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Triple;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.CustomZoomButtonsController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.compass.CompassOverlay;
import org.osmdroid.views.overlay.infowindow.MarkerInfoWindow;


import java.util.ArrayList;
import java.util.Vector;

//import kotlin.Triple;


public class ActivityHome extends AppCompatActivity {

    private MapView map = null;
    private final int REQUEST_PERMISSIONS_REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Context ctx = this.getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
        map = findViewById(R.id.mapView);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.getController().setZoom(8.0);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home_btn);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.weather_btn:
                        Intent intent = new Intent(getApplicationContext(), ActivityEmyWeather.class);
                        startActivity(intent);
                        break;
                    case R.id.home_btn:
                        intent = new Intent(getApplicationContext(), ActivityHome.class);
                        startActivity(intent);;
                        break;
                    case R.id.info_btn:
                        intent = new Intent(getApplicationContext(), ActivityAtalanti.class);
                        startActivity(intent);;
                }
                return true;
            }
        });
        map.setMultiTouchControls(true);
//        doumou: The following doesn't look ok on circle map, delete them?
        map.getZoomController().setVisibility(CustomZoomButtonsController.Visibility.ALWAYS);
        CompassOverlay compassOverlay = new CompassOverlay(this, map);
        compassOverlay.enableCompass();
        map.getOverlays().add(compassOverlay);

        GeoPoint MapCenterPointOnStart = new GeoPoint(38.83438097933947, 21.774962757282207);
        setMapPins();
        map.getController().setCenter(MapCenterPointOnStart);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        ArrayList<String> permissionsToRequest = new ArrayList<>();
        for (int i = 0; i < grantResults.length; i++) {
            permissionsToRequest.add(permissions[i]);
        }
        if (permissionsToRequest.size() > 0) {
            ActivityCompat.requestPermissions(
                    this,
                    permissionsToRequest.toArray(new String[0]),
                    REQUEST_PERMISSIONS_REQUEST_CODE);
        }
    }

    private void requestPermissionsIfNecessary(String[] permissions) {
        ArrayList<String> permissionsToRequest = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission)
                    != PackageManager.PERMISSION_GRANTED) {
                permissionsToRequest.add(permission);
            }
        }
        if (permissionsToRequest.size() > 0) {
            ActivityCompat.requestPermissions(
                    this,
                    permissionsToRequest.toArray(new String[0]),
                    REQUEST_PERMISSIONS_REQUEST_CODE);
        }
    }

    private void setMapPins() {
        Vector<Pair<GeoPoint, SchoolInfo>> geoPoints = new Vector<>();
        geoPoints.add(new Pair<>(new GeoPoint(38.122276901851336, 23.864931531423043), new SchoolInfo(getString(R.string.dionisos), getString(R.string.dionisosURL),getString(R.string.dionisosPhone))));
        geoPoints.add(new Pair<>(new GeoPoint(39.6244072151634, 19.91026709786767), new SchoolInfo(getString(R.string.kerkira), getString(R.string.kerkiraURL), getString(R.string.kerkiraPhone))));
        geoPoints.add(new Pair<>(new GeoPoint(38.92042606103356, 22.423592718589948), new SchoolInfo(getString(R.string.lamia), getString(R.string.lamiaURL), getString(R.string.lamiaPhone))));
        geoPoints.add(new Pair<>(new GeoPoint(38.45807095740107, 23.597087048916933), new SchoolInfo(getString(R.string.xalkida), getString(R.string.xalkidaURL), getString(R.string.xalkidaPhone))));
        geoPoints.add(new Pair<>(new GeoPoint(35.3226004214979, 25.125163545979387), new SchoolInfo(getString(R.string.dimhrakleio), getString(R.string.dimhrakleioURL), getString(R.string.dimhrakleioPhone))));
        geoPoints.add(new Pair<>(new GeoPoint(38.653456036158786, 22.99719271998704), new SchoolInfo(getString(R.string.atalanti), getString(R.string.atalantiURL), getString(R.string.atalantiPhone))));
        geoPoints.add(new Pair<>(new GeoPoint(38.329990782307505, 23.336070776829448), new SchoolInfo(getString(R.string.thiba), getString(R.string.thibaURL), getString(R.string.thibaPhone))));
        geoPoints.add(new Pair<>(new GeoPoint(37.965796476805586, 23.757893708772837), new SchoolInfo(getString(R.string.kesariani), getString(R.string.kesarianiURL), getString(R.string.kesarianiPhone))));
        geoPoints.add(new Pair<>(new GeoPoint(38.91454545946067, 21.78850553003706), new SchoolInfo(getString(R.string.karpenisi), getString(R.string.karpenisiURL), getString(R.string.karpenisiPhone))));
        geoPoints.add(new Pair<>(new GeoPoint(38.02207991394976, 24.42263701299908), new SchoolInfo(getString(R.string.karistos), getString(R.string.karistosURL), getString(R.string.karistosPhone))));
        geoPoints.add(new Pair<>(new GeoPoint(38.952651702649774, 22.121769579540636), new SchoolInfo(getString(R.string.makrakomi), getString(R.string.makrakomiURL), getString(R.string.makrakomiPhone))));
        geoPoints.add(new Pair<>(new GeoPoint(40.741117628421776, 22.936559696451045), new SchoolInfo(getString(R.string.peiramthesallonikis), getString(R.string.peiramthesallonikisURL), getString(R.string.peiramthesallonikisPhone))));

        for (Integer i = 0; i < geoPoints.size(); i++)
        {
            Marker startMarker = new Marker(map);
            CustomMarkerInfoWindow customWindow = new CustomMarkerInfoWindow(map, geoPoints.get(i).second.getName(), geoPoints.get(i).second.getLocation(), geoPoints.get(i).second.getTelephone());
            startMarker.setIcon(getDrawable(R.drawable.mappin));

            startMarker.setInfoWindow(customWindow);

            // doumou: if we keep CustomMarkerInfoWindow delete bellow 2 lines
            //startMarker.setImage(getDrawable(R.drawable.pininfo)); // for inside the cloud if default window
            //startMarker.setTitle(geoPoints.get(i).second.toString()); // for default window

            startMarker.setPosition(geoPoints.get(i).first);
            startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_CENTER);
            map.getOverlays().add(startMarker);
        }
    }
//class not in another file because we need startActivity() for hyperLink
    public class CustomMarkerInfoWindow extends MarkerInfoWindow {

        public String schoolName;
        public String location;
        public String telephone;
        public CustomMarkerInfoWindow(MapView mapView, String theSchoolName, String theLocation, String theTelephone) {
            super(R.layout.info_window, mapView);
            this.schoolName = theSchoolName;
            this.location = theLocation;
            this.telephone = theTelephone;
        }

        @Override
        public void onOpen(Object item) {
            TextView textView = (TextView) mView.findViewById(R.id.bubble_title);
            textView.setText(schoolName);
            TextView textViewTel = (TextView) mView.findViewById(R.id.bubble_telephone);
            textViewTel.setText(getString(R.string.callSchool));
            Button button = (Button) mView.findViewById(R.id.bubble_moreinfo);
            Button buttonTel = (Button) mView.findViewById(R.id.bubble_telephone_button);
            button.setVisibility(View.VISIBLE);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(location));
                    startActivity(intent);
                }
            });

            buttonTel.setVisibility(View.VISIBLE);
            buttonTel.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse(telephone));
                    startActivity(intent);
                }
            });
        }
        @Override
        public void onClose() {
            super.onClose();
            mMarkerRef = null;
            //by default, do nothing else
        }
    }
}

