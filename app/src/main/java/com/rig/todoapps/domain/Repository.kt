package com.rig.todoapps.domain

import com.rig.todoapps.data.TaskEntity

interface Repository {
     suspend fun getAllTask( ):List<TaskEntity>
     suspend fun addTask(task: TaskEntity)
}