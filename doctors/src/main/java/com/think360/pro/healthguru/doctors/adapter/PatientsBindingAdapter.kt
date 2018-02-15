package com.think360.pro.healthguru.doctors.adapter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.PatientsItem
import java.util.ArrayList
import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundAdapter
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundViewHolder
import com.think360.pro.healthguru.doctors.databinding.PatientsListItemBinding

/**
 * Created by think360 on 01/08/17.
 */
class PatientsBindingAdapter : DataBoundAdapter<PatientsListItemBinding>{


    var mPatientsList = ArrayList<PatientsItem>()

    var mActionCallback: ActionCallback ?= null

  constructor(actionCallback : ActionCallback  ,mPatientsList : ArrayList<PatientsItem>) : super(R.layout.patients_list_item) {
       this. mPatientsList = mPatientsList
        this. mActionCallback = actionCallback
    }

    override fun bindItem(holder: DataBoundViewHolder<PatientsListItemBinding>?, position: Int, payloads: MutableList<Any>?) {
        holder?.binding?.data = mPatientsList.get(position) as PatientsItem?
        holder?.binding?.callback = mActionCallback
    }

    override fun getItemCount(): Int {
        return mPatientsList.size
    }
}

