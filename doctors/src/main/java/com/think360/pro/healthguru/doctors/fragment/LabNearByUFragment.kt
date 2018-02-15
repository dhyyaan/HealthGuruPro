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
import com.think360.pro.healthguru.doctors.adapter.LabNearByUAdapter
import com.think360.pro.healthguru.doctors.databinding.LabNearByUFragmentBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.LabNearByUItem

/**
 * Created by think360 on 24/08/17.
 */
class LabNearByUFragment : Fragment() {
    companion object {
        fun newInstance(): LabNearByUFragment {
            return LabNearByUFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val   labNearByUFragmentBindingt   = DataBindingUtil.inflate<LabNearByUFragmentBinding>(inflater, R.layout.lab_near_by_u_fragment, container, false)

      //  DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.navigation?.visibility =  View.GONE



        val actionCallback = object : ActionCallback {
            override   fun onClick(item: Any) {
                val objItem = item as LabNearByUItem?
                Log.d("Notification Detail",""+objItem)

            }

        }
        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.ivBack?.setOnClickListener {
            DoctorsActivity!!.doctorsActivity!!.activityDoctorsBinding?.ivBack!!.visibility = View.GONE
            DoctorsActivity?.doctorsActivity?.onBackPressed()
        }
        val mPackagesList = ArrayList<LabNearByUItem>()
        mPackagesList.add(0, LabNearByUItem(1,R.drawable.user_1,"Tarun Clinic Lab","9915081706","SCO 434, 435, sector 15A \nChandigarh"))
        mPackagesList.add(1, LabNearByUItem(2,R.drawable.user_1,"Deep Clinic Lab","8923462735","SCO 535, Sector 22A \nChandigarh"))
        mPackagesList.add(2, LabNearByUItem(3,R.drawable.user_1,"Dr Lal Path Lab","9915081705","SCO 535, Sector 22A \nChandigarh"))
        mPackagesList.add(0, LabNearByUItem(4,R.drawable.user_1,"Tarun Clinic Lab","9915081706","SCO 434, 435, sector 15A \nChandigarh"))
        mPackagesList.add(1, LabNearByUItem(5,R.drawable.user_1,"Deep Clinic Lab","8923462735","SCO 535, Sector 22A \nChandigarh"))
        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.tvMainTitle?.text = mPackagesList.size.toString() +" "+resources.getString(R.string.txt_lab_near_by_u)


        val adapter = LabNearByUAdapter(actionCallback,mPackagesList)
        labNearByUFragmentBindingt.rvLabNearU.adapter = adapter
        adapter.notifyDataSetChanged()


        return labNearByUFragmentBindingt.root
    }
}