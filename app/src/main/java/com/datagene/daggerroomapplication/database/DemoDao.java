package com.datagene.daggerroomapplication.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.datagene.daggerroomapplication.database.model.DemoModel;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface DemoDao {
    @Insert
    long[] insertDemos(DemoModel... demos);

    @Insert
    long insertDemo(DemoModel demo);

    @Query("SELECT * FROM demo_model")
    Flowable<List<DemoModel>> getDemos();
}
