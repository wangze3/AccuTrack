package com.wangze3.accutrack.sensors;

import android.content.Context;

import com.wangze3.accutrack.sensors.model.Accelerometer;
import com.wangze3.accutrack.sensors.model.Gyroscope;
import com.wangze3.accutrack.sensors.model.Magnetometer;

public class InertialSensorManager {

    private final Accelerometer accelerometer;
    private final Gyroscope gyroscope;
    private final Magnetometer magnetometer;

    // Initializes sensors
    public InertialSensorManager(Context context) {
        accelerometer = new Accelerometer(context);
        gyroscope = new Gyroscope(context);
        magnetometer = new Magnetometer(context);
    }

    public void initializeListeners() {
        accelerometer.setListener(new AccelerometerListener());
        gyroscope.setListener(new GyroscopeListener());
        magnetometer.setListener(new MagnetometerListener());
    }

    public void registerAllSensors() {
        accelerometer.register();
        gyroscope.register();
        magnetometer.register();
    }

    public void unregisterAllSensors() {
        accelerometer.unregister();
        gyroscope.unregister();
        magnetometer.unregister();
    }
}
