package com.think360.pro.healthguru.registration.activities

import android.databinding.DataBindingUtil
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.think360.pro.healthguru.registration.R
import com.think360.pro.healthguru.registration.databinding.ActivityRegistrationBinding

import com.think360.pro.healthguru.registration.fragments.OtpVerificationFragment


class RegistrationActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resActivity  = this
      val   actRegBinding  : ActivityRegistrationBinding =   DataBindingUtil.setContentView<ActivityRegistrationBinding>(this,R.layout.activity_registration)

actRegBinding.btnNext.setOnClickListener {


            replaceFragment(OtpVerificationFragment.newInstance())

    }
}


/*    private val mOnClickListener = View.OnClickListener  { item ->
        when (item.id) {
            R.id.btnNext -> {
                replaceFragment(OtpVerificationFragment.newInstance())
            }
        }
    }*/
    fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.addToBackStack(fragment.javaClass.simpleName)
        transaction.add(R.id.fragContainer, fragment).commit()
    }

    override fun onBackPressed() {
        if (fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
//   ft.setCustomAnimations(R.anim.fragment_slide_in_left, R.anim.fragment_slide_out_left, R.anim.fragment_slide_in_right, R.anim.fragment_slide_out_right);
companion object {
      var resActivity : RegistrationActivity? =null
}
}
