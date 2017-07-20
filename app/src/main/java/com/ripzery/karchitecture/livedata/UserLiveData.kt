package com.ripzery.karchitecture.livedata

import android.arch.lifecycle.LiveData
import android.util.Log
import com.ripzery.karchitecture.model.Result
import com.ripzery.karchitecture.model.User
import com.ripzery.karchitecture.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by Euro on 7/20/2017 AD.
 */
class UserLiveData(var name: String) : LiveData<User>() {
    var disposable: Disposable? = null
    override fun onActive() {
        super.onActive()
        Log.d("UserLiveData", "onActive")
        disposable = ApiService.github.search(name, 1, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    this.value = it.items[0]
                }, {
                })
    }

    override fun onInactive() {
        super.onInactive()
        Log.d("UserLiveData", "onInactive")
        disposable?.dispose()
    }
}