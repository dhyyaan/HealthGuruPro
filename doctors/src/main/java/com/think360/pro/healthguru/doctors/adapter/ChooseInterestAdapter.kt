package com.think360.pro.healthguru.doctors.adapter

import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundAdapter
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundViewHolder
import com.think360.pro.healthguru.doctors.databinding.ChooseInterestRvItemBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.ChooseItem
import java.util.ArrayList

/**
 * Created by think360 on 28/08/17.
 */
class ChooseInterestAdapter  : DataBoundAdapter<ChooseInterestRvItemBinding> {


    var mPatientsList = ArrayList<ChooseItem>()

    var mActionCallback: ActionCallback?= null

    constructor(actionCallback : ActionCallback, mPatientsList : ArrayList<ChooseItem>) : super(R.layout.choose_interest_rv_item) {
        this. mPatientsList = mPatientsList
        this. mActionCallback = actionCallback
    }

    override fun bindItem(holder: DataBoundViewHolder<ChooseInterestRvItemBinding>?, position: Int, payloads: MutableList<Any>?) {
        holder?.binding?.data = mPatientsList.get(position) as ChooseItem?
        holder?.binding?.callback = mActionCallback
    }

    override fun getItemCount(): Int {
        return mPatientsList.size
    }
}

