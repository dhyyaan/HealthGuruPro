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
import com.think360.pro.healthguru.doctors.adapter.ProfileBindingAdapter
import com.think360.pro.healthguru.doctors.databinding.ProfileChildFragmentBinding
import com.think360.pro.healthguru.doctors.databinding.ProfileSettingsFragmentBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.PatientsItem
import com.think360.pro.healthguru.doctors.model.ProfileItem

/**
 * Created by think360 on 29/08/17.
 */
class PatientProfileDetailFragment : Fragment() {
    companion object {
        fun newInstance(): PatientProfileDetailFragment {
            return PatientProfileDetailFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val   profileSettingsFragmentBinding   = DataBindingUtil.inflate<ProfileSettingsFragmentBinding>(inflater, R.layout.profile_settings_fragment, container, false)

        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.navigation?.visibility =  View.VISIBLE
        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.tvMainTitle?.text = resources.getString(R.string.nav_title_profile)


        val actionCallback = object : ActionCallback {
            override   fun onClick(item: Any) {
                val objItem = item as PatientsItem?
                Log.d("Notification Detail",objItem?.name)

            }

        }
        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.ivBack?.setOnClickListener {
            DoctorsActivity?.doctorsActivity?.onBackPressed()
        }

        val mPackagesList = ArrayList<ProfileItem>()
        mPackagesList.add(0, ProfileItem(R.drawable.user_name,"Harpreet Kaur",false))
        mPackagesList.add(1, ProfileItem(R.drawable.user_email,"harpreet.kaur@gmail.com",false))
        mPackagesList.add(2, ProfileItem(R.drawable.user_phone,"111-111-1111",false))
        mPackagesList.add(3, ProfileItem(R.drawable.user_bloodgroup,"B+",false))
        mPackagesList.add(4, ProfileItem(R.drawable.user_gender,"Female",false))
        mPackagesList.add(5, ProfileItem(R.drawable.user_age,"28",false))
        mPackagesList.add(6, ProfileItem(R.drawable.user_allergy,"Dust Allergy",false))

        val adapter = ProfileBindingAdapter(mPackagesList)
        profileSettingsFragmentBinding.rvProfile.adapter = adapter


        adapter.notifyDataSetChanged()
        profileSettingsFragmentBinding.ivProfileImageEdit.visibility = View.GONE
        profileSettingsFragmentBinding.tvProfileName.visibility = View.GONE
        profileSettingsFragmentBinding.llContact.visibility = View.GONE
        return profileSettingsFragmentBinding.root
    }
}