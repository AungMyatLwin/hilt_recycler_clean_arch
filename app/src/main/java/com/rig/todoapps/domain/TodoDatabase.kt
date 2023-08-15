package com.rig.todoapps.domain

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rig.todoapps.data.TaskDao
import com.rig.todoapps.data.TaskEntity

@Database(entities = [TaskEntity::class], version = 1, exportSchema = false )
abstract class TodoDatabase:RoomDatabase() {
    abstract fun dao(): TaskDao
}