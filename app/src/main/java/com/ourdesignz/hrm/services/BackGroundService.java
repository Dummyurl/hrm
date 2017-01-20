package com.ourdesignz.hrm.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by ourdesignz on 4/10/16.
 */

public class BackGroundService extends Service {
    private static BackGroundService mContext;


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    // BackGroundService Instance
    public static BackGroundService getInstance() {
        return mContext;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            mContext = BackGroundService.this;

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("BackGroundService", "Exception?? " + e.getMessage());
            stopSelf();
        }

    }
}
