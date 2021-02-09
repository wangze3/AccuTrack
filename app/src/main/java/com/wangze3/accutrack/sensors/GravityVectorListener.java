package com.wangze3.accutrack.sensors;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.hardware.SensorEvent;
import android.widget.TextView;

import com.wangze3.accutrack.R;
import com.wangze3.accutrack.sensors.model.GravityVector;

public class GravityVectorListener implements GravityVector.Listener {

    private final Context context;

    public GravityVectorListener(Context context) {
        this.context = context;
    }

    @Override
    public void onUpdate(SensorEvent event) {
        float gx = event.values[0];
        float gy = event.values[1];
        float gz = event.values[2];

        setGravText(gx, gy, gz);
    }

    private void setGravText(float gx, float gy, float gz) {
        Resources res = context.getResources();
        String gravText = res.getString(R.string.grav_values, gx, gy, gz);
        TextView accValues = ((Activity) context).findViewById(R.id.grav_values);
        accValues.setText(gravText);
    }
}