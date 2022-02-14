package com.example.MOP_task_asg

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.MOP_task_asg.network.DataObject

import com.example.MOP_task_asg.network.RetroInstance
import com.example.MOP_task_asg.network.RetroService

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    lateinit var retroService: RetroService

    init {
        retroService = RetroInstance.getRetroInstance().create(RetroService::class.java)


    }

    fun getListData() =
    {
         Pager (config = PagingConfig(pageSize = 50, maxSize = 200),
        pagingSourceFactory = {Giphy_trending_source(retroService,getApplication())

        }).flow.cachedIn(viewModelScope)
        //flow.cachedIn(viewModelScope)
    }


    fun getList_search_Data(query:String) =
        {
            Pager (config = PagingConfig(pageSize = 50, maxSize = 200),
                pagingSourceFactory = {Giphy_search_source(retroService,query)

                }).flow.cachedIn(viewModelScope)         //.liveData
            //flow.cachedIn(viewModelScope)
        }







}