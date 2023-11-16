package com.example.petadoptionfinals.mvvm

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.petadoptionfinals.model.StudentsModel
import java.io.File
import java.util.Scanner

class StudentViewModel :ViewModel() {

    private val studentsList = MutableLiveData<ArrayList<StudentsModel>>()
    val contactState : LiveData<ArrayList<StudentsModel>> get() = studentsList

    fun getStudentData(context: Context){
        initData(context)

    }

    private fun initData(context: Context) {
        var path : File = context.filesDir
        var file : File = File(path, "datafile.txt")
        val temp = ArrayList<StudentsModel>()
        val sc : Scanner = Scanner(file)

        var array : List<String> = listOf()

        while (sc.hasNextLine()){
            val str = sc
            val delim = ","
            array = sc.nextLine().split(delim)
            temp.add(StudentsModel(array[0],array[1],array[2]))
        }
        studentsList.value = temp
    }

}