package com.example.MOP_task_asg

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.MOP_task_asg.network.DataObject
import com.example.MOP_task_asg.network.RetroService

private const val FIRST_PAGE_INDEX = 1
class Giphy_search_source(val apiService: RetroService,val search:String): PagingSource<Int, DataObject>() {



    override fun getRefreshKey(state: PagingState<Int, DataObject>): Int?
    {

        return state.anchorPosition

    }

    override suspend fun load(params: PagingSource.LoadParams<Int>): PagingSource.LoadResult<Int, DataObject> {
        return try {
            var nextPage: Int = params.key ?: FIRST_PAGE_INDEX
            val response = apiService.search_alltrending_images(search,nextPage)


            PagingSource.LoadResult.Page(
                data =  response.res,
                prevKey = if(nextPage == FIRST_PAGE_INDEX) null else nextPage-1,
                nextKey =   if(response.res.isEmpty()) null else nextPage+1
            )
        }
        catch (e: Exception) {
            PagingSource.LoadResult.Error(e)
        }
    }








}