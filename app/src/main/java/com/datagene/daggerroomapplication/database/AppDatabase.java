package com.datagene.daggerroomapplication.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.datagene.daggerroomapplication.database.model.DemoModel;

@Database(entities = {DemoModel.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DemoDao getDemoDao();
}
