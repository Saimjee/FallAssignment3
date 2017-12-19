package com.example.sunlight1.fallassignment3;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    private android.widget.ToggleButton toggleButton;
    private android.widget.ToggleButton toggleButton2;
    private android.widget.TextView textView;
    private android.widget.TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.textView2 = (TextView) findViewById(R.id.textView2);
        this.textView = (TextView) findViewById(R.id.textView);

        this.toggleButton2 = (ToggleButton) findViewById(R.id.toggleButton2);
        this.toggleButton = (ToggleButton) findViewById(R.id.toggleButton);

    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventMassage eventMassage){

        if(eventMassage.getWifiStatus() == "on"){
            toggleButton.setChecked(true);
        }

        if(eventMassage.getWifiStatus() == "off"){
            toggleButton.setChecked(false);
        }

        if(eventMassage.getAirStatus() == "on"){
            toggleButton2.setChecked(true);
        }else {
            toggleButton2.setChecked(false);
        }

    }


}












