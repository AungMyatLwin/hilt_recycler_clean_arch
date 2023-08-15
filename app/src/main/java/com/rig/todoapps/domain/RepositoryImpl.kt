package com.rig.todoapps.domain

import com.rig.todoapps.data.TaskDao
import com.rig.todoapps.data.TaskEntity
import javax.inject.Inject

open class RepositoryImpl @Inject constructor(private val dao: TaskDao): Repository {
    override suspend fun getAllTask(): List<TaskEntity> {
        return dao.getAllTask()
    }

    override suspend fun addTask(task: TaskEntity) {
       return dao.insertTask(task)
    }

}