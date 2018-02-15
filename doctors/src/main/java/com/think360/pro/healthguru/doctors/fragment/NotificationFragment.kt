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
import com.think360.pro.healthguru.doctors.adapte.NotificationBindingAdapter
import com.think360.pro.healthguru.doctors.databinding.NotificationFragmentBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.NotificationItem


/**
 * Created by think360 on 11/08/17.
 */
class NotificationFragment : Fragment() {
    companion object {
        fun newInstance(): NotificationFragment {
            return NotificationFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val   notFragmentBinding   = DataBindingUtil.inflate<NotificationFragmentBinding>(inflater, R.layout.notification_fragment, container, false)
        val actionCallback = object : ActionCallback {
            override   fun onClick(item: Any) {
                val objItem = item as NotificationItem?
              //  Log.d("Notification Detail",objItem?.name)
                DoctorsActivity.doctorsActivity?.replaceFragment(PatientProfileFragment.newInstance())

            }

        }

        val mPackagesList = ArrayList<NotificationItem>()

        mPackagesList.add(0, NotificationItem(1,"Harpreet Kaur","3 min ago","Request for new Appointment","F","10-11",R.drawable.user_1))
        mPackagesList.add(1, NotificationItem(2,"GurPreet Singh","1 day ago","New Patient","M","11-12",R.drawable.user_2))
        mPackagesList.add(2, NotificationItem(3,"Harpreet Kaur","5 min ago","Request for new Appointment","F","12-01",R.drawable.user_1))
        mPackagesList.add(3, NotificationItem(4,"GurPreet Singh","2 days ago","New Patient","M","02-03",R.drawable.user_2))

        val adapter = NotificationBindingAdapter(actionCallback,mPackagesList )

        notFragmentBinding.rvRearchResult.adapter = adapter
        adapter.notifyDataSetChanged()


        return notFragmentBinding.root
    }
}
