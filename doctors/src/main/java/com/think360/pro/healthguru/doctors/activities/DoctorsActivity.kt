package com.think360.pro.healthguru.doctors.activities

import android.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.think360.pro.healthguru.doctors.databinding.ActivityDoctorsBinding
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.internal.BottomNavigationItemView
import android.util.Log
import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.fragment.*
import android.graphics.Bitmap
import android.content.Intent
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.format.DateFormat
import android.text.style.ForegroundColorSpan
import android.view.WindowManager
import android.widget.Toast
import com.vansuita.pickimage.bean.PickResult
import com.vansuita.pickimage.listeners.IPickResult
import java.text.SimpleDateFormat
import java.util.*


class DoctorsActivity : AppCompatActivity()  {


    var activityDoctorsBinding : ActivityDoctorsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDoctorsBinding  =  DataBindingUtil.setContentView<ActivityDoctorsBinding>(this, R.layout.activity_doctors)
        doctorsActivity = this

        activityDoctorsBinding?.badge?.setNumber(6)
        activityDoctorsBinding?.navigation?.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        activityDoctorsBinding?.badge?.setOnClickListener (mOnClickListener)

        activityDoctorsBinding?.ivBack?.visibility = View.GONE



        activityDoctorsBinding?. viewPager!!.setCurrentItem(0)

        disableShiftMode(activityDoctorsBinding!!.navigation)
        activityDoctorsBinding?. viewPager!!.setAdapter(PagerAdapter(supportFragmentManager, getFragmentArrrayList()))
        activityDoctorsBinding?. viewPager!!.setOffscreenPageLimit(5)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
                R.id.navigation_home -> {
                    activityDoctorsBinding?.ivBack?.visibility = View.GONE
                    activityDoctorsBinding?. viewPager!!.setCurrentItem(0)
                    DoctorsActivity.doctorsActivity?.activityDoctorsBinding?.tvMainTitle?.text = resources.getString(R.string.text_home)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_patients -> {
                    activityDoctorsBinding?.ivBack?.visibility = View.GONE
                    activityDoctorsBinding?. viewPager!!.setCurrentItem(1)
                    DoctorsActivity.doctorsActivity?.activityDoctorsBinding?.tvMainTitle?.text = resources.getString(R.string.nav_title_patients)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_appointments -> {
                    activityDoctorsBinding?.ivBack?.visibility = View.GONE
                    activityDoctorsBinding?. viewPager!!.setCurrentItem(2)
                    DoctorsActivity.doctorsActivity?.activityDoctorsBinding?.tvMainTitle?.text = resources.getString(R.string.nav_title_appointments)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_blog -> {
                    activityDoctorsBinding?.ivBack?.visibility = View.GONE
                    activityDoctorsBinding?. viewPager!!.setCurrentItem(3)
                    DoctorsActivity.doctorsActivity?.activityDoctorsBinding?.tvMainTitle?.text = resources.getString(R.string.nav_title_blog)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_profile -> {
                    activityDoctorsBinding?.ivBack?.visibility = View.GONE
                    activityDoctorsBinding?. viewPager!!.setCurrentItem(4)
                    DoctorsActivity.doctorsActivity?.activityDoctorsBinding?.tvMainTitle?.text = resources.getString(R.string.txt_title_settings)
                    return@OnNavigationItemSelectedListener true
                }
            }

        false
    }

    private val mOnClickListener = View.OnClickListener  { item ->
        when (item.id) {
            R.id.badge -> {
                activityDoctorsBinding?.ivBack?.visibility = View.VISIBLE
                replaceFragment( NotificationFragment.newInstance())
            }
        }
    }

   private inner class PagerAdapter(fm: FragmentManager, fragmentSparseArray: ArrayList<Fragment>) : FragmentPagerAdapter(fm) {

        private var fragmentSparseArray = ArrayList<Fragment>()

        init {
            this.fragmentSparseArray = fragmentSparseArray
        }

        override fun getItem(position: Int): Fragment {
            return fragmentSparseArray[position]
        }

        override fun getCount(): Int {
            return fragmentSparseArray.size
        }
    }

    fun disableShiftMode(view: BottomNavigationView) {
        val menuView = view.getChildAt(0) as BottomNavigationMenuView
        try {
            val shiftingMode = menuView.javaClass.getDeclaredField("mShiftingMode")
            shiftingMode.isAccessible = true
            shiftingMode.setBoolean(menuView, false)
            shiftingMode.isAccessible = false
            for (i in 0..menuView.childCount - 1) {
                val item = menuView.getChildAt(i) as BottomNavigationItemView

                item.setShiftingMode(false)
                // set once again checked value, so view will be updated

                item.setChecked(item.itemData.isChecked)
            }
        } catch (e: NoSuchFieldException) {
            Log.e("BNVHelper", "Unable to get shift mode field", e)
        } catch (e: IllegalAccessException) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e)
        }

    }

    private fun getFragmentArrrayList(): ArrayList<Fragment> {
        val fragmentSparseArray = ArrayList<Fragment>()
        fragmentSparseArray.add(HomeFragment())
        fragmentSparseArray.add(PatientsFragment.newInstance())
        fragmentSparseArray.add(AppointmentsFragment.newInstance())
        fragmentSparseArray.add(BlogFragment.newInstance())
        fragmentSparseArray.add(ProfileSettingsFragment.newInstance())
        return fragmentSparseArray

    }
    fun replaceFragment(fragment : Fragment) {
        val transaction = supportFragmentManager.beginTransaction()

        transaction.setCustomAnimations(R.anim.enter_from_right,
                R.anim.exit_to_left,R.anim.enter_from_left,R.anim.exit_to_right)

              transaction.addToBackStack(fragment.javaClass.simpleName)
            transaction.replace(R.id.fragContainer, fragment).commit()


    }
    companion object {
        var doctorsActivity : DoctorsActivity? = null
    }
    override fun onBackPressed() {
        activityDoctorsBinding?.navigation?.visibility =  View.VISIBLE

        if (fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStack()
        } else {
            super.onBackPressed()

        }
    }


}
