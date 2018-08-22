package com.pt.khanh.mvvmdemo.screen.main;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.pt.khanh.mvvmdemo.R;
import com.pt.khanh.mvvmdemo.data.model.User;

import com.pt.khanh.mvvmdemo.databinding.ItemUserBinding;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ItemViewHolder> {
    private List<User> mUsers;
    private ItemClickListener mItemClickListener;

    public UserAdapter() {
        mUsers = new ArrayList<>();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemUserBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_user, parent, false);
        return new ItemViewHolder(binding, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bindData(mUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return mUsers != null ? mUsers.size() : 0;
    }

    public void setUser(List<User> users) {
        mUsers.clear();
        mUsers.addAll(users);
        notifyDataSetChanged();
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private ItemUserBinding mBinding;
        private ItemUserViewModel mItemUserViewModel;

        public ItemViewHolder(ItemUserBinding binding, ItemClickListener itemClickListener) {
            super(binding.getRoot());
            mBinding = binding;
            mItemUserViewModel = new ItemUserViewModel(itemClickListener);
            mBinding.setViewModel(mItemUserViewModel);
        }

        void bindData(User user) {
            mItemUserViewModel.setUser(user);
            mBinding.executePendingBindings();
        }
    }

    public interface ItemClickListener {
        void onItemClicked(Integer id);
    }
}
