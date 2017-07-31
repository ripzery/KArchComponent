package com.ripzery.karchitecture

import android.annotation.SuppressLint
import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.support.v7.app.AppCompatActivity

@SuppressLint("Registered")
/**
 * Created by Euro on 7/21/2017 AD.
 */
open class BaseActivity : AppCompatActivity(), LifecycleRegistryOwner {
    val registry: LifecycleRegistry = LifecycleRegistry(this)
    override fun getLifecycle(): LifecycleRegistry {
        return registry
    }
}