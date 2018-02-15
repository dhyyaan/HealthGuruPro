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
import com.think360.pro.healthguru.doctors.databinding.AddMoreTestSearchFragmentBinding
import com.think360.pro.healthguru.doctors.databinding.AddTestFragmentBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.AddTestItem

/**
 * Created by think360 on 30/08/17.
 */
class AddMoreTestSearchFragment : Fragment() {
    companion object {
        fun newInstance(): AddMoreTestSearchFragment {
            return AddMoreTestSearchFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val   addMoreTestSearchFragmentBinding   = DataBindingUtil.inflate<AddMoreTestSearchFragmentBinding>(inflater, R.layout.add_more_test_search_fragment, container, false)
      //  DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.tvMainTitle?.text = resources.getString(R.string.txt_health_topic)
       DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.rl?.visibility = View.GONE
        addMoreTestSearchFragmentBinding.btnDone.visibility = View.VISIBLE
        val actionCallback = object : ActionCallback {
            override   fun onClick(item: Any) {
                //  val objItem = item as LabNearByUItem?
              //  DoctorsActivity.doctorsActivity?.replaceFragment(BlogChildByUFragment.newInstance())
            }
        }
        addMoreTestSearchFragmentBinding.ivBack?.setOnClickListener {
          // DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.rl?.visibility = View.VISIBLE
            DoctorsActivity?.doctorsActivity?.onBackPressed()
        }
        val mPackagesList = ArrayList<AddTestItem>()
        mPackagesList.add(0, AddTestItem(1,"CBC(Complete Blood Counts)",true))
        mPackagesList.add(1, AddTestItem(2,"Blood Group",true))



        val adapter = AddTestAdapter(actionCallback,mPackagesList)
        addMoreTestSearchFragmentBinding.rvMoreTest.adapter = adapter
        adapter.notifyDataSetChanged()

        //  addTestFragmentBinding.btnAddTest.visibility = View.GONE


        return addMoreTestSearchFragmentBinding.root
    }
}