package com.example.vmandldtest

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewHolder>(){
    class UserViewHolder(view: View): RecyclerView.ViewHolder(view)

    private var userList = emptyList<UserModel>()

    var userName: String? = null
    var userSurname: String? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_item_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        userName = holder.itemView.findViewById<EditText>(R.id.edit_name).text.toString()
        userName = userList[position].name
        userSurname = holder.itemView.findViewById<EditText>(R.id.edit_surname).text.toString()
        userName = userList[position].surName
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list:List<UserModel>){
        userList = list
        notifyDataSetChanged()
    }

}