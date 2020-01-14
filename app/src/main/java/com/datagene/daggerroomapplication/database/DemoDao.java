package com.datagene.daggerroomapplication.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.datagene.daggerroomapplication.database.model.DemoModel;

import java.util.List;

@Dao
public interface DemoDao {
    @Insert
    long[] insertDemo(DemoModel... demos);

    @Query("SELECT * FROM demo_model")
    LiveData<List<DemoModel>> getDemos();
}
