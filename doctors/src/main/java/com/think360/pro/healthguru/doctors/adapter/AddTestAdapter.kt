package com.think360.pro.healthguru.doctors.adapter

import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundAdapter
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundViewHolder
import com.think360.pro.healthguru.doctors.databinding.AddTestRvItemBinding
import com.think360.pro.healthguru.doctors.databinding.AptHistoryRvListBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.AddTestItem
import com.think360.pro.healthguru.doctors.model.AptHistoryItem

/**
 * Created by think360 on 30/08/17.
 */
class AddTestAdapter  : DataBoundAdapter<AddTestRvItemBinding> {


    var mProfileList = ArrayList<AddTestItem>()
    var mActionCallback: ActionCallback?= null

    constructor(actionCallback: ActionCallback, mProfileList : ArrayList<AddTestItem>) : super(R.layout.add_test_rv_item) {
        this. mProfileList = mProfileList
        this. mActionCallback = actionCallback
    }

    override fun bindItem(holder: DataBoundViewHolder<AddTestRvItemBinding>?, position: Int, payloads: MutableList<Any>?) {
        holder?.binding?.data = mProfileList.get(position)
       // holder?.binding?.callback = mActionCallback

    }

    override fun getItemCount(): Int {
        return mProfileList.size
    }


}
