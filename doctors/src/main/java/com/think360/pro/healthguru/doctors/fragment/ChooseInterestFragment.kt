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
import com.think360.pro.healthguru.doctors.adapter.ChooseInterestAdapter
import com.think360.pro.healthguru.doctors.adapter.LabNearByUAdapter
import com.think360.pro.healthguru.doctors.databinding.ChooseInterestFragmentBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.ChooseItem
import com.think360.pro.healthguru.doctors.model.LabNearByUItem


/**
 * Created by think360 on 28/08/17.
 */
class ChooseInterestFragment : Fragment() {
    companion object {
        fun newInstance(): ChooseInterestFragment {
            return ChooseInterestFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val   chooseInterestFragmentBinding   = DataBindingUtil.inflate<ChooseInterestFragmentBinding>(inflater, R.layout.choose_interest_fragment, container, false)
        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.tvMainTitle?.text = resources.getString(R.string.txt_health_topic)


        val actionCallback = object : ActionCallback {
            override   fun onClick(item: Any) {
              //  val objItem = item as LabNearByUItem?
               DoctorsActivity.doctorsActivity?.replaceFragment(BlogChildByUFragment.newInstance())
            }
        }
        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.ivBack?.setOnClickListener {
            DoctorsActivity?.doctorsActivity?.onBackPressed()
        }
        val mPackagesList = ArrayList<ChooseItem>()
        mPackagesList.add(0, ChooseItem("Healthy Eating",true))
        mPackagesList.add(1, ChooseItem("Fitness",true))
        mPackagesList.add(2, ChooseItem("Mind-Body",true))
        mPackagesList.add(3, ChooseItem("Beauty",true))
        mPackagesList.add(4, ChooseItem("Weight Loss",true))
        mPackagesList.add(5, ChooseItem("Recipes",true))


        val adapter = ChooseInterestAdapter(actionCallback,mPackagesList)
        chooseInterestFragmentBinding.rvChooseInteresr.adapter = adapter
        adapter.notifyDataSetChanged()

        chooseInterestFragmentBinding.btnAddTest.visibility = View.GONE

        return chooseInterestFragmentBinding.root
    }
}