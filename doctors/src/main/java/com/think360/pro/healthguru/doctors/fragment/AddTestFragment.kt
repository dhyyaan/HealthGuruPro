package com.think360.pro.healthguru.doctors.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.activities.DoctorsActivity
import com.think360.pro.healthguru.doctors.adapter.AddTestAdapter
import com.think360.pro.healthguru.doctors.adapter.ChooseInterestAdapter
import com.think360.pro.healthguru.doctors.databinding.AddTestFragmentBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.AddTestItem
import com.think360.pro.healthguru.doctors.model.ChooseItem


/**
 * Created by think360 on 30/08/17.
 */
class AddTestFragment : Fragment() {
    companion object {
        fun newInstance(): AddTestFragment {
            return AddTestFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val   addTestFragmentBinding   = DataBindingUtil.inflate<AddTestFragmentBinding>(inflater, R.layout.add_test_fragment, container, false)
        DoctorsActivity.doctorsActivity?.activityDoctorsBinding?.tvMainTitle?.text = resources.getString(R.string.txt_health_topic)


        val actionCallback = object : ActionCallback {
            override   fun onClick(item: Any) {
                //  val objItem = item as LabNearByUItem?
                DoctorsActivity.doctorsActivity?.replaceFragment(BlogChildByUFragment.newInstance())
            }
        }
        DoctorsActivity.doctorsActivity?.activityDoctorsBinding?.ivBack?.setOnClickListener {
            DoctorsActivity?.doctorsActivity?.onBackPressed()
        }
        addTestFragmentBinding.btnAddMore.setOnClickListener { DoctorsActivity.doctorsActivity?.replaceFragment(AddMoreTestSearchFragment.newInstance()) }
        val mPackagesList = ArrayList<AddTestItem>()
        mPackagesList.add(0, AddTestItem(1,"Urine Routine Examination",true))
        mPackagesList.add(1, AddTestItem(2,"Lipid Profile",true))
        mPackagesList.add(2, AddTestItem(3,"LFT(Liver Function Test)",true))
        mPackagesList.add(3, AddTestItem(4,"KFT(Kidney Function Test)",true))
        mPackagesList.add(4, AddTestItem(5,"HbA1c(Glycated Hemoglobin)",true))
        mPackagesList.add(5, AddTestItem(6,"CBC(Complete Blood Counts)",true))


        val adapter = AddTestAdapter(actionCallback,mPackagesList)
        addTestFragmentBinding.rvMoreTest.adapter = adapter
        adapter.notifyDataSetChanged()

      //  addTestFragmentBinding.btnAddTest.visibility = View.GONE


        return addTestFragmentBinding.root
    }
}