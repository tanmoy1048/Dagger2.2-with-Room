package com.datagene.daggerroomapplication.database;

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

    public Observable<List<DemoModel>> retrieveDemoModel() {
        return mAppDatabase.getDemoDao().getDemos();
    }
}
