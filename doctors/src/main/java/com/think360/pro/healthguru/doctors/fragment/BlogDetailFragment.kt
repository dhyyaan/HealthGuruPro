package com.think360.pro.healthguru.doctors.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.activities.DoctorsActivity
import com.think360.pro.healthguru.doctors.adapter.BlogByUBindingAdapter
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.BlogItem

/**
 * Created by think360 on 07/09/17.
 */
class BlogDetailFragment : Fragment() {
    companion object {
        fun newInstance(): BlogDetailFragment {
            return BlogDetailFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.blog_detail_fragment, container, false)
        DoctorsActivity.doctorsActivity?.activityDoctorsBinding?.navigation?.visibility = View.GONE
     //   val   blogDetailFragmentBinding   = inflate(inflater, R.layout.blog_detail_fragment, container, false)
        val actionCallback = object : ActionCallback {
            override   fun onClick(item: Any) {
                val objItem = item as BlogItem?
                Log.d("Notification Detail",""+objItem?.itemId)
            }
        }

        val rvOther  = view.findViewById<RecyclerView>(R.id.rvHisDetail)
        val mBlogList = ArrayList<BlogItem>()
        mBlogList.add(0, BlogItem(1,"Weight Loss","7 Reasons Why Proteins is neccessary","Dr.Sumanpreet Kaur","Dietitics/Nutrition",35,R.drawable.blog_small_1))
        mBlogList.add(1, BlogItem(2,"Hair Fall","7 Reasons Why Proteins is neccessary","Dr.Sumanpreet Kaur","Homeopath",37,R.drawable.blog_small_2))
        mBlogList.add(2, BlogItem(3,"Weight Loss","7 Reasons Why Proteins is neccessary","Dr.Sumanpreet Kaur","Dietitics/Nutrition",40,R.drawable.blog_small_1))
        mBlogList.add(3, BlogItem(4,"Hair Fall","7 Reasons Why Proteins is neccessary","Dr.Sumanpreet Kaur","Ayurved",20,R.drawable.blog_small_2))
        mBlogList.add(4, BlogItem(5,"Weight Loss","7 Reasons Why Proteins is neccessary","Dr.Sumanpreet Kaur","Dietitics/Nutrition",40,R.drawable.blog_small_1))
        mBlogList.add(5, BlogItem(6,"Hair Fall","7 Reasons Why Proteins is neccessary","Dr.Sumanpreet Kaur","Ayurved",20,R.drawable.blog_small_2))

        val adapter = BlogByUBindingAdapter(actionCallback,mBlogList)
        rvOther?.adapter = adapter

        adapter.notifyDataSetChanged()
        return view
    }
}