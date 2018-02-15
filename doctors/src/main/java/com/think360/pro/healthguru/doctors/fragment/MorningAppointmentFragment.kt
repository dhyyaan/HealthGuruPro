package com.think360.pro.healthguru.doctors.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.databinding.MorningFragmentBinding

/**
 * Created by think360 on 31/07/17.
 */
class MorningAppointmentFragment  : Fragment() {
    companion object {
        fun newInstance(): MorningAppointmentFragment {
            return MorningAppointmentFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val   otpVerificationFragmentBinding   = DataBindingUtil.inflate<MorningFragmentBinding>(inflater, R.layout.morning_fragment, container, false)
        return otpVerificationFragmentBinding.root
    }


}
