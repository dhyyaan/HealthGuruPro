package com.think360.pro.healthguru.doctors.fragment

import android.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.activities.DoctorsActivity
import com.think360.pro.healthguru.doctors.databinding.ProcedureListFragmentBinding



/**
 * Created by think360 on 10/08/17.
 */
class ProcedureListFragment  : Fragment() {
    var procedureListFragmentBinding : ProcedureListFragmentBinding? = null
    var setTabSel : Int? = 0
    companion object {
        fun newInstance(  i : Int): ProcedureListFragment {
            val procedureListFragment : ProcedureListFragment = ProcedureListFragment()
            val bundle : Bundle  = Bundle()
            bundle?.putInt("setTabSel",i)
            procedureListFragment.arguments = bundle
            return procedureListFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(arguments != null){
            setTabSel = arguments.getInt("setTabSel")
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        procedureListFragmentBinding = DataBindingUtil.inflate<ProcedureListFragmentBinding>(inflater, R.layout.procedure_list_fragment, container, false)
      DoctorsActivity.doctorsActivity?.activityDoctorsBinding?.navigation?.visibility = View.GONE
        procedureListFragmentBinding?.viewPager?.setAdapter(PagerAdapter(childFragmentManager, 2))
        procedureListFragmentBinding?.viewPager?.setCurrentItem(setTabSel!!)
        buttonSet(setTabSel!!)
        procedureListFragmentBinding?.txtBtnProcedureList?.setOnClickListener (mOnClickListener)
        procedureListFragmentBinding?.txtBtnProcedurePackages?.setOnClickListener (mOnClickListener)

        return procedureListFragmentBinding?.root
    }

    private val mOnClickListener = View.OnClickListener  { item ->
        when (item.id) {
            R.id.txtBtnProcedureList -> {
                buttonSet(0)
            }
            R.id.txtBtnProcedurePackages -> {
                buttonSet(1)
            }


        }
    }
private inner class PagerAdapter(fm: FragmentManager, internal var mNumOfTabs: Int) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {

        when (position) {
            0 ->

                return ProcedureListChildFragment.newInstance()

            1 ->

                return   ProcedurePackagesFragment.newInstance()

            else -> return null
        }
    }

    override fun getCount(): Int {
        return mNumOfTabs
    }
}
    fun buttonSet(i : Int){
        when(i){
            0 -> {
                procedureListFragmentBinding?.txtBtnProcedureList?.setBackgroundDrawable(resources.getDrawable(R.drawable.contactus_rectangle_left))
                procedureListFragmentBinding?.txtBtnProcedurePackages?.setBackgroundDrawable(resources.getDrawable(R.drawable.white_right))
                procedureListFragmentBinding?.txtBtnProcedureList?.setTextColor(Color.WHITE)
                procedureListFragmentBinding?.txtBtnProcedurePackages?.setTextColor(resources.getColor(R.color.colorAccent))
                procedureListFragmentBinding?.viewPager?.setCurrentItem(0)
            }
           1->{
               procedureListFragmentBinding?.txtBtnProcedureList?.setBackgroundDrawable(resources.getDrawable(R.drawable.white_left))
               procedureListFragmentBinding?.txtBtnProcedurePackages?.setBackgroundDrawable(resources.getDrawable(R.drawable.contactus_rectangle_right))
               procedureListFragmentBinding?.txtBtnProcedureList?.setTextColor(resources.getColor(R.color.colorAccent))
               procedureListFragmentBinding?.txtBtnProcedurePackages?.setTextColor(Color.WHITE)
               procedureListFragmentBinding?.viewPager?.setCurrentItem(1)
           }

        }

    }

}