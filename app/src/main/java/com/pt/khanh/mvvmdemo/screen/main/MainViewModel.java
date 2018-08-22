package com.pt.khanh.mvvmdemo.screen.main;

import android.databinding.BaseObservable;
import android.text.Editable;
import android.text.TextWatcher;

import com.pt.khanh.mvvmdemo.data.model.Item;
import com.pt.khanh.mvvmdemo.data.repository.UserRepository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends BaseObservable implements UserAdapter.ItemClickListener {
    private UserRepository mRepository;
    private UserAdapter mAdapter;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public MainViewModel(UserRepository repository) {
        mRepository = repository;
        mAdapter = new UserAdapter();
        mAdapter.setItemClickListener(this);
    }

    public TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            searchUserByName(editable.toString());
        }
    };

    public void searchUserByName(String name) {
        Disposable disposable = mRepository.search(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> handleResponse(response), error -> handleError(error));
        mCompositeDisposable.add(disposable);
    }

    private void handleError(Throwable error) {

    }

    private void handleResponse(Item response) {
        mAdapter.setUser(response.getUsers());
    }

    public UserAdapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void onItemClicked(Integer id) {

    }
}
