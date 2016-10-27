package com.example.gcioffi.helloworld;

import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import services.MainService;

public class MainActivity extends AppCompatActivity {

    String msg = "Android : ";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(msg, "The onCreate() event");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_login, menu);
        return true;
    }

    /** Called when the activity is about to become visible. */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "The onStart() event");
    }

    /** Called when the activity has become visible. */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "The onResume() event");
    }

    /** Called when another activity is taking focus. */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "The onPause() event");
    }

    /** Called when the activity is no longer visible. */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "The onStop() event");
    }

    /** Called just before the activity is destroyed. */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(msg, "The onDestroy() event");
    }

    /** Method to start the service */
    public void startService(View view) {
        startService(new Intent(getBaseContext(), MainService.class));
    }

    /** Method to stop the service */
    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), MainService.class));
    }

    /** Method to create BroadcastReceiver */
    public void broadcastIntent(View view)
    {
        Intent intent = new Intent();
        intent.setAction("com.tutorialspoint.CUSTOM_INTENT");
        sendBroadcast(intent);
    }

    /** Called when the user touches the button */
    public void sendMessage(View view) {
        Intent i = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(i);
        Log.d(msg, "Opening LoginActivity");
    }

}
