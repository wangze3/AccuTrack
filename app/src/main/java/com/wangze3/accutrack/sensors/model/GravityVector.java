package com.wangze3.accutrack.sensors.model;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;

public class GravityVector extends AbstractInertialSensor {

    private GravityVector.Listener listener;

    // Accelerometer
    public GravityVector(Context context) {
        super(context, Sensor.TYPE_GRAVITY);
    }

    public void setListener(GravityVector.Listener l) {
        listener = l;
    }

    @Override
    void onChange(SensorEvent event) {
        if (listener != null) {
            listener.onUpdate(event);
        }
    }

    // For Observers
    public interface Listener {
        void onUpdate(SensorEvent event);
    }
}