package com.rig.todoapps

import androidx.lifecycle.LiveData
import javax.inject.Inject

interface Repository {
     suspend fun getAllTask( ):List<TaskEntity>
     suspend fun addTask(task:TaskEntity)
}