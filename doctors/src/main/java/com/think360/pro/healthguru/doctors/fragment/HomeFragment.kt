package com.think360.pro.healthguru.doctors.fragment

import android.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.activities.DoctorsActivity
import com.think360.pro.healthguru.doctors.databinding.HomeFragmentBinding
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by think360 on 25/09/17.
 */
class HomeFragment : Fragment() {
    var homeFragmentBinding : HomeFragmentBinding? = null
    var c : Calendar?  = null
    var df : SimpleDateFormat? = null
    var c1 : Calendar?  = null
    var c2 : Calendar?  = null
    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

          homeFragmentBinding   = DataBindingUtil.inflate<HomeFragmentBinding>(inflater, R.layout.home_fragment, container, false)

        c  = Calendar.getInstance()
        df  = SimpleDateFormat("dd-MMM-yyyy")
        c1  = Calendar.getInstance()
        c2  = Calendar.getInstance()
        c2?.add(Calendar.DATE, 15)
        homeFragmentBinding?.ivDateLeft?.visibility = View.GONE

        homeFragmentBinding?.tvDate?.setText(df?.format(c?.getTime()))



        homeFragmentBinding?.viewPager?.setAdapter(PagerAdapter(childFragmentManager, 2))
        homeFragmentBinding?.viewPager?.setCurrentItem(0)



        homeFragmentBinding?.buttonMorning?.setOnClickListener (mOnClickListener)
        homeFragmentBinding?.buttonEvening?.setOnClickListener (mOnClickListener)

        homeFragmentBinding?.btnAddPatient?.setOnClickListener (mOnClickListener)
        homeFragmentBinding?.btnAddAppointment?.setOnClickListener (mOnClickListener)
        homeFragmentBinding?.btnAddAppointment?.setOnClickListener (mOnClickListener)
        homeFragmentBinding?.llAplPending?.setOnClickListener (mOnClickListener)
        homeFragmentBinding?.llLabNearByU?.setOnClickListener (mOnClickListener)

        homeFragmentBinding?.ivDateLeft?.setOnClickListener (mOnClickListener)
        homeFragmentBinding?.ivDateRight?.setOnClickListener (mOnClickListener)
        return homeFragmentBinding!!.root
    }
    private val mOnClickListener = View.OnClickListener  { item ->
        when (item.id) {
            R.id.llAplPending -> {
              DoctorsActivity.doctorsActivity!!.activityDoctorsBinding!!.ivBack?.visibility = View.VISIBLE
                DoctorsActivity.doctorsActivity!!.  replaceFragment( RequestAppointmentFragment.newInstance())
            }
            R.id.buttonMorning -> {
                homeFragmentBinding?.buttonMorning?.setBackgroundDrawable(resources.getDrawable(R.drawable.contactus_rectangle_left))
                homeFragmentBinding?.buttonEvening?.setBackgroundDrawable(resources.getDrawable(R.drawable.white_right))
                homeFragmentBinding?.buttonMorning?.setTextColor(Color.WHITE)
                homeFragmentBinding?.buttonEvening?.setTextColor(resources.getColor(R.color.colorAccent))
                homeFragmentBinding?.viewPager?.setCurrentItem(0)
            }
            R.id.buttonEvening -> {
                homeFragmentBinding?.buttonMorning?.setBackgroundDrawable(resources.getDrawable(R.drawable.white_left))
                homeFragmentBinding?.buttonEvening?.setBackgroundDrawable(resources.getDrawable(R.drawable.contactus_rectangle_right))
                homeFragmentBinding?.buttonMorning?.setTextColor(resources.getColor(R.color.colorAccent))
                homeFragmentBinding?.buttonEvening?.setTextColor(Color.WHITE)
                homeFragmentBinding?.viewPager?.setCurrentItem(1)
            }
            R.id.btnAddPatient -> {
                DoctorsActivity.doctorsActivity!!.activityDoctorsBinding!!.ivBack?.visibility = View.VISIBLE
               DoctorsActivity.doctorsActivity!!. replaceFragment( AddPatientsAppointmentFragment.newInstance())
            }
            R.id.btnAddAppointment -> {
                DoctorsActivity.doctorsActivity!!.activityDoctorsBinding!!.ivBack?.visibility = View.VISIBLE
                DoctorsActivity.doctorsActivity!!. replaceFragment( AddPatientsAppointmentFragment.newInstance())
            }
            R.id.llLabNearByU -> {
                DoctorsActivity.doctorsActivity!!.activityDoctorsBinding!!.ivBack?.visibility = View.VISIBLE
                DoctorsActivity.doctorsActivity!!. replaceFragment( LabNearByUFragment.newInstance())
            }
            R.id.badge -> {
                DoctorsActivity.doctorsActivity!!.activityDoctorsBinding!!.ivBack?.visibility = View.VISIBLE
                DoctorsActivity.doctorsActivity!!. replaceFragment( NotificationFragment.newInstance())
            }
            R.id.ivDateLeft -> {
                homeFragmentBinding?.ivDateRight?.visibility = View.VISIBLE
                getDate(-1)
            }
            R.id.ivDateRight -> {
                homeFragmentBinding?.ivDateLeft?.visibility = View.VISIBLE
                var date15Date : String = df!!.format(c2?.getTime())
                if(!date15Date.equals(homeFragmentBinding?.tvDate?.text)) {
                    getDate(1)
                }else{
                    homeFragmentBinding?.ivDateRight?.visibility = View.GONE
                }

            }
        }
    }

    private inner class PagerAdapter(fm: FragmentManager, internal var mNumOfTabs: Int) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment? {

            when (position) {
                0 ->

                    return MorningAppointmentFragment.newInstance()

                1 ->

                    return EveningAppointmentFragment.newInstance()

                else -> return null
            }
        }

        override fun getCount(): Int {
            return mNumOfTabs
        }
    }
    fun getDate( i : Int){
        c?.add(Calendar.DATE, i)
        homeFragmentBinding?.tvDate?.setText(df?.format(c?.getTime()))
        val dayOfTheWeek = DateFormat.format("EEEE",  Date(df?.format(c?.getTime()))) as String
        homeFragmentBinding?.tvDay?.setText(dayOfTheWeek)
        var currentDate : String = df!!.format(c1?.getTime())
        if(currentDate.equals(homeFragmentBinding?.tvDate?.text)) {
            homeFragmentBinding?.tvDay?.setText("Today")
            homeFragmentBinding?.ivDateLeft?.visibility = View.GONE

        }
        var date15Date : String = df!!.format(c2?.getTime())
        if(date15Date.equals(homeFragmentBinding?.tvDate?.text)) {
            homeFragmentBinding?.ivDateRight?.visibility = View.GONE

        }

    }

}