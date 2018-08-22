package com.pt.khanh.mvvmdemo.screen.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pt.khanh.mvvmdemo.R;
import com.pt.khanh.mvvmdemo.data.repository.UserRepository;
import com.pt.khanh.mvvmdemo.data.source.remote.UserRemoteDataSource;
import com.pt.khanh.mvvmdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UserRepository repository = UserRepository.getInstance(UserRemoteDataSource.getInstance());
        mMainViewModel = new MainViewModel(repository);
        ActivityMainBinding mainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setViewModel(mMainViewModel);
    }
}
