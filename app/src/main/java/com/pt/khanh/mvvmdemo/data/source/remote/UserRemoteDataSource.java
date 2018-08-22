package com.pt.khanh.mvvmdemo.data.source.remote;

import com.pt.khanh.mvvmdemo.data.model.Item;
import com.pt.khanh.mvvmdemo.data.source.UserDataSource;
import com.pt.khanh.mvvmdemo.data.source.remote.service.UserAPI;
import com.pt.khanh.mvvmdemo.data.source.remote.service.UserServiceClient;

import io.reactivex.Observable;

public class UserRemoteDataSource implements UserDataSource.RemoteDataSource {
    private static UserRemoteDataSource sInstance;
    private UserAPI mAPI;

    public UserRemoteDataSource(UserAPI api) {
        mAPI = api;
    }

    public static synchronized UserRemoteDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new UserRemoteDataSource(UserServiceClient.getInstance());
        }
        return sInstance;
    }

    @Override
    public Observable<Item> search(String userLogin) {
        return mAPI.getUser(userLogin);
    }
}
