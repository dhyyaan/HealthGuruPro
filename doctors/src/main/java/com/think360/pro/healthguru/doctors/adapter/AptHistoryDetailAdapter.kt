package com.think360.pro.healthguru.doctors.adapter
import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundAdapter
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundViewHolder
import com.think360.pro.healthguru.doctors.databinding.AptHistoryDetailItemBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.HisDetailItem


/**
 * Created by think360 on 29/08/17.
 */
class AptHistoryDetailAdapter : DataBoundAdapter<AptHistoryDetailItemBinding> {


    var mBlogList = ArrayList<HisDetailItem>()
    var mActionCallback: ActionCallback?= null

    constructor( actionCallback : ActionCallback,mBlogList : ArrayList<HisDetailItem>) : super(R.layout.apt_history_detail_item) {
        this. mBlogList = mBlogList
        this. mActionCallback = actionCallback
    }

    override fun bindItem(holder: DataBoundViewHolder<AptHistoryDetailItemBinding>?, position: Int, payloads: MutableList<Any>?) {
         holder?.binding?.data = mBlogList.get(position)
        holder?.binding?.callback = mActionCallback
    }

    override fun getItemCount(): Int {
        return mBlogList.size
    }
}
