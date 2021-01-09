package com.wangze3.accutrack.sensors;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.hardware.SensorEvent;
import android.widget.TextView;

import com.wangze3.accutrack.R;
import com.wangze3.accutrack.sensors.model.Accelerometer;

public class AccelerometerListener implements Accelerometer.Listener {

    private final Context context;

    public AccelerometerListener(Context context) {
        this.context = context;
    }

    @Override
    public void onTranslation(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        setAccText(x, y, z);
    }

    private void setAccText(float x, float y, float z) {
        Resources res = context.getResources();
        String accText = res.getString(R.string.acc_values, x, y, z);
        TextView accValues = ((Activity) context).findViewById(R.id.acc_values);
        accValues.setText(accText);
    }
}
