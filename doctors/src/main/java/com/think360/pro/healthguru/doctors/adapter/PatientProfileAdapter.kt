package com.think360.pro.healthguru.doctors.adapter

import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundAdapter
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundViewHolder
import com.think360.pro.healthguru.doctors.databinding.PatientProfileListItemBinding
import com.think360.pro.healthguru.doctors.databinding.PatientsListItemBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.PatientProfileItem
import com.think360.pro.healthguru.doctors.model.PatientsItem
import java.util.ArrayList

/**
 * Created by think360 on 23/08/17.
 */
class PatientProfileAdapter  : DataBoundAdapter<PatientProfileListItemBinding> {


    var mPatientsList = ArrayList<PatientProfileItem>()

    var mActionCallback: ActionCallback?= null

    constructor(actionCallback : ActionCallback, mPatientsList : ArrayList<PatientProfileItem>) : super(R.layout.patient_profile_list_item) {
        this. mPatientsList = mPatientsList
        this. mActionCallback = actionCallback
    }

    override fun bindItem(holder: DataBoundViewHolder<PatientProfileListItemBinding>?, position: Int, payloads: MutableList<Any>?) {
        holder?.binding?.data = mPatientsList.get(position) as PatientProfileItem?
        holder?.binding?.callback = mActionCallback
        holder?.binding?.ivProfile?.setImageResource(mPatientsList.get(position).ivProfileImage)
    }

    override fun getItemCount(): Int {
        return mPatientsList.size
    }
}

