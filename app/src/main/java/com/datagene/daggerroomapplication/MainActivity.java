package com.datagene.daggerroomapplication;

import android.os.Bundle;
import android.util.Log;

import com.datagene.daggerroomapplication.database.AppDatabase;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {
    @Inject
    AppDatabase requestManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("zzzzz", requestManager == null ? "injection not working" : "injection working");
    }
}
