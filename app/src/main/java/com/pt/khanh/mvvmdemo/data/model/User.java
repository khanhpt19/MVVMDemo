package com.pt.khanh.mvvmdemo.data.model;

import android.databinding.BaseObservable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User extends BaseObservable {
    @SerializedName("login")
    @Expose
    private String mLogin;
    @SerializedName("id")
    @Expose
    private int mId;
    @SerializedName("avatar_url")
    @Expose
    private String mAvatar;

    public String getLogin() {
        return mLogin;
    }

    public void setLogin(String login) {
        mLogin = login;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getAvatar() {
        return mAvatar;
    }

    public void setAvatar(String avatar) {
        mAvatar = avatar;
    }
}
