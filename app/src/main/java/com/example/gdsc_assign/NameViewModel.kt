package com.example.gdsc_assign

import android.media.RouteListingPreference.Item
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NameViewModel : ViewModel() {
    val _currentToDoItem : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val currentToDoItem : LiveData<String>
    get() =  _currentToDoItem
    //이 get함수가 필수구나 메모메모
}