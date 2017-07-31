package com.ripzery.karchitecture.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import com.ripzery.karchitecture.ext.EuroLogger
import com.ripzery.karchitecture.ext.info
import com.ripzery.karchitecture.livedata.RepositoryLiveData
import com.ripzery.karchitecture.model.Repository

/**
 * Created by Euro on 7/20/2017 AD.
 */
class RepositoryViewModel : ViewModel(), EuroLogger {
    val repositories: LiveData<List<Repository>> by lazy { RepositoryLiveData("network+language:kotlin") }

    override fun onCleared() {
        super.onCleared()
        info { "onCleared" }
    }
}