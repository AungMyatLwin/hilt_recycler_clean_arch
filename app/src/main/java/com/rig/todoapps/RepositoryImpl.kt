package com.rig.todoapps

import javax.inject.Inject

open class RepositoryImpl @Inject constructor(private val dao: TaskDao):Repository {
    override suspend fun getAllTask(): List<TaskEntity> {
        return dao.getAllTask()
    }

    override suspend fun addTask(task: TaskEntity) {
       return dao.insertTask(task)
    }

}