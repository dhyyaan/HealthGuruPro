package com.think360.pro.healthguru.doctors.adapte
import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundAdapter
import com.think360.pro.healthguru.doctors.adapter.recyclerbindingadapter.DataBoundViewHolder
import com.think360.pro.healthguru.doctors.databinding.NotificationListItemBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.NotificationItem
import java.util.ArrayList

/**
 * Created by think360 on 22/08/17.
 */
class NotificationBindingAdapter : DataBoundAdapter<NotificationListItemBinding> {


    var mPatientsList = ArrayList<NotificationItem>()

    var mActionCallback: ActionCallback?= null

    constructor(actionCallback : ActionCallback, mPatientsList : ArrayList<NotificationItem>) : super(R.layout.notification_list_item) {
        this. mPatientsList = mPatientsList
        this. mActionCallback = actionCallback
    }

    override fun bindItem(holder: DataBoundViewHolder<NotificationListItemBinding>?, position: Int, payloads: MutableList<Any>?) {
        holder?.binding?.data = mPatientsList.get(position) as NotificationItem?
        holder?.binding?.callback = mActionCallback
    }

    override fun getItemCount(): Int {
        return mPatientsList.size
    }
}


