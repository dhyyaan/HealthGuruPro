package com.think360.pro.healthguru.doctors.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.activities.DoctorsActivity
import com.think360.pro.healthguru.doctors.databinding.NotificationSettingFragmentBinding


/**
 * Created by think360 on 01/09/17.
 */
class NotificationSettingsFragment : Fragment() {
    companion object {
        fun newInstance(): NotificationSettingsFragment {
            return NotificationSettingsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val   notificationSettingFragmentBinding   = DataBindingUtil.inflate<NotificationSettingFragmentBinding>(inflater, R.layout.notification_setting_fragment, container, false)
        DoctorsActivity.doctorsActivity?.activityDoctorsBinding?.tvMainTitle?.setText(resources.getText(R.string.txt_title_notification))
        return notificationSettingFragmentBinding.root
    }
}