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
import com.think360.pro.healthguru.doctors.databinding.BlogFragmentBinding


/**
 * Created by think360 on 04/08/17.
 */
class BlogFragment : Fragment() {
    var   blogFragmentBinding : BlogFragmentBinding? = null
    companion object {
        fun newInstance(): BlogFragment {
            return BlogFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        blogFragmentBinding = DataBindingUtil.inflate<BlogFragmentBinding>(inflater, R.layout.blog_fragment, container, false)

        blogFragmentBinding?.viewPager?.setAdapter(PagerAdapter(childFragmentManager, 2))
        blogFragmentBinding?.viewPager?.setCurrentItem(0)
        blogFragmentBinding?.tvBtnByU?.setOnClickListener (mOnClickListener)
        blogFragmentBinding?.tvBtnOthers?.setOnClickListener (mOnClickListener)


        return blogFragmentBinding?.root
    }

    private val mOnClickListener = View.OnClickListener  { item ->
        when (item.id) {
            R.id.tvBtnByU -> {
                blogFragmentBinding?.tvBtnByU?.setBackgroundDrawable(resources.getDrawable(R.drawable.contactus_rectangle_left))
                blogFragmentBinding?.tvBtnOthers?.setBackgroundDrawable(resources.getDrawable(R.drawable.white_right))
                blogFragmentBinding?.tvBtnByU?.setTextColor(Color.WHITE)
                blogFragmentBinding?.tvBtnOthers?.setTextColor(resources.getColor(R.color.colorAccent))
                blogFragmentBinding?.viewPager?.setCurrentItem(0)
            }
            R.id.tvBtnOthers -> {
                blogFragmentBinding?.tvBtnByU?.setBackgroundDrawable(resources.getDrawable(R.drawable.white_left))
                blogFragmentBinding?.tvBtnOthers?.setBackgroundDrawable(resources.getDrawable(R.drawable.contactus_rectangle_right))
                blogFragmentBinding?.tvBtnByU?.setTextColor(resources.getColor(R.color.colorAccent))
                blogFragmentBinding?.tvBtnOthers?.setTextColor(Color.WHITE)
                blogFragmentBinding?.viewPager?.setCurrentItem(1)
            }


        }
    }
    private inner class PagerAdapter(fm: FragmentManager, internal var mNumOfTabs: Int) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment? {

            when (position) {
                0 ->

                    return BlogChildByUFragment.newInstance()

                1 ->

                    return BlogChildOthersFragment.newInstance()

                else -> return null
            }
        }

        override fun getCount(): Int {
            return mNumOfTabs
        }
    }
}