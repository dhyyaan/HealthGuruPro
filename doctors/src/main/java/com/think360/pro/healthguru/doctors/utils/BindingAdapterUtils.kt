package com.think360.pro.healthguru.doctors.utils


import android.databinding.BindingAdapter
import android.widget.ImageView
import com.think360.pro.healthguru.doctors.R


/**
 * Created by think360 on 09/08/17.
 */
class BindingAdapterUtils {
    companion object {
        @BindingAdapter("app:imageUrlssss")
        fun loadImage(view: ImageView, url: Int) {
            view.setImageResource(R.drawable.user_1)
        }
    }
}