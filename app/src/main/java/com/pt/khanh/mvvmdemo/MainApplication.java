package com.pt.khanh.mvvmdemo;

import android.app.Application;

import com.pt.khanh.mvvmdemo.data.source.remote.service.UserServiceClient;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UserServiceClient.initialize(this);
    }
}
