package com.ripzery.karchitecture.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.ripzery.karchitecture.livedata.RepositoryLiveData
import com.ripzery.karchitecture.model.Repository

/**
 * Created by Euro on 7/20/2017 AD.
 */
class RepositoryViewModel : ViewModel() {
    val repositories: LiveData<List<Repository>> by lazy { RepositoryLiveData("network+language:kotlin") }
}