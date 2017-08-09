package com.ripzery.karchitecture

import android.arch.lifecycle.*
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ripzery.karchitecture.ext.EuroLogger
import com.ripzery.karchitecture.model.Repository
import com.ripzery.karchitecture.viewgroup.RepoViewGroup
import com.ripzery.karchitecture.viewmodel.RepositoryViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_repo.view.*
import org.jetbrains.anko.find

class MainActivity : BaseActivity(), EuroLogger {
    lateinit var mViewModel: RepositoryViewModel
    private val mAdapter: RepositoryAdapter by lazy { RepositoryAdapter(listOf()) }
    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }

    external fun stringFromJNI(): String
    external fun getApi(keyHash: String): String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initInstance()
    }

    fun initInstance() {
        mViewModel = ViewModelProviders.of(this).get(RepositoryViewModel::class.java)
        recyclerView.adapter = mAdapter
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        val dividerItemDecoration = DividerItemDecoration(this, linearLayoutManager.orientation)
        recyclerView.addItemDecoration(dividerItemDecoration)
        layoutLoading.visibility = View.VISIBLE
        showRepositories()
    }

    fun showRepositories() {
        mViewModel.repositories.observe(this, Observer<List<Repository>> {
            mAdapter.list = it ?: listOf()
            mAdapter.notifyDataSetChanged()
            layoutLoading.visibility = View.GONE
        })
    }

    inner class RepositoryAdapter(var list: List<Repository>): RecyclerView.Adapter<RepositoryAdapter.RepositoryViewholder>(){
        override fun getItemCount(): Int = list.size
        override fun onBindViewHolder(holder: RepositoryViewholder, position: Int) { holder.setModel(list[position]) }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewholder = RepositoryViewholder(LayoutInflater.from(parent.context).inflate(R.layout.viewgroup_repo, parent, false))
        inner class RepositoryViewholder(itemView: View): RecyclerView.ViewHolder(itemView) {
            fun setModel(model: Repository){
                itemView.find<RepoViewGroup>(R.id.repoViewGroup).setModel(model)
            }
        }
    }
}