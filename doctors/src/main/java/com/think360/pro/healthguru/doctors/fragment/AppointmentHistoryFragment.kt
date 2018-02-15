package com.think360.pro.healthguru.doctors.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.activities.DoctorsActivity
import com.think360.pro.healthguru.doctors.adapter.AptHistoryAdapter
import com.think360.pro.healthguru.doctors.adapter.ChooseInterestAdapter
import com.think360.pro.healthguru.doctors.databinding.ChooseInterestFragmentBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.AptHistoryItem
import com.think360.pro.healthguru.doctors.model.ChooseItem

/**
 * Created by think360 on 29/08/17.
 */
class AppointmentHistoryFragment : Fragment() {
    companion object {
        fun newInstance(): AppointmentHistoryFragment {
            return AppointmentHistoryFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val   chooseInterestFragmentBinding   = DataBindingUtil.inflate<ChooseInterestFragmentBinding>(inflater, R.layout.choose_interest_fragment, container, false)
        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.tvMainTitle?.text = resources.getString(R.string.txt_title_apt_history)
        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.navigation?.visibility = View.VISIBLE

        val actionCallback = object : ActionCallback {
            override   fun onClick(item: Any) {
                //  val objItem = item as LabNearByUItem?
                DoctorsActivity.doctorsActivity?.replaceFragment(AptHistoryDetailFragment.newInstance())
            }
        }
        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.ivBack?.setOnClickListener {
            DoctorsActivity?.doctorsActivity?.onBackPressed()
        }
        val mPackagesList = ArrayList<AptHistoryItem>()
        mPackagesList.add(0, AptHistoryItem(1,"M","10-11","17 March 2017","2 Test","1 Preception"))
        mPackagesList.add(1, AptHistoryItem(2,"F","03-04","10 March 2017","1 Test","1 Preception"))
        mPackagesList.add(2, AptHistoryItem(3,"M","10-11","01 March 2017","3 Test","0 Preception"))


        val adapter = AptHistoryAdapter(actionCallback,mPackagesList)
        chooseInterestFragmentBinding.rvChooseInteresr.adapter = adapter
        adapter.notifyDataSetChanged()
        chooseInterestFragmentBinding.btnAddTest.visibility = View.GONE


        return chooseInterestFragmentBinding.root
    }
}