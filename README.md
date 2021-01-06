# AccuTrack
This is an Android application that uses the smartphone's IMU (accelerometer, gyroscope, and magnetometer) and GPS to track the motion path.
The advantages of using IMU to track a motion path are:
 - much faster update rate than GPS
 - improve the position error from meter scale to centimeter scale.
 - track xyz-position at a finer granularity

Technical overview: the system uses the fundamentals of the Kalman filter. The IMU readings are used in the update (or prediction) stage and the GPS readings are used in the observation (or correction) stage.
