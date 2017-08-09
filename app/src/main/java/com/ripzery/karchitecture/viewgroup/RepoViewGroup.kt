package com.ripzery.karchitecture.viewgroup

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.ripzery.karchitecture.R
import com.ripzery.karchitecture.model.Repository
import kotlinx.android.synthetic.main.layout_repo.view.*

class RepoViewGroup : FrameLayout {
    lateinit var viewContainer: View
    constructor(context: Context) : super(context) { init() }
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) { init() }
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(context, attributeSet, defStyleAttr) { init(); }
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attributeSet, defStyleAttr, defStyleRes) { init(); }

    fun init() {
        viewContainer = View.inflate(context, R.layout.layout_repo, this)
    }

    fun setModel(model: Repository){
        viewContainer.tvFullName.text = model.name
        viewContainer.tvDescription.text = model.fullName
        viewContainer.tvFork.text = "${model.forksCount}"
        viewContainer.tvStar.text = "${model.stargazersCount}"
    }
}