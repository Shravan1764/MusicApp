package com.example.musicapp

import android.app.Activity
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class adapter (val context : Activity,val data : List<Data>) : RecyclerView.Adapter<adapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rec_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentdata = data[position]

        val mediaplayer = MediaPlayer.create(context,currentdata.preview.toUri())
        holder.title.text = currentdata.title
        Picasso.get().load(currentdata.album.cover_medium).into(holder.image)

        holder.play.setOnClickListener {
            mediaplayer.start()
        }
        holder.pause.setOnClickListener {
            mediaplayer.pause()
        }
    }

    class ViewHolder (itemview : View):RecyclerView.ViewHolder(itemview) {

       val image : ImageView
       val title : TextView
       val play : ImageButton
       val pause : ImageButton

        init{
            image = itemview.findViewById(R.id.imageView)
            title = itemview.findViewById(R.id.textView)
            play = itemview.findViewById(R.id.imageButton)
            pause = itemview.findViewById(R.id.imageButton2)
        }


    }


}

