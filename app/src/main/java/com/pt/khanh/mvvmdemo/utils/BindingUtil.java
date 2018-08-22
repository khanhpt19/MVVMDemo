package com.pt.khanh.mvvmdemo.utils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

public final class BindingUtil {

    @BindingAdapter({"recyclerAdapter"})
    public static void setAdapterForRecyclerView(RecyclerView recyclerView,
                                                 RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }
}
