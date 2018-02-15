package com.think360.pro.healthguru.chemists.fragments

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.think360.pro.healthguru.chemists.R
import com.think360.pro.healthguru.chemists.databinding.ProfileFragmentBinding


/**
 * Created by think360 on 25/07/17.
 */
class ProfileFragment : Fragment() {
    companion object {
        fun newInstance(): ProfileFragment {
            return ProfileFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val   otpVerificationFragmentBinding   = DataBindingUtil.inflate<ProfileFragmentBinding>(inflater, R.layout.profile_fragment, container, false)
        return otpVerificationFragmentBinding.root
    }
}
