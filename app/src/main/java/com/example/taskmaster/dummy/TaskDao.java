package com.example.taskmaster.dummy;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.taskmaster.Tasks;

import java.util.List;

@Dao
public abstract class TaskDao {

    @Query("SELECT * FROM tasks")
   public abstract List<Tasks> getTasks();

    @Query("SELECT * FROM tasks WHERE id= :id")
   public abstract Tasks getOne(long id);

    @Insert
    public abstract void save(Tasks task);

}
