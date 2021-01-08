package com.wangze3.accutrack.sensors.model;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;

public class Magnetometer extends AbstractInertialSensor {

    private Listener listener;

    // Magnetometer
    public Magnetometer(Context context) {
        super(context, Sensor.TYPE_MAGNETIC_FIELD);
    }

    public void setListener(Listener l) {
        listener = l;
    }

    @Override
    void onChange(SensorEvent event) {
        if (listener != null) {
            listener.onChange(event);
        }
    }

    // For Observers
    public interface Listener {
        void onChange(SensorEvent event);
    }
}
