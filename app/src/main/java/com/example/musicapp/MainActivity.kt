package com.example.musicapp

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var myAdapter: adapter
    lateinit var myrecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myrecyclerView = findViewById(R.id.recycle)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData("eminem")

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(p0: Call<MyData?>, p1: Response<MyData?>) {
                val datalist = p1.body()?.data
//                val textView = findViewById<TextView>(R.id.texthello)
//                textView.text = datalist.toString()
                Log.d("artistalist", "onResponse: " + p1.body())
                myAdapter = adapter(this@MainActivity, datalist!!)
                myrecyclerView.adapter = myAdapter
                myrecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

            }

            override fun onFailure(p0: Call<MyData?>, p1: Throwable) {
                Log.e("onfaliur", "onFailure: " + p1.message)
            }
        })


    }
}