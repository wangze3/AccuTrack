package com.wangze3.accutrack.sensors.model;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;

public class Gyroscope extends AbstractInertialSensor {

    private Listener listener;

    // Gyroscope
    public Gyroscope(Context context) {
        super(context, Sensor.TYPE_GYROSCOPE);
    }

    public void setListener(Listener l) {
        listener = l;
    }

    @Override
    void onChange(SensorEvent event) {
        if (listener != null) {
            listener.onRotation(event);
        }
    }

    // For Observers
    public interface Listener {
        void onRotation(SensorEvent event);
    }
}
