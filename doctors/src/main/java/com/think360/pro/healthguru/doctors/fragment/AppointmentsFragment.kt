package com.think360.pro.healthguru.doctors.fragment

import android.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.activities.DoctorsActivity
import com.think360.pro.healthguru.doctors.adapter.PatientsBindingAdapter
import com.think360.pro.healthguru.doctors.databinding.AppointmentsFragmentBinding
import com.think360.pro.healthguru.doctors.databinding.EveningFragmentBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.PatientsItem

/**
 * Created by think360 on 03/08/17.
 */
class AppointmentsFragment : Fragment() {
    var   apntFragmentBinding : AppointmentsFragmentBinding? = null
    companion object {
        fun newInstance(): AppointmentsFragment {
            return AppointmentsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

           apntFragmentBinding   = DataBindingUtil.inflate<AppointmentsFragmentBinding>(inflater, R.layout.appointments_fragment, container, false)

       // DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.navigation?.visibility =  View.GONE
      //  DoctorsActivity.doctorsActivity?.activityDoctorsBinding?.tvMainTitle?.text = resources.getString(R.string.nav_title_appointments)

        apntFragmentBinding?.btnNew?.setOnClickListener (mOnClickListener)
        apntFragmentBinding?.btnOld?.setOnClickListener (mOnClickListener)
        apntFragmentBinding?.btnAddAppointment?.setOnClickListener (mOnClickListener)
        apntFragmentBinding?.linearLayout?.setOnClickListener (mOnClickListener)
        apntFragmentBinding?.viewPager?.setAdapter(PagerAdapter(childFragmentManager, 2))
        apntFragmentBinding?.viewPager?.setCurrentItem(0)


        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.ivBack?.setOnClickListener {
            DoctorsActivity?.doctorsActivity?.onBackPressed()
        }



        return apntFragmentBinding?.root
    }

    private val mOnClickListener = View.OnClickListener  { item ->
        when (item.id) {
            R.id.btnNew -> {
                apntFragmentBinding?.btnNew?.setBackgroundDrawable(resources.getDrawable(R.drawable.contactus_rectangle_left))
                apntFragmentBinding?.btnOld?.setBackgroundDrawable(resources.getDrawable(R.drawable.white_right))
                apntFragmentBinding?.btnNew?.setTextColor(Color.WHITE)
                apntFragmentBinding?.btnOld?.setTextColor(resources.getColor(R.color.colorAccent))
                apntFragmentBinding?.tvUpcomingApnt?.textAlignment = View.TEXT_ALIGNMENT_CENTER
                apntFragmentBinding?.tvUpcomingApnt?.text = "4 Upcoming Appointments"
                apntFragmentBinding?.tvDay?.visibility = View.VISIBLE
                apntFragmentBinding?.tvDate?.visibility = View.VISIBLE
                apntFragmentBinding?.viewPager?.setCurrentItem(0)
            }
            R.id.btnOld -> {
                apntFragmentBinding?.btnNew?.setBackgroundDrawable(resources.getDrawable(R.drawable.white_left))
                apntFragmentBinding?.btnOld?.setBackgroundDrawable(resources.getDrawable(R.drawable.contactus_rectangle_right))
                apntFragmentBinding?.btnNew?.setTextColor(resources.getColor(R.color.colorAccent))
                apntFragmentBinding?.btnOld?.setTextColor(Color.WHITE)
                apntFragmentBinding?.tvUpcomingApnt?.textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                apntFragmentBinding?.tvUpcomingApnt?.text = "1280 Appointments Done"
                apntFragmentBinding?.tvDay?.visibility = View.GONE
                apntFragmentBinding?.tvDate?.visibility = View.GONE
                apntFragmentBinding?.viewPager?.setCurrentItem(1)
            }

            R.id.btnAddAppointment -> {
               DoctorsActivity.doctorsActivity?.replaceFragment( AddPatientsAppointmentFragment.newInstance())
            }
            R.id.linearLayout -> {
               DoctorsActivity.doctorsActivity?.replaceFragment( RequestAppointmentFragment.newInstance())
            }
        }
    }
    private inner class PagerAdapter(fm: FragmentManager, internal var mNumOfTabs: Int) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment? {

            when (position) {
                0 ->

                    return NewAppointmentFragment.newInstance()

                1 ->

                    return OldAppointmentFragment.newInstance()

                else -> return null
            }
        }

        override fun getCount(): Int {
            return mNumOfTabs
        }
    }
}
