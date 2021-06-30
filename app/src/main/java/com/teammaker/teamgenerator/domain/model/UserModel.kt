package com.teammaker.teamgenerator.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(val name:String, val skill:Int):Parcelable