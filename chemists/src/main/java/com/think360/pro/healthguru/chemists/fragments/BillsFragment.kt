package com.think360.pro.healthguru.chemists.fragments

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.think360.pro.healthguru.chemists.R
import com.think360.pro.healthguru.chemists.databinding.BillsFragmentBinding


/**
 * Created by think360 on 25/07/17.
 */
class BillsFragment : Fragment() {
    companion object {
        fun newInstance(): BillsFragment {
            return BillsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val   otpVerificationFragmentBinding   = DataBindingUtil.inflate<BillsFragmentBinding>(inflater, R.layout.bills_fragment, container, false)
        return otpVerificationFragmentBinding.root
    }


}
