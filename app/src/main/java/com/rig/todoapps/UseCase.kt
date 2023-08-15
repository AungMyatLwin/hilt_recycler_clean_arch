package com.rig.todoapps

import javax.inject.Inject


class UseCase @Inject constructor(private val dao: TaskDao) : RepositoryImpl(dao){
    override suspend fun getAllTask() = dao.getAllTask()
    suspend fun inserTask(task:TaskEntity) = dao.insertTask(task = task)
}