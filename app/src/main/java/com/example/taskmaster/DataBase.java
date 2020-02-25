package com.example.taskmaster;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.taskmaster.dummy.TaskDao;

@Database(entities = {Tasks.class}, version = 1)
public abstract class DataBase extends RoomDatabase {

    public abstract TaskDao taskDao();

}

