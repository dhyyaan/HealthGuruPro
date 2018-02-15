package com.think360.pro.healthguru.doctors.fragment

import android.content.Intent
import android.databinding.DataBindingUtil.*
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
import com.think360.pro.healthguru.doctors.databinding.BlogChildByUFragmentBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.BlogItem

/**
 * Created by think360 on 04/08/17.
 */
class BlogChildByUFragment : Fragment() {
    companion object {
        fun newInstance(): BlogChildByUFragment {
            return BlogChildByUFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val   blogByUFragmentBinding   = inflate<BlogChildByUFragmentBinding>(inflater, R.layout.blog_child_by_u_fragment, container, false)

        val actionCallback = object : ActionCallback {
            override   fun onClick(item: Any) {
                val objItem = item as BlogItem?
               // Log.d("Notification Detail",""+objItem?.itemId)
               val intent = Intent(DoctorsActivity.doctorsActivity, BlogDetailActivity::class.java)
               startActivity(intent)
               // DoctorsActivity.doctorsActivity?.replaceFragment(BlogDetailFragment.newInstance())
            }

        }
        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.ivBack?.setOnClickListener {
            DoctorsActivity?.doctorsActivity?.onBackPressed()
        }
        val mBlogList = ArrayList<BlogItem>()
        mBlogList.add(0, BlogItem(1,"Weight Loss","7 Reasons Why Proteins is neccessary","Dr.Sumanpreet Kaur","Dietitics/Nutrition",35,R.drawable.blog_small_1))
        mBlogList.add(1, BlogItem(2,"Hair Fall","7 Reasons Why Proteins is neccessary","Dr.Sumanpreet Kaur","Homeopath",37,R.drawable.blog_small_2))
        mBlogList.add(2, BlogItem(3,"Weight Loss","7 Reasons Why Proteins is neccessary","Dr.Sumanpreet Kaur","Dietitics/Nutrition",40,R.drawable.blog_small_1))
        mBlogList.add(3, BlogItem(4,"Hair Fall","7 Reasons Why Proteins is neccessary","Dr.Sumanpreet Kaur","Ayurved",20,R.drawable.blog_small_2))

        val adapter = BlogByUBindingAdapter(actionCallback,mBlogList)
        blogByUFragmentBinding.rvBlogByU.adapter = adapter
        adapter.notifyDataSetChanged()

        return blogByUFragmentBinding.root
    }
}