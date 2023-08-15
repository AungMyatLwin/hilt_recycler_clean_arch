package com.rig.todoapps

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val useCase: UseCase): ViewModel(){

    var mutableLiveData:MutableLiveData<List<TaskEntity>> = MutableLiveData()
    fun getAllTask() {
        viewModelScope.launch(Dispatchers.IO) {
            var async_getAllTask = async {
                useCase.getAllTask()
            }
            var await_items = async_getAllTask.await()
            mutableLiveData.postValue(await_items)
        }
    }


    fun addTask(task:TaskEntity){
      viewModelScope.launch(Dispatchers.IO){
          useCase.inserTask(task)
      }
    }
}