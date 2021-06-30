package com.teammaker.teamgenerator.ui.userlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teammaker.teamgenerator.R
import com.teammaker.teamgenerator.domain.model.UserModel

class UsersAdapter : RecyclerView.Adapter<UserViewHolder>() {

    var userList:MutableList<UserModel> = mutableListOf()

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = userList[position]
        holder.render(item)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UserViewHolder(layoutInflater.inflate(R.layout.item_user, parent, false))
    }
    override fun getItemCount(): Int {
        return userList.size
    }
}