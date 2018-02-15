package com.think360.pro.healthguru.doctors.adapter

import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundAdapter
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundViewHolder
import com.think360.pro.healthguru.doctors.databinding.BlogChildListItemBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.BlogItem

/**
 * Created by think360 on 04/08/17.
 */
class BlogByUBindingAdapter : DataBoundAdapter<BlogChildListItemBinding> {


    var mBlogList = ArrayList<BlogItem>()

    var mActionCallback: ActionCallback?= null

    constructor(actionCallback : ActionCallback  ,mBlogList : ArrayList<BlogItem>) : super(R.layout.blog_child_list_item) {
        this. mBlogList = mBlogList
        this. mActionCallback = actionCallback
    }

    override fun bindItem(holder: DataBoundViewHolder<BlogChildListItemBinding>?, position: Int, payloads: MutableList<Any>?) {
        holder?.binding?.data = mBlogList.get(position)
        holder?.binding?.ivBlog?.setImageResource(mBlogList.get(position).ivBlog)
        holder?.binding?.callback = mActionCallback
    }

    override fun getItemCount(): Int {
        return mBlogList.size
    }
}
