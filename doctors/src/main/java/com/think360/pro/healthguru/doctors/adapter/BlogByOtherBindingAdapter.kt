package com.think360.pro.healthguru.doctors.adapter

import android.support.v7.widget.LinearLayoutManager
import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.activities.DoctorsActivity
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundAdapter
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundViewHolder
import com.think360.pro.healthguru.doctors.databinding.BlogChildListItemBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.BlogItem
import com.think360.pro.healthguru.doctors.model.ProfileItem

/**
 * Created by think360 on 12/08/17.
 */
class BlogByOtherBindingAdapter : DataBoundAdapter<BlogChildListItemBinding> {


    var mBlogList = ArrayList<BlogItem>()

    var mActionCallback: ActionCallback?= null

    constructor(actionCallback : ActionCallback, mBlogList : ArrayList<BlogItem>) : super(R.layout.blog_child_list_item) {
        this. mBlogList = mBlogList
        this. mActionCallback = actionCallback
    }

    override fun bindItem(holder: DataBoundViewHolder<BlogChildListItemBinding>?, position: Int, payloads: MutableList<Any>?) {
        holder?.binding?.data = mBlogList.get(position)
        holder?.binding?.callback = mActionCallback

        val mPackagesList = ArrayList<ProfileItem>()
        mPackagesList.add(0, ProfileItem(R.drawable.doctor_profile,"Profile",true))
        mPackagesList.add(1, ProfileItem(R.drawable.procedure,"Procedure List",true))
        mPackagesList.add(2, ProfileItem(R.drawable.procedure,"Procedure Packages",true))
        mPackagesList.add(3, ProfileItem(R.drawable.bell,"Notifications",true))
        mPackagesList.add(4, ProfileItem(R.drawable.blue_like,"Feedback",true))
        mPackagesList.add(5, ProfileItem(R.drawable.app_rating,"Rate Us",true))



      //  val horizontalLayoutManagaer = LinearLayoutManager(DoctorsActivity.doctorsActivity, LinearLayoutManager.HORIZONTAL, false)

      //  val adapter = ProfileBindingAdapter(mPackagesList)
       // holder?.binding?.rvOther?.setLayoutManager(horizontalLayoutManagaer)
       // holder?.binding?.rvOther?.adapter = adapter
    }

    override fun getItemCount(): Int {
        return mBlogList.size
    }
}
