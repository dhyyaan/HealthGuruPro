package com.think360.pro.healthguru.doctors.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.activities.DoctorsActivity
import com.think360.pro.healthguru.doctors.adapter.PatientsBindingAdapter
import com.think360.pro.healthguru.doctors.databinding.OldAppointmentFragmentBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.PatientsItem


/**
 * Created by think360 on 22/08/17.
 */
class OldAppointmentFragment : Fragment() {
    companion object {
        fun newInstance(): OldAppointmentFragment {
            return OldAppointmentFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val   oldApptFragmentBinding   = DataBindingUtil.inflate<OldAppointmentFragmentBinding>(inflater, R.layout.old_appointment_fragment, container, false)
        val actionCallback = object : ActionCallback {
            override   fun onClick(item: Any) {
                val objItem = item as PatientsItem?
                Log.d("Notification Detail",objItem?.name)
                DoctorsActivity.doctorsActivity?.replaceFragment(PatientProfileFragment.newInstance())
            }

        }
        val mPackagesList = ArrayList<PatientsItem>()
        mPackagesList.add(0, PatientsItem("Harpreet Kaur","Corporate","F","10-11",R.drawable.user_1))
        mPackagesList.add(1, PatientsItem("GurPreet Singh","Corporate","M","11-12",R.drawable.user_2))
        mPackagesList.add(2, PatientsItem("Harpreet Kaur","Corporate","F","12-01",R.drawable.user_1))
        mPackagesList.add(3, PatientsItem("GurPreet Singh","Corporate","M","02-03",R.drawable.user_2))

        val adapter = PatientsBindingAdapter(actionCallback,mPackagesList )

        oldApptFragmentBinding.rvRearchResult.adapter = adapter
        adapter.notifyDataSetChanged()
        return oldApptFragmentBinding.root
    }
}
