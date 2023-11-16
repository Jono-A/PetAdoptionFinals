package com.example.petadoptionfinals.mvvm

import com.example.petadoptionfinals.model.StudentsModel

sealed class CurrentContactState {

    data class Success(val studentsList: ArrayList <StudentsModel>?) : CurrentContactState()

    object Error : CurrentContactState()

    object Loading : CurrentContactState()

}
