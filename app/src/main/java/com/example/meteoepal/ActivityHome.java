package com.example.meteoepal;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Pair;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.CustomZoomButtonsController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.compass.CompassOverlay;

import java.util.ArrayList;
import java.util.Vector;


public class ActivityHome extends AppCompatActivity {

    private MapView map = null;
    private final int REQUEST_PERMISSIONS_REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Context ctx = this.getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
        map = findViewById(R.id.mapView);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.getController().setZoom(8.0);

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
        Vector<Pair<GeoPoint, PinInfo>> geoPoints = new Vector<>();
        geoPoints.add(new Pair<GeoPoint, PinInfo>(new GeoPoint(38.65323541747318, 22.99672185854556), new PinInfo("Epal Atalantis")));  // epal atalantis
        geoPoints.add(new Pair<GeoPoint, PinInfo>(new GeoPoint(38.91434755941711, 21.78808330109529), new PinInfo("Epal Karpenisi")));  // epal Karpenisi
        geoPoints.add(new Pair<GeoPoint, PinInfo>(new GeoPoint(38.021995410170824, 24.4226906500078), new PinInfo("Epal Karistos")));   // epal Karistos
        geoPoints.add(new Pair<GeoPoint, PinInfo>(new GeoPoint(39.62433832411041, 19.90945654811451), new PinInfo("Epal Kerkira")));    // epal Kerkira
        geoPoints.add(new Pair<GeoPoint, PinInfo>(new GeoPoint(38.920316991828095, 22.4242029097274), new PinInfo("Epal Lamia")));      // epal Lamia
        geoPoints.add(new Pair<GeoPoint, PinInfo>(new GeoPoint(38.952468170983934, 22.1213511500289), new PinInfo("Epal Marakomi")));   // epal Marakomi
        geoPoints.add(new Pair<GeoPoint, PinInfo>(new GeoPoint(38.45802788501172, 23.59682885371187), new PinInfo("Epal Xalkida")));    // epal Xalkida
        geoPoints.add(new Pair<GeoPoint, PinInfo>(new GeoPoint(38.57270997805984, 23.63739658600231), new PinInfo("Epal Psaxna")));     // epal Psaxna
        for (Integer i = 0; i < geoPoints.size(); i++)
        {
            Marker startMarker = new Marker(map);
            startMarker.setPosition(geoPoints.get(i).first);
            startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_CENTER);
            startMarker.setTitle(geoPoints.get(i).second.toString());
            map.getOverlays().add(startMarker);
        }
    }
}