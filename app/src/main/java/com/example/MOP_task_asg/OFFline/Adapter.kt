package com.example.MOP_task_asg.OFFline

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.MOP_task_asg.Activity_Image_show
import com.example.MOP_task_asg.R

class Adapter(val giphyGifUrl: List<Giphy_gif_url>,val context: Context) : RecyclerView.Adapter<com.example.MOP_task_asg.OFFline.Adapter.myholder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myholder {
       val view =LayoutInflater.from(context).inflate(R.layout.recycler_row,parent,false)
       return  myholder(view)


    }

    override fun onBindViewHolder(holder: myholder, position: Int) {
        val img_url =giphyGifUrl.get(position).url

        Glide.with(context)
            .load(img_url)
            .centerCrop()
            .into(holder.imageView)

       holder.imageView.setOnClickListener({

           context.startActivity(
               Intent(context, Activity_Image_show::class.java)
               .putExtra("url",img_url))

       })




    }

    override fun getItemCount(): Int {
      return  giphyGifUrl.size

    }


    class  myholder(itemview:View) :RecyclerView.ViewHolder(itemview){

        val imageView: ImageView = itemview.findViewById<ImageView>(R.id.imageView)




    }




}