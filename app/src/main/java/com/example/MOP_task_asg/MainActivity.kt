package com.example.MOP_task_asg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.MOP_task_asg.OFFline.Adapter
import com.example.MOP_task_asg.OFFline.Giphy_data_base
import com.example.MOP_task_asg.OFFline.Giphy_gif_url
import com.example.MOP_task_asg.network.DataImage
import com.example.MOP_task_asg.network.DataObject
import com.example.MOP_task_asg.network.ogImage
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var adapter_offline: Adapter
    lateinit var  networkUtil: Network_util
   


    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

             recycle_view()

             initRecyclerView()








         upload.setOnClickListener({

            startActivity(Intent(this,Video_upload_activity::class.java))


        })


        search.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                if(!search.text.isEmpty() &&  search.text.length <=25)
                {
                    initViewModel_search(search.text.toString())
                    search.text.clear()

                }
               else{
                    Toast.makeText(this,"provide valid text",Toast.LENGTH_LONG).show()
               }
            }
            true
        }


    }

    private fun initRecyclerView() {
         /*
            recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity,2)
            val decoration  = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)

          */
           val check =  Network_util().isNetworkAvailable(this@MainActivity)


            if(check)
            {
                recyclerViewAdapter = RecyclerViewAdapter(this@MainActivity)
                recyclerView.adapter   = recyclerViewAdapter
                initViewModel_trending()

             }
            else{
                getdataoffline()


            }
    }


    fun recycle_view(){
        recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            val decoration =
                DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
        }


    }






     private fun getdataoffline(){
         val giphydb = Giphy_data_base.getdatabase_instance(this)
         giphydb?.gif_dao()?.get_allurl()?.observe(this@MainActivity, Observer {
           adapter_offline = Adapter(it,this@MainActivity)
           recyclerView.adapter = adapter_offline
           adapter_offline.notifyDataSetChanged()
     })
     }





    private fun initViewModel_trending() {
        val viewModel  = ViewModelProvider(this).get(MainActivityViewModel::class.java)
           lifecycleScope.launchWhenCreated {
            viewModel.getListData().invoke().collectLatest {
                recyclerViewAdapter.submitData(it)
                recyclerViewAdapter.notifyDataSetChanged()
            }
           }
        }



    private fun initViewModel_search(query:String) {
        val viewModel  = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        lifecycleScope.launchWhenCreated {
            viewModel.getList_search_Data(query).invoke().collectLatest {


              if(!listOf(it).isEmpty())
              {
                  recyclerViewAdapter.submitData(it)
             Toast.makeText(this@MainActivity,"api hit",Toast.LENGTH_LONG).show()
              }
              else{
                  Toast.makeText(this@MainActivity,"record not found"+ listOf(it).size,Toast.LENGTH_LONG).show()
              }

                }
       }
         }

    }





