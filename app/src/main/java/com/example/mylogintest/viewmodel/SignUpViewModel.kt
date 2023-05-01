package com.example.mylogintest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {
    val uid: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val password: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val passwordAgain: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val result: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val verifyCode: MutableLiveData<String> by lazy { MutableLiveData<String>() }

}