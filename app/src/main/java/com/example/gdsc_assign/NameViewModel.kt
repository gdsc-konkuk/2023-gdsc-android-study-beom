package com.example.gdsc_assign

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NameViewModel : ViewModel() {
    private val _currentName : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val currentName : LiveData<String>
        get() =  _currentName
    //이 get함수가 필수구나 메모메모
}