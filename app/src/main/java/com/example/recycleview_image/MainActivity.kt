package com.example.recycleview_image

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recycleview_image.databinding.ActivityMainBinding
import com.example.recycleview_image.databinding.ItemLayoutBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: RecycleViewAdapter
    private lateinit var list:ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel=ViewModelProvider(this,ViewModelFactory())[MainViewModel::class.java]
        list= ArrayList()
        val layoutManager=GridLayoutManager(this,2)
        binding.rvView.layoutManager=layoutManager
        adapter= RecycleViewAdapter(list)

        binding.rvView.adapter= adapter
        mainViewModel.getImagesDataObserver().observe(this){
            if (it!= null){
                adapter.setDatalist(it)
            }
        }
        mainViewModel.makeImageApiCall()
    }

}