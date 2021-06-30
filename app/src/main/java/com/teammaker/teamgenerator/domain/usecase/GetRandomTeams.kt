package com.teammaker.teamgenerator.domain.usecase

import com.teammaker.teamgenerator.domain.model.MatchTeam
import com.teammaker.teamgenerator.domain.model.UserModel

class GetRandomTeams {

    val usersForTeams = 1

    //Funciona = Emparejamiento 1 vs 1 y shufel

    //No funciona
    // emparejamiento varios por equipo

    operator fun invoke(users: ArrayList<UserModel>): List<Pair<MatchTeam, MatchTeam>> {
        val randomList = users.toMutableList()
        randomList.shuffle()
        val list = mutableListOf<Pair<MatchTeam, MatchTeam>>()

        randomList.forEachIndexed { index, userModel ->
            if (index % 2 == 0 && randomList.size > index+1) {
                list.add(
                    Pair(
                        MatchTeam(mutableListOf(userModel)),
                        MatchTeam(mutableListOf(randomList[index + 1]))
                    )
                )
            }else if(randomList.lastIndex == index){
                list.add(
                    Pair(
                        MatchTeam(mutableListOf(userModel)),
                        MatchTeam()
                    )
                )
            }
        }
        return list
    }
}