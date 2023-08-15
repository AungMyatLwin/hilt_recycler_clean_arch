package com.rig.todoapps.usecase

import com.rig.todoapps.data.TaskDao
import com.rig.todoapps.data.TaskEntity
import com.rig.todoapps.domain.RepositoryImpl
import javax.inject.Inject


class UseCase @Inject constructor(private val dao: TaskDao) : RepositoryImpl(dao){
    override suspend fun getAllTask() = dao.getAllTask()
    suspend fun inserTask(task: TaskEntity) = dao.insertTask(task = task)
}