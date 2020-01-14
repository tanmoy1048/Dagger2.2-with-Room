package com.datagene.daggerroomapplication;

import android.os.Bundle;
import android.util.Log;

import com.datagene.daggerroomapplication.database.AppRepository;
import com.datagene.daggerroomapplication.database.model.DemoModel;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends DaggerAppCompatActivity {
    @Inject
    AppRepository appRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appRepository.insertDemos(new DemoModel("test test")).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {
                Log.d("zzzzz", "inserted");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        appRepository.retrieveDemoModel().observe(this, demoModels -> Log.d("zzzzz", Integer.toString(demoModels.size())));
        Log.d("zzzzz", appRepository == null ? "injection not working" : "injection working");
    }
}
