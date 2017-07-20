package com.ripzery.karchitecture

import android.arch.lifecycle.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ripzery.karchitecture.model.Result
import com.ripzery.karchitecture.model.User
import com.ripzery.karchitecture.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : LifecycleActivity() {

    lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        mViewModel.getUserLiveData().observe(this, Observer<User> {
            tvName.text = it?.login
            tvSomething.text = it?.starredUrl
        })
    }
}