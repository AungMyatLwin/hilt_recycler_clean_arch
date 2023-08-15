package com.rig.todoapps.di

import android.content.Context
import androidx.room.Room
import com.rig.todoapps.domain.Repository
import com.rig.todoapps.domain.RepositoryImpl
import com.rig.todoapps.data.TaskDao
import com.rig.todoapps.domain.TodoDatabase
import com.rig.todoapps.usecase.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    fun providesRoomDb(@ApplicationContext context:Context): TodoDatabase {
        return   Room.databaseBuilder(
            context, TodoDatabase::class.java, "todoDb"
        ).build()

    }
    @Provides
    fun providesDao(taskDb: TodoDatabase): TaskDao = taskDb.dao()

    @Provides
    fun providesRepository(dao: TaskDao): Repository = RepositoryImpl(dao)

    @Provides
    fun providesUseCase(dao: TaskDao): UseCase = UseCase(dao)
}