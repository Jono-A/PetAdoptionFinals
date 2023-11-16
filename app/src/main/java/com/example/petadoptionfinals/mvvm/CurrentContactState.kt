package com.example.petadoptionfinals.mvvm

import com.example.petadoptionfinals.model.Pets

sealed class CurrentContactState {

    data class Success(val studentsList: ArrayList <Pets>?) : CurrentContactState()

    object Error : CurrentContactState()

    object Loading : CurrentContactState()

}
