package com.think360.pro.healthguru.doctors.adapter

import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundAdapter
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundViewHolder
import com.think360.pro.healthguru.doctors.databinding.LabNearByURecylerItemBinding
import com.think360.pro.healthguru.doctors.databinding.ProfileSettingsListItemBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.LabNearByUItem
import com.think360.pro.healthguru.doctors.model.ProfileItem

/**
 * Created by think360 on 24/08/17.
 */
class LabNearByUAdapter  : DataBoundAdapter<LabNearByURecylerItemBinding> {


    var mProfileList = ArrayList<LabNearByUItem>()

     var mActionCallback: ActionCallback?= null

    constructor(mActionCallback : ActionCallback,mProfileList : ArrayList<LabNearByUItem>) : super(R.layout.lab_near_by_u_recyler_item) {
        this. mProfileList = mProfileList
           this. mActionCallback = mActionCallback
    }

    override fun bindItem(holder: DataBoundViewHolder<LabNearByURecylerItemBinding>?, position: Int, payloads: MutableList<Any>?) {
        holder?.binding?.data = mProfileList.get(position)
        //holder?.binding?.ivProfile?.setImageResource(mProfileList.get(position).ivProfileImage)
       // holder?.binding?.ivForward?.setImageResource(mProfileList.get(position).ivForward)
        holder?.binding?.callback = mActionCallback
    }

    override fun getItemCount(): Int {
        return mProfileList.size
    }


}
