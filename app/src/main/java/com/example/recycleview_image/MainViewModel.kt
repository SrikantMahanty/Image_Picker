package com.example.recycleview_image

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainViewModel:ViewModel(){
    lateinit var imagelistData:MutableLiveData<ArrayList<String>>
    init {

        imagelistData=MutableLiveData()
    }
    fun getImagesDataObserver():MutableLiveData<ArrayList<String>>{
        return imagelistData
    }
    fun makeImageApiCall(){
        val list:ArrayList<String> = ArrayList()

        FirebaseDatabase.getInstance().reference.child("images/")
            .addListenerForSingleValueEvent(object :ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                  for (dataSnapshot in snapshot.children){
                      val data=dataSnapshot.value.toString()
                      list.add(data)
                  }
                    imagelistData.postValue(list)
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
    }
}