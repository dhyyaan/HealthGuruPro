package com.think360.pro.healthguru.doctors.adapter

import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundAdapter
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundViewHolder
import com.think360.pro.healthguru.doctors.databinding.AptHistoryRvListBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.AptHistoryItem


/**
 * Created by think360 on 29/08/17.
 */
class AptHistoryAdapter : DataBoundAdapter<AptHistoryRvListBinding> {


    var mProfileList = ArrayList<AptHistoryItem>()
    var mActionCallback: ActionCallback?= null

    constructor(actionCallback: ActionCallback, mProfileList : ArrayList<AptHistoryItem>) : super(R.layout.apt_history_rv_list) {
        this. mProfileList = mProfileList
           this. mActionCallback = actionCallback
    }

    override fun bindItem(holder: DataBoundViewHolder<AptHistoryRvListBinding>?, position: Int, payloads: MutableList<Any>?) {
        holder?.binding?.data = mProfileList.get(position)
        holder?.binding?.callback = mActionCallback

    }

    override fun getItemCount(): Int {
        return mProfileList.size
    }


}
