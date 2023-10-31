package com.example.vmandldtest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainFragmentViewModel: ViewModel() {

    private var userList: MutableLiveData<List<UserModel>> = MutableLiveData()

    var usersList: ArrayList<UserModel> ?=null

    fun populateList(name: String, surName: String){
        var user = UserModel(name, surName)
        usersList = ArrayList()
        usersList?.add(user)
        userList.value = usersList
    }

    fun getList() = userList

}