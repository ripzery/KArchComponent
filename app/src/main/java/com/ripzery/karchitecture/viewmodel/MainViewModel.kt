package com.ripzery.karchitecture.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.ripzery.karchitecture.MainContract
import com.ripzery.karchitecture.livedata.UserLiveData
import com.ripzery.karchitecture.model.Result
import com.ripzery.karchitecture.model.User
import com.ripzery.karchitecture.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Euro on 7/20/2017 AD.
 */
class MainViewModel : ViewModel(){
    val user: LiveData<User> by lazy { UserLiveData("ripzery") }

    fun getUserLiveData() : LiveData<User>{
        return user
    }
}