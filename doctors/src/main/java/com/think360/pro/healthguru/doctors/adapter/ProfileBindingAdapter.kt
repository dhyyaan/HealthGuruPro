package com.think360.pro.healthguru.doctors.adapter

import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundAdapter
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundViewHolder

import com.think360.pro.healthguru.doctors.databinding.ProfileSettingsListItemBinding

import com.think360.pro.healthguru.doctors.model.ProfileItem

/**
 * Created by think360 on 09/08/17.
 */
class ProfileBindingAdapter : DataBoundAdapter<ProfileSettingsListItemBinding> {


    var mProfileList = ArrayList<ProfileItem>()

   // var mActionCallback: ActionCallback?= null

    constructor( mProfileList : ArrayList<ProfileItem>) : super(R.layout.profile_settings_list_item) {
        this. mProfileList = mProfileList
     //   this. mActionCallback = actionCallback
    }

    override fun bindItem(holder: DataBoundViewHolder<ProfileSettingsListItemBinding>?, position: Int, payloads: MutableList<Any>?) {
        holder?.binding?.data = mProfileList.get(position)
        holder?.binding?.ivProfile?.setImageResource(mProfileList.get(position).ivProfileImage)
    }

    override fun getItemCount(): Int {
        return mProfileList.size
    }


}
