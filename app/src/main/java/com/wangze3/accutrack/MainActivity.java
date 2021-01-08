package com.wangze3.accutrack;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.wangze3.accutrack.sensors.InertialSensorManager;

public class MainActivity extends AppCompatActivity {

    private InertialSensorManager inertialSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Setup inertial sensors
        inertialSensorManager = new InertialSensorManager(this);
        inertialSensorManager.initializeListeners();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // inertial sensors
        inertialSensorManager.registerAllSensors();
    }

    @Override
    protected void onPause() {
        super.onPause();

        // inertial sensors
        inertialSensorManager.unregisterAllSensors();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}