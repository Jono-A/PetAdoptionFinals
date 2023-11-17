package com.example.petadoptionfinals.mvvm

import com.example.petadoptionfinals.model.Pets

sealed class CurrentPetState {

    data class Success(val studentsList: ArrayList <Pets>?) : CurrentPetState()

    object Error : CurrentPetState()

    object Loading : CurrentPetState()

}
