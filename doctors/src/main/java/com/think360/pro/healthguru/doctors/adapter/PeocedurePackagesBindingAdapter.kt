package com.think360.pro.healthguru.doctors.adapter

import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundAdapter
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundViewHolder
import com.think360.pro.healthguru.doctors.databinding.BlogChildListItemBinding
import com.think360.pro.healthguru.doctors.databinding.ProcedurePackagesListItemBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.BlogItem
import com.think360.pro.healthguru.doctors.model.ProcedurePackagesItem

/**
 * Created by think360 on 11/08/17.
 */
class PeocedurePackagesBindingAdapter : DataBoundAdapter<ProcedurePackagesListItemBinding> {


    var mBlogList = ArrayList<ProcedurePackagesItem>()

   // var mActionCallback: ActionCallback?= null
   // actionCallback : ActionCallback,
    constructor( mBlogList : ArrayList<ProcedurePackagesItem>) : super(R.layout.procedure_packages_list_item) {
        this. mBlogList = mBlogList
      //  this. mActionCallback = actionCallback
    }

    override fun bindItem(holder: DataBoundViewHolder<ProcedurePackagesListItemBinding>?, position: Int, payloads: MutableList<Any>?) {
       // holder?.binding?.data = mBlogList.get(position)
        //holder?.binding?.callback = mActionCallback
    }

    override fun getItemCount(): Int {
        return mBlogList.size
    }
}
