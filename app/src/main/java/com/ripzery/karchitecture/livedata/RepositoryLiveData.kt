package com.ripzery.karchitecture.livedata

import android.arch.lifecycle.LiveData
import android.util.Log
import com.ripzery.karchitecture.ext.EuroLogger
import com.ripzery.karchitecture.ext.info
import com.ripzery.karchitecture.model.Repository
import com.ripzery.karchitecture.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Euro on 7/21/2017 AD.
 */
class RepositoryLiveData(val query: String) : LiveData<List<Repository>>(), EuroLogger {
    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onActive() {
        super.onActive()
        info { "Active" }
        val disposable = ApiService.github.searchRepositories(query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    this.value = it.items
                }, {
                    Log.e("RepositoryLiveData", "Error")
                })

        compositeDisposable.add(disposable)
    }

    override fun onInactive() {
        super.onInactive()
        info { "Inactive" }
        compositeDisposable.clear()
    }
}