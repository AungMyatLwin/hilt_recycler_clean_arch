package com.rig.todoapps

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    fun providesRoomDb(@ApplicationContext context:Context):TodoDatabase {
        return   Room.databaseBuilder(
            context, TodoDatabase::class.java, "todoDb"
        ).build()

    }
    @Provides
    fun providesDao(taskDb:TodoDatabase):TaskDao = taskDb.dao()

    @Provides
    fun providesRepository(dao: TaskDao):Repository = RepositoryImpl(dao)

    @Provides
    fun providesUseCase(dao: TaskDao):UseCase = UseCase(dao)
}