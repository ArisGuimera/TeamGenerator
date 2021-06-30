package com.teammaker.teamgenerator.ui.result

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.teammaker.teamgenerator.domain.model.MatchTeam
import com.teammaker.teamgenerator.domain.model.UserModel
import com.teammaker.teamgenerator.domain.usecase.GetRandomTeams

class ResultViewModel:ViewModel() {

    val getRandomTeams = GetRandomTeams()

    val matchTeamLiveData = MutableLiveData< List<Pair<MatchTeam, MatchTeam>>>()


    fun onCreate(users: ArrayList<UserModel>) {
        val result = getRandomTeams(users)
        matchTeamLiveData.postValue(result)
    }
}