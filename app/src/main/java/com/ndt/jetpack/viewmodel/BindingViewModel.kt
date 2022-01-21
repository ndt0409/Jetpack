package com.ndt.jetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BindingViewModel : ViewModel() {
    private val _link = MutableLiveData<String>()
    val link: LiveData<String> get() = _link

    var text: String = "I love <b>Android</b> and <i>Kotlin</i>"

    init {
        _link.postValue("https://afamilycdn.com/150157425591193600/2020/8/14/5bd607e0c0cb89afbe0d17eda2f628fc-15719007946641269292659-1597408958984187658156.png")
    }
}