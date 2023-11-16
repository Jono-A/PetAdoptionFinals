package com.example.petadoptionfinals.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pets(

    //var profilePic: String,
    var name : String?,
    var email : String?,
    var phone : String?,
) : Parcelable
