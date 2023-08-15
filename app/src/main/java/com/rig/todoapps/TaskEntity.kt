package com.rig.todoapps

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    var id:Int,
    @ColumnInfo("taskName")
    var taskName:String,
    @ColumnInfo("progress")
    var progress:Boolean
)