package com.pt.khanh.mvvmdemo.data.repository;

import com.pt.khanh.mvvmdemo.data.model.Item;
import com.pt.khanh.mvvmdemo.data.source.UserDataSource;
import com.pt.khanh.mvvmdemo.data.source.remote.UserRemoteDataSource;

import io.reactivex.Observable;

public class UserRepository implements UserDataSource.RemoteDataSource {
    private static UserRepository sInstance;
    private UserRemoteDataSource mUserRemoteDataSource;

    public UserRepository(UserRemoteDataSource userRemoteDataSource) {
        mUserRemoteDataSource = userRemoteDataSource;
    }

    public static synchronized UserRepository getInstance(UserRemoteDataSource remoteDataSource) {
        if (sInstance == null) {
            sInstance = new UserRepository(remoteDataSource);
        }
        return sInstance;
    }

    @Override
    public Observable<Item> search(String userLogin) {
        return mUserRemoteDataSource.search(userLogin);
    }
}
