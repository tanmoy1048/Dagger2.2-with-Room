package com.datagene.daggerroomapplication.database;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;

import com.datagene.daggerroomapplication.database.model.DemoModel;

import java.util.List;

import io.reactivex.Observable;


public class AppRepository {
    private AppDatabase mAppDatabase;

    public AppRepository(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }

    public Observable<Long> insertDemos(final DemoModel demoModel) {
        return Observable.fromCallable(() -> mAppDatabase.getDemoDao().insertDemo(demoModel));
    }

    public Observable<long[]> insertDemos(final DemoModel[] demoModels) {
        return Observable.fromCallable(() -> mAppDatabase.getDemoDao().insertDemos(demoModels));
    }

    public LiveData<List<DemoModel>> retrieveDemoModel() {
        return LiveDataReactiveStreams.fromPublisher(mAppDatabase.getDemoDao().getDemos());
    }
}
