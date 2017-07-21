package com.ripzery.karchitecture

import android.arch.lifecycle.*
import android.os.Bundle
import android.util.Log
import com.ripzery.karchitecture.model.Repository
import com.ripzery.karchitecture.viewmodel.RepositoryViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    lateinit var mViewModel: RepositoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initInstance()
    }

    fun initInstance(){
        mViewModel = ViewModelProviders.of(this).get(RepositoryViewModel::class.java)
        showRepositories()
    }

    fun showRepositories(){
        mViewModel.repositories.observe(this, Observer<List<Repository>> {
            Log.d(this.localClassName, it?.toString())
            tvName.text = it?.get(0)?.fullName
            tvSomething.text = it?.get(0)?.url
        })
    }
}