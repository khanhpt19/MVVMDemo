package com.pt.khanh.mvvmdemo.data.source;

import com.pt.khanh.mvvmdemo.data.model.Item;

import io.reactivex.Observable;

public interface UserDataSource {
    interface RemoteDataSource extends UserDataSource {
        Observable<Item> search(String userLogin);
    }
}
