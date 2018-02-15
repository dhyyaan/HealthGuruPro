package com.think360.pro.healthguru.doctors.fragment

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.activities.BlogDetailActivity
import com.think360.pro.healthguru.doctors.activities.DoctorsActivity
import com.think360.pro.healthguru.doctors.adapter.BlogByUBindingAdapter
import com.think360.pro.healthguru.doctors.databinding.AddMoreTestSearchFragmentBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.BlogItem


/**
 * Created by think360 on 06/09/17.
 */
class BlogSearchFragment : Fragment() {
    companion object {
        fun newInstance(): BlogSearchFragment {
            return BlogSearchFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val   addMoreTestSearchFragmentBinding   = DataBindingUtil.inflate<AddMoreTestSearchFragmentBinding>(inflater, R.layout.add_more_test_search_fragment, container, false)
        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.rl?.visibility = View.GONE
        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.navigation?.visibility = View.GONE
        addMoreTestSearchFragmentBinding.btnDone.visibility = View.GONE
        addMoreTestSearchFragmentBinding.ivBack?.setOnClickListener {
            DoctorsActivity?.doctorsActivity?.onBackPressed()
        }
        val actionCallback = object : ActionCallback {
            override   fun onClick(item: Any) {
                val objItem = item as BlogItem?
                Log.d("Notification Detail",""+objItem?.itemId)
                val intent = Intent(DoctorsActivity.doctorsActivity, BlogDetailActivity::class.java)
                startActivity(intent)
            }

        }
      //  DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.tvMainTitle?.text = resources.getString(R.string.nav_title_blog)
        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.ivBack?.setOnClickListener {
          //  DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.navigation?.visibility = View.VISIBLE
          //  DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.rl?.visibility = View.VISIBLE
            DoctorsActivity?.doctorsActivity?.onBackPressed()
        }

        val mBlogList = ArrayList<BlogItem>()
        mBlogList.add(0, BlogItem(1,"Weight Loss","7 Reasons Why Proteins is neccessary","Dr.Sumanpreet Kaur","Dietitics/Nutrition",35,R.drawable.blog_small_1))
        mBlogList.add(1, BlogItem(2,"Hair Fall","7 Reasons Why Proteins is neccessary","Dr.Sumanpreet Kaur","Homeopath",37,R.drawable.blog_small_2))
        mBlogList.add(2, BlogItem(3,"Weight Loss","7 Reasons Why Proteins is neccessary","Dr.Sumanpreet Kaur","Dietitics/Nutrition",40,R.drawable.blog_small_1))
        mBlogList.add(3, BlogItem(4,"Hair Fall","7 Reasons Why Proteins is neccessary","Dr.Sumanpreet Kaur","Ayurved",20,R.drawable.blog_small_2))

        val adapter = BlogByUBindingAdapter(actionCallback,mBlogList)
        addMoreTestSearchFragmentBinding?.rvMoreTest?.adapter = adapter

        adapter.notifyDataSetChanged()
        return addMoreTestSearchFragmentBinding.root
    }
}