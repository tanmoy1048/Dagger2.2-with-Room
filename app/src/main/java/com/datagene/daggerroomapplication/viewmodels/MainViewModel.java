package com.datagene.daggerroomapplication.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.datagene.daggerroomapplication.database.AppRepository;
import com.datagene.daggerroomapplication.database.model.DemoModel;

import java.util.List;

import javax.inject.Inject;

public class MainViewModel extends ViewModel {

    private static final String TAG = "MainViewModel";
    private AppRepository appRepository;

    @Inject
    public MainViewModel(AppRepository appRepository) {
        this.appRepository = appRepository;
        Log.d(TAG, "MainViewModel: view model is working.");
    }

    public LiveData<List<DemoModel>> getDemo() {
        return appRepository.retrieveDemoModel();
    }
}















