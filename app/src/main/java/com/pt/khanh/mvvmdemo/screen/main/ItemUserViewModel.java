package com.pt.khanh.mvvmdemo.screen.main;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.pt.khanh.mvvmdemo.data.model.User;

public class ItemUserViewModel extends BaseObservable {
    public final ObservableField<User> mUserObservableField = new ObservableField<>();
    private UserAdapter.ItemClickListener mItemClickListener;

    public ItemUserViewModel(UserAdapter.ItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public void setUser(@NonNull User user) {
        mUserObservableField.set(user);
    }

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    public void onItemClicked(View view) {
        if (mItemClickListener == null || mUserObservableField.get() == null) {
            return;
        }
        mItemClickListener.onItemClicked(mUserObservableField.get().getId());
    }
}
