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

import kotlin.Triple;


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
        map.getZoomController().setVisibility(CustomZoomButtonsController.Visibility.ALWAYS);
        map.setMultiTouchControls(true);

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
        Vector<Triple<GeoPoint, String, String>> geoPoints = new Vector<>();
        //doumou: if we keep the CustomMarkerInfoWindow implementation delete PinInfo class
//        geoPoints.add(new Pair<GeoPoint, PinInfo>(new GeoPoint(38.65323541747318, 22.99672185854556), new PinInfo("Epal Atalantis")));  // epal atalantis
//        geoPoints.add(new Pair<GeoPoint, PinInfo>(new GeoPoint(38.91434755941711, 21.78808330109529), new PinInfo("Epal Karpenisi")));  // epal Karpenisi
//        geoPoints.add(new Pair<GeoPoint, PinInfo>(new GeoPoint(38.021995410170824, 24.4226906500078), new PinInfo("Epal Karistos")));   // epal Karistos
//        geoPoints.add(new Pair<GeoPoint, PinInfo>(new GeoPoint(39.62433832411041, 19.90945654811451), new PinInfo("Epal Kerkira")));    // epal Kerkira
//        geoPoints.add(new Pair<GeoPoint, PinInfo>(new GeoPoint(38.920316991828095, 22.4242029097274), new PinInfo("Epal Lamia")));      // epal Lamia
//        geoPoints.add(new Pair<GeoPoint, PinInfo>(new GeoPoint(38.952468170983934, 22.1213511500289), new PinInfo("Epal Marakomi")));   // epal Marakomi
//        geoPoints.add(new Pair<GeoPoint, PinInfo>(new GeoPoint(38.45802788501172, 23.59682885371187), new PinInfo("Epal Xalkida")));    // epal Xalkida
//        geoPoints.add(new Pair<GeoPoint, PinInfo>(new GeoPoint(38.57270997805984, 23.63739658600231), new PinInfo("Epal Psaxna")));     // epal Psaxna

        geoPoints.add(new Triple<GeoPoint, String, String>(new GeoPoint(38.65323541747318, 22.99672185854556),getString(R.string.atalanti), "https://www.google.com/maps/place/38%C2%B039'11.7%22N+22%C2%B059'48.2%22E/@38.6532354,22.9945332,17z/data=!3m1!4b1!4m4!3m3!8m2!3d38.6532354!4d22.9967219"));  // epal atalantis
        geoPoints.add(new Triple<GeoPoint, String, String>(new GeoPoint(38.91434755941711, 21.78808330109529),getString(R.string.karpenisi), "https://www.google.com/maps?client=firefox-b-d&q=38.91434755941711,+21.78808330109529&um=1&ie=UTF-8&sa=X&ved=2ahUKEwicq8Lbs7H9AhXNm6QKHSZQC40Q_AUoAnoECAEQBA"));  // epal Karpenisi
        geoPoints.add(new Triple<GeoPoint, String, String>(new GeoPoint(38.021995410170824, 24.4226906500078),getString(R.string.karistos), "https://www.google.com/maps/place/38%C2%B001'19.2%22N+24%C2%B025'21.7%22E/@38.0219715,24.422044,18.38z/data=!4m4!3m3!8m2!3d38.0219954!4d24.4226907"));   // epal Karistos
        geoPoints.add(new Triple<GeoPoint, String, String>(new GeoPoint(39.62433832411041, 19.90945654811451),getString(R.string.kerkira), "https://www.google.com/maps/place/39%C2%B037'27.6%22N+19%C2%B054'34.0%22E/@39.624287,19.9086755,18.08z/data=!4m4!3m3!8m2!3d39.6243383!4d19.9094565"));    // epal Kerkira
        geoPoints.add(new Triple<GeoPoint, String, String>(new GeoPoint(38.920316991828095, 22.4242029097274),getString(R.string.lamia), "https://www.google.com/maps?client=firefox-b-d&q=38.920316991828095,+22.4242029097274&um=1&ie=UTF-8&sa=X&ved=2ahUKEwjT97GJtLH9AhVS2qQKHZCsBqkQ_AUoAnoECAEQBA"));      // epal Lamia
        geoPoints.add(new Triple<GeoPoint, String, String>(new GeoPoint(38.952468170983934, 22.1213511500289),getString(R.string.marakomi), "https://www.google.com/maps?client=firefox-b-d&q=38.952468170983934,+22.1213511500289&um=1&ie=UTF-8&sa=X&ved=2ahUKEwikrf-QtLH9AhU1JMUKHe7VAdUQ_AUoAnoECAEQBA"));   // epal Marakomi
        geoPoints.add(new Triple<GeoPoint, String, String>(new GeoPoint(38.45802788501172, 23.59682885371187),getString(R.string.xalkida), "https://www.google.com/maps?client=firefox-b-d&q=38.45802788501172,+23.59682885371187&um=1&ie=UTF-8&sa=X&ved=2ahUKEwiotemZtLH9AhXGjqQKHQ0ZAZ8Q_AUoAnoECAIQBA"));    // epal Xalkida
        geoPoints.add(new Triple<GeoPoint, String, String>(new GeoPoint(38.57270997805984, 23.63739658600231),getString(R.string.psaxna), "https://www.google.com/maps?client=firefox-b-d&q=38.57270997805984,+23.63739658600231&um=1&ie=UTF-8&sa=X&ved=2ahUKEwi8rNOhtLH9AhUP16QKHTfyCMEQ_AUoAnoECAEQBA"));     // epal Psaxna
        for (Integer i = 0; i < geoPoints.size(); i++)
        {
            Marker startMarker = new Marker(map);
            CustomMarkerInfoWindow customWindow = new CustomMarkerInfoWindow(map, geoPoints.get(i).getSecond(), geoPoints.get(i).getThird());
            startMarker.setIcon(getDrawable(R.drawable.pin));
            startMarker.setInfoWindow(customWindow);
            // doumou: if we keep CustomMarkerInfoWindow delete bellow 2 lines
            //startMarker.setImage(getDrawable(R.drawable.pininfo)); // for inside the cloud if default window
            //startMarker.setTitle(geoPoints.get(i).second.toString()); // for default window
            startMarker.setPosition(geoPoints.get(i).getFirst());
            startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_CENTER);
            map.getOverlays().add(startMarker);
        }
    }
//class not in another file because we need startActivity() for hyperLink
    public class CustomMarkerInfoWindow extends MarkerInfoWindow {

        public String schoolName;
        public String location;
        public CustomMarkerInfoWindow(MapView mapView, String theSchoolName, String theLocation) {
            super(R.layout.info_window, mapView);
            this.schoolName = theSchoolName;
            this.location = theLocation;
        }

        @Override
        public void onOpen(Object item) {
            TextView textView = (TextView) mView.findViewById(R.id.bubble_title);
            textView.setText(schoolName);
            Button button = (Button) mView.findViewById(R.id.bubble_moreinfo);
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
        }
        @Override
        public void onClose() {
            super.onClose();
            mMarkerRef = null;
            //by default, do nothing else
        }
    }
}
