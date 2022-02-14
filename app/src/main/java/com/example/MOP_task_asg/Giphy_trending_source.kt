package com.example.MOP_task_asg

import android.content.Context
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.room.Room
import com.example.MOP_task_asg.OFFline.Giphy_data_base
import com.example.MOP_task_asg.OFFline.Giphy_gif_url

import com.example.MOP_task_asg.network.DataObject
import com.example.MOP_task_asg.network.DataResult
import com.example.MOP_task_asg.network.RetroService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

private const val FIRST_PAGE_INDEX = 1

     //var dataResult: DataResult? =null





class Giphy_trending_source(val apiService: RetroService,val context: Context): PagingSource<Int,  DataObject>()
{


    override fun getRefreshKey(state: PagingState<Int, DataObject>): Int?
    {

        return state.anchorPosition

    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataObject> {
        return try {
            var nextPage: Int = params.key ?: FIRST_PAGE_INDEX
            val  dataResult = apiService.get_alltrending_images(nextPage)

           val giphydb = Giphy_data_base.getdatabase_instance(context)


       GlobalScope.launch {

           for (item in dataResult.res)
           {


               giphydb?.gif_dao()?.insert_gif_data(Giphy_gif_url(item.images.ogImage.url))
           }

       }

            LoadResult.Page(
                     data = dataResult.res,
                    prevKey = if(nextPage == FIRST_PAGE_INDEX) null else nextPage-1,
                    nextKey =   if(dataResult?.res!!.isEmpty()) null else nextPage+1

            )
        }
        catch (e: Exception) {
            LoadResult.Error(e)
        }
    }








}