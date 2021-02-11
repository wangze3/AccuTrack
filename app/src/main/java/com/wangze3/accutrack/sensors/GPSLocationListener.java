package com.wangze3.accutrack.sensors;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationListener;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.wangze3.accutrack.R;

public class GPSLocationListener implements LocationListener {

    private final Context context;

    public GPSLocationListener(Context context) {
        this.context = context;
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        setGpsText(location.getLongitude(), location.getLatitude());
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {

    }

    private void setGpsText(double longitude, double latitude) {
        Resources res = context.getResources();
        String gpsText = res.getString(R.string.gps_values, longitude, latitude);
        TextView gpsValues = ((Activity) context).findViewById(R.id.gps_values);
        gpsValues.setText(gpsText);
    }
}
