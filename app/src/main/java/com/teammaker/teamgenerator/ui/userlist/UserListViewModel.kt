package com.teammaker.teamgenerator.ui.userlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.teammaker.teamgenerator.domain.model.UserModel

class UserListViewModel : ViewModel() {

    val usersLiveData = MutableLiveData<MutableList<UserModel>>()
    val eventLiveData = MutableLiveData<MutableList<UserModel>>()

    fun onCreate() {
    }

    fun onUserAdded(newUser: String) {
        val temp: MutableList<UserModel> = usersLiveData.value ?: mutableListOf()
        temp.add(UserModel(newUser, 0))
        usersLiveData.postValue(temp)
    }

    fun onGenerateTeamCliked() {
        eventLiveData.postValue(usersLiveData.value ?: mutableListOf())
    }

    fun clearUsers() {
        usersLiveData.postValue(mutableListOf())
    }


}