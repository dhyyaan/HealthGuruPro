package com.think360.pro.healthguru.registration.fragments

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.think360.pro.healthguru.registration.R
import com.think360.pro.healthguru.registration.databinding.OtpVerificationFragmentBinding

/**
 * Created by think360 on 25/07/17.
 */


class QRCodeScanFragment : Fragment() {
    companion object {
        fun newInstance(): OtpVerificationFragment {
            return OtpVerificationFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val   otpVerificationFragmentBinding   = DataBindingUtil.inflate<OtpVerificationFragmentBinding>(inflater, R.layout.otp_verification_fragment, container, false)
        return otpVerificationFragmentBinding.root
    }


}