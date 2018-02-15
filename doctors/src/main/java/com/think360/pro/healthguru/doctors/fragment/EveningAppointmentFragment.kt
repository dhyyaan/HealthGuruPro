package com.think360.pro.healthguru.doctors.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.databinding.EveningFragmentBinding


/**
 * Created by think360 on 31/07/17.
 */
class EveningAppointmentFragment : Fragment() {
    companion object {
        fun newInstance(): EveningAppointmentFragment {
            return EveningAppointmentFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val   otpVerificationFragmentBinding   = DataBindingUtil.inflate<EveningFragmentBinding>(inflater, R.layout.evening_fragment, container, false)
        return otpVerificationFragmentBinding.root
    }
}
