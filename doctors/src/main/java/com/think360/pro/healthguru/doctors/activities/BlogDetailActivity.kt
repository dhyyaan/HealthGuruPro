package com.think360.pro.healthguru.doctors.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.ImageView
import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.adapter.BlogByUBindingAdapter
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.BlogItem


class BlogDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      setContentView(R.layout.blog_detailt_activity)
    val back = findViewById(R.id.ivBack) as ImageView
       back.setOnClickListener { finish() }
        val actionCallback = object : ActionCallback {
            override   fun onClick(item: Any) {
                val objItem = item as BlogItem?
                Log.d("Notification Detail",""+objItem?.itemId)
            }
        }

        val rvOther  = findViewById(R.id.rvHisDetail) as RecyclerView
        val mBlogList = ArrayList<BlogItem>()
        mBlogList.add(0, BlogItem(1,"Weight Loss","7 Reasons Why Proteins is neccessary","Dr.Sumanpreet Kaur","Dietitics/Nutrition",35,R.drawable.blog_small_1))
        mBlogList.add(1, BlogItem(2,"Hair Fall","7 Reasons Why Proteins is neccessary","Dr.Sumanpreet Kaur","Homeopath",37,R.drawable.blog_small_2))
        mBlogList.add(2, BlogItem(3,"Weight Loss","7 Reasons Why Proteins is neccessary","Dr.Sumanpreet Kaur","Dietitics/Nutrition",40,R.drawable.blog_small_1))
        mBlogList.add(3, BlogItem(4,"Hair Fall","7 Reasons Why Proteins is neccessary","Dr.Sumanpreet Kaur","Ayurved",20,R.drawable.blog_small_2))
        mBlogList.add(4, BlogItem(5,"Weight Loss","7 Reasons Why Proteins is neccessary","Dr.Sumanpreet Kaur","Dietitics/Nutrition",40,R.drawable.blog_small_1))
        mBlogList.add(5, BlogItem(6,"Hair Fall","7 Reasons Why Proteins is neccessary","Dr.Sumanpreet Kaur","Ayurved",20,R.drawable.blog_small_2))

        val adapter = BlogByUBindingAdapter(actionCallback,mBlogList)
        rvOther.adapter = adapter
        /*   val linearLayoutManager = LinearLayoutManager(DoctorsActivity.doctorsActivity)

         val horizontalLayoutManagaer = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
           blogOtherFragmentBinding.rvOther.setLayoutManager(horizontalLayoutManagaer)


           blogOtherFragmentBinding.rvOther.setLayoutManager(linearLayoutManager)
           blogOtherFragmentBinding.rvOther.addOnScrollListener(object : EndlessRecyclerOnScrollListener(linearLayoutManager,blogOtherFragmentBinding) {
              override fun onLoadMore() {

               }
           })*/

        adapter.notifyDataSetChanged()
    }
}
