package com.ripzery.karchitecture

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.ripzery.karchitecture.model.Result
import com.ripzery.karchitecture.model.User

/**
 * Created by Euro on 7/20/2017 AD.
 */
interface MainContract {
    interface View {
        fun showUser(user: LiveData<User>)
    }

    interface ViewModel {
        fun fetchUser(name: String)
        fun getUserLiveData(): LiveData<User>
    }
}