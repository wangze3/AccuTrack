package com.wangze3.accutrack.sensors;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.hardware.SensorEvent;
import android.widget.TextView;

import com.wangze3.accutrack.R;
import com.wangze3.accutrack.sensors.model.Gyroscope;

public class GyroscopeListener implements Gyroscope.Listener {

    private final Context context;

    public GyroscopeListener(Context context) {
        this.context = context;
    }

    @Override
    public void onRotation(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        setGyrText(x, y, z);
    }

    private void setGyrText(float x, float y, float z) {
        Resources res = context.getResources();
        String gyrText = res.getString(R.string.gyr_values, x, y, z);
        TextView gyrValues = ((Activity) context).findViewById(R.id.gyr_values);
        gyrValues.setText(gyrText);
    }
}
