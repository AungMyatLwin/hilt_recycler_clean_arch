package com.rig.todoapps

import androidx.lifecycle.LiveData
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertTask(task:TaskEntity)

    @Query("Select * from task_table")
     fun getAllTask():List<TaskEntity>
}