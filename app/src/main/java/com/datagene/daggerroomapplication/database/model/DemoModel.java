package com.datagene.daggerroomapplication.database.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "demo_model")
public class DemoModel {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "value")
    public String value;

    public DemoModel(String value) {
        this.value = value;
    }
}
