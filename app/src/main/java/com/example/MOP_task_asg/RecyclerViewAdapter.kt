package com.example.MOP_task_asg

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.MOP_task_asg.network.DataObject

class RecyclerViewAdapter(val context: Context): PagingDataAdapter<DataObject, RecyclerViewAdapter.MyViewHolder>(DiffUtilCallBack()) {



    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {

        holder.bind(getItem(position)!!)

       holder.imageView.setOnClickListener {

     val data :String =  holder.url(getItem(position)!!)
           context.startActivity(Intent(context,Activity_Image_show::class.java)
               .putExtra("url",data))


       }




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)
        return MyViewHolder(inflater)
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

       val imageView: ImageView = view.findViewById(R.id.imageView)

        fun bind(data: DataObject) {

            Glide.with(imageView)
               .load(data.images.ogImage.url)
                .into(imageView)

        }



        fun url(data: DataObject):String {


           return data.images.ogImage.url

        }





    }

    class DiffUtilCallBack: DiffUtil.ItemCallback<DataObject>() {
        override fun areItemsTheSame(oldItem: DataObject, newItem: DataObject): Boolean {
        return  oldItem.images.ogImage.url == newItem.images.ogImage.url

        }

        override fun areContentsTheSame(oldItem: DataObject, newItem: DataObject): Boolean {
            return oldItem.images.ogImage.url == newItem.images.ogImage.url

        }

    }

}