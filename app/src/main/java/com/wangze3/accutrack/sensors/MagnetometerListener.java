package com.wangze3.accutrack.sensors;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.hardware.SensorEvent;
import android.widget.TextView;

import com.wangze3.accutrack.R;
import com.wangze3.accutrack.sensors.model.Magnetometer;

public class MagnetometerListener implements Magnetometer.Listener {

    private final Context context;

    public MagnetometerListener(Context context) {
        this.context = context;
    }

    @Override
    public void onChange(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        setMagText(x, y, z);
    }

    private void setMagText(float x, float y, float z) {
        Resources res = context.getResources();
        String magText = res.getString(R.string.mag_values, x, y, z);
        TextView magValues = ((Activity) context).findViewById(R.id.mag_values);
        magValues.setText(magText);
    }
}
