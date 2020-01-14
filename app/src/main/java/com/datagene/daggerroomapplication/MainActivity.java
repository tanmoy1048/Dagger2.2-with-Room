package com.datagene.daggerroomapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.ViewModelProviders;

import com.datagene.daggerroomapplication.viewmodels.MainViewModel;
import com.datagene.daggerroomapplication.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {
    @Inject
    ViewModelProviderFactory providerFactory;

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this, providerFactory).get(MainViewModel.class);
        viewModel.getDemo().observe(this, demoModels -> {
            Log.d("zzzzz", demoModels.size() + "");
        });
    }
}
