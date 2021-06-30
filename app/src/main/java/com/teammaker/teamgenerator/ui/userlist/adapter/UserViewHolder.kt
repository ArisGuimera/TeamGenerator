package com.teammaker.teamgenerator.ui.userlist.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.teammaker.teamgenerator.databinding.ItemUserBinding
import com.teammaker.teamgenerator.domain.model.UserModel

class UserViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemUserBinding.bind(view)

    fun render(userModel: UserModel){
        binding.tvUser.text = userModel.name
    }
}