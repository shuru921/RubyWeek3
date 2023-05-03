package com.example.mylogintest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val uid: MutableLiveData<String> by lazy { MutableLiveData<String>()}
    val password: MutableLiveData<String> by lazy { MutableLiveData<String>()}

}