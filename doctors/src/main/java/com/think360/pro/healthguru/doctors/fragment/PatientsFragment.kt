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
import com.think360.pro.healthguru.doctors.databinding.MorningFragmentBinding
import com.think360.pro.healthguru.doctors.databinding.PatientsFragmentBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.interfaces.ApiService
import com.think360.pro.healthguru.doctors.model.CountryResponse
import com.think360.pro.healthguru.doctors.model.PatientsItem
import com.think360.pro.healthguru.doctors.utils.AppController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by think360 on 01/08/17.
 */
class PatientsFragment : Fragment() {
    @Inject
    lateinit var apiService: ApiService
    companion object {
        fun newInstance(): PatientsFragment {
            return PatientsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val   patientsFragmentBinding   = DataBindingUtil.inflate<PatientsFragmentBinding>(inflater, R.layout.patients_fragment, container, false)
       (activity.application as AppController).getComponent().inject(this@PatientsFragment)
     //   DoctorsActivity.doctorsActivity?.activityDoctorsBinding?.tvMainTitle?.text = resources.getString(R.string.nav_title_patients)


        val actionCallback = object : ActionCallback {
         override   fun onClick(item: Any) {
                // val objItem = item as PatientsItem?
                //Log.d("Notification Detail",objItem?.name)
             DoctorsActivity.doctorsActivity?.replaceFragment(PatientProfileFragment.newInstance())
            }

        }
        DoctorsActivity.doctorsActivity?.activityDoctorsBinding?.ivBack?.setOnClickListener {
            DoctorsActivity.doctorsActivity?.onBackPressed()
        }
        apiService!!.getCountries().enqueue(object : Callback<CountryResponse> {
            override fun onResponse(call: Call<CountryResponse>, response: Response<CountryResponse>) {
                if (response.isSuccessful() && response.body().getStatus()) {
                    Log.d("",""+response.body().data.country.size);
                   // progressBarCountry.setVisibility(View.GONE)
                  //  etCountry.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_action_lab, 0)
                  //  etCountry.setClickable(true)
                  //  chooserDialogFragment = ChooserDialogFragment.newInstance()
                  //  chooserDialogFragment.setList(response.body().getData().getCountry() as AbstractList<*>, this@PatientsFragment)
                  //  etCountry.setClickable(true)
                } else {
                   // showSimpleDialog(this@AddAvailabilityActivity, response.body().getMessage())
                }
            }

            override fun onFailure(call: Call<CountryResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })
        patientsFragmentBinding.buttonAddApnt.setOnClickListener {   DoctorsActivity.doctorsActivity?. replaceFragment(AddPatientsAppointmentFragment.newInstance()) }
        val mPackagesList = ArrayList<PatientsItem>()
        mPackagesList.add(0,PatientsItem("Harpreet Kaur","Corporate","F","10-11",R.drawable.user_1))
        mPackagesList.add(1,PatientsItem("GurPreet Singh","Corporate","M","11-12",R.drawable.user_2))
        mPackagesList.add(2,PatientsItem("Harpreet Kaur","Corporate","F","12-01",R.drawable.user_1))
        mPackagesList.add(3,PatientsItem("GurPreet Singh","Corporate","M","02-03",R.drawable.user_2))

        val adapter = PatientsBindingAdapter(actionCallback,mPackagesList)
        patientsFragmentBinding.rvRearchResult.adapter = adapter
        adapter.notifyDataSetChanged()
        return patientsFragmentBinding.root
    }


}
