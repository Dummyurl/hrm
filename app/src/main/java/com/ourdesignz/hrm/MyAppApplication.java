package com.ourdesignz.hrm;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by ourdesignz on 4/10/16.
 */
public class MyAppApplication extends Application {

    private static MyAppApplication sInstance;

    SharedPreferences mPref;

    public static MyAppApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        sInstance.initializeInstance();

    }

    private void initializeInstance() {

        // Do your application wise initialization task
        screenConfiguration();

        // set application wise preference
        mPref = this.getApplicationContext().getSharedPreferences("pref_key", MODE_PRIVATE);

        // Initialize Fresco
        Fresco.initialize(this.getApplicationContext());
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public void screenConfiguration() {
        Configuration config = getResources().getConfiguration();
        boolean isTab = (config.screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_LARGE;

        Point size = new Point();
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        int deviceScreenWidth;
        int deviceScreenHeight;

        try {
            display.getSize(size);
            deviceScreenWidth = size.x;
            deviceScreenHeight = size.y;
        } catch (NoSuchMethodError e) {
            deviceScreenWidth = display.getWidth();
            deviceScreenHeight = display.getHeight();
        }
    }

    public boolean isFirstRun() {
        // return true if the app is running for the first time
        return mPref.getBoolean("is_first_run", true);
    }

    public void setRuined() {
        // after a successful run, call this method to set first run false
        SharedPreferences.Editor edit = mPref.edit();
        edit.putBoolean("is_first_run", false);
        edit.commit();
    }

    @Override
    public void onTerminate() {
        // Do your application wise Termination task
        Log.e("onTerminate","onTerminate");
        super.onTerminate();
    }
}
