package com.wangze3.accutrack.sensors;

import android.content.Context;

import com.wangze3.accutrack.sensors.model.Accelerometer;
import com.wangze3.accutrack.sensors.model.GravityVector;
import com.wangze3.accutrack.sensors.model.Gyroscope;
import com.wangze3.accutrack.sensors.model.Magnetometer;

public class InertialSensorManager {

    private final Context context;
    private final Accelerometer accelerometer;
    private final Gyroscope gyroscope;
    private final Magnetometer magnetometer;
    private final GravityVector gravityVector;

    // Initializes sensors
    public InertialSensorManager(Context context) {
        this.context = context;
        accelerometer = new Accelerometer(context);
        gyroscope = new Gyroscope(context);
        magnetometer = new Magnetometer(context);
        gravityVector = new GravityVector(context);
    }

    public void initializeListeners() {
        accelerometer.setListener(new AccelerometerListener(context));
        gyroscope.setListener(new GyroscopeListener(context));
        magnetometer.setListener(new MagnetometerListener(context));
        gravityVector.setListener(new GravityVectorListener(context));
    }

    public void registerAllSensors() {
        accelerometer.register();
        gyroscope.register();
        magnetometer.register();
        gravityVector.register();
    }

    public void unregisterAllSensors() {
        accelerometer.unregister();
        gyroscope.unregister();
        magnetometer.unregister();
        gravityVector.unregister();
    }
}
