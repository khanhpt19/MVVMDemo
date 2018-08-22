package com.pt.khanh.mvvmdemo.data.source.remote.service;

import android.app.Application;
import android.support.annotation.NonNull;

import com.pt.khanh.mvvmdemo.utils.Constants;

public class UserServiceClient extends ServiceClient {
    private static UserAPI sAPI;

    public static void initialize(@NonNull Application application) {
        sAPI = createService(application, Constants.BASE_URL, UserAPI.class);
    }

    public static UserAPI getInstance() {
        if (sAPI == null) {
            throw new IllegalStateException(UserServiceClient.class.getSimpleName());
        }
        return sAPI;
    }
}
