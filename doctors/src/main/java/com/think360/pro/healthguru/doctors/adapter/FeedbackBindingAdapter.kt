package com.think360.pro.healthguru.doctors.adapter

import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundAdapter
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundViewHolder
import com.think360.pro.healthguru.doctors.databinding.FeedbackListItemBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.FeedbackItem

/**
 * Created by think360 on 12/08/17.
 */
class FeedbackBindingAdapter : DataBoundAdapter<FeedbackListItemBinding> {


    var mBlogList = ArrayList<FeedbackItem>()

    var mActionCallback: ActionCallback?= null

    constructor(actionCallback : ActionCallback  ,mBlogList : ArrayList<FeedbackItem>) : super(R.layout.feedback_list_item) {
        this. mBlogList = mBlogList
        this. mActionCallback = actionCallback
    }

    override fun bindItem(holder: DataBoundViewHolder<FeedbackListItemBinding>?, position: Int, payloads: MutableList<Any>?) {
        holder?.binding?.data = mBlogList.get(position)
        holder?.binding?.callback = mActionCallback
        holder?.binding?.cIvProfilePic?.setImageResource(mBlogList.get(position).proImage)
    }

    override fun getItemCount(): Int {
        return mBlogList.size
    }
}
