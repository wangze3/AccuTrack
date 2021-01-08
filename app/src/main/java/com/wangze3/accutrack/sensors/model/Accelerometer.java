package com.wangze3.accutrack.sensors.model;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;

public class Accelerometer extends AbstractInertialSensor {

    private Listener listener;

    // Accelerometer
    public Accelerometer(Context context) {
        super(context, Sensor.TYPE_LINEAR_ACCELERATION);
    }

    public void setListener(Listener l) {
        listener = l;
    }

    @Override
    void onChange(SensorEvent event) {
        if (listener != null) {
            listener.onTranslation(event);
        }
    }

    // For Observers
    public interface Listener {
        void onTranslation(SensorEvent event);
    }
}
