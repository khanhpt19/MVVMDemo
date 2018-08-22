package com.pt.khanh.mvvmdemo.data.source.remote.service;

import com.pt.khanh.mvvmdemo.utils.Constants;
import com.pt.khanh.mvvmdemo.data.model.Item;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserAPI {
    @GET(Constants.GET_USER)
    Observable<Item> getUser(@Query(Constants.QUERY_USER) String name);
}
