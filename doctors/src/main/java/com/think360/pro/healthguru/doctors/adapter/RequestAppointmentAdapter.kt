package com.think360.pro.healthguru.doctors.adapter

import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundAdapter
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundViewHolder
import com.think360.pro.healthguru.doctors.databinding.AptHistoryRvListBinding
import com.think360.pro.healthguru.doctors.databinding.RequestAptRvItemBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.AptHistoryItem
import com.think360.pro.healthguru.doctors.model.RequestAptItem

/**
 * Created by think360 on 31/08/17.
 */
class RequestAppointmentAdapter  : DataBoundAdapter<RequestAptRvItemBinding> {


    var mProfileList = ArrayList<RequestAptItem>()
    var mActionCallback: ActionCallback?= null

    constructor(actionCallback: ActionCallback, mProfileList : ArrayList<RequestAptItem>) : super(R.layout.request_apt_rv_item) {
        this. mProfileList = mProfileList
        this. mActionCallback = actionCallback
    }

    override fun bindItem(holder: DataBoundViewHolder<RequestAptRvItemBinding>?, position: Int, payloads: MutableList<Any>?) {
        holder?.binding?.data = mProfileList.get(position)
        holder?.binding?.callback = mActionCallback

    }

    override fun getItemCount(): Int {
        return mProfileList.size
    }


}
