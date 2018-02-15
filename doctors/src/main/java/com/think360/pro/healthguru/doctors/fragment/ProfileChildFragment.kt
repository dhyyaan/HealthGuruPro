package com.think360.pro.healthguru.doctors.fragment

import android.databinding.DataBindingUtil
import android.graphics.Bitmap
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.activities.DoctorsActivity
import com.think360.pro.healthguru.doctors.databinding.EveningFragmentBinding
import com.think360.pro.healthguru.doctors.databinding.ProfileChildFragmentBinding
import com.vansuita.pickimage.bundle.PickSetup
import com.vansuita.pickimage.dialog.PickImageDialog
import com.vansuita.pickimage.bean.PickResult
import com.vansuita.pickimage.listeners.IPickResult
import android.widget.LinearLayout
import android.support.v4.widget.SearchViewCompat.setMaxWidth
import android.view.ViewGroup.LayoutParams.FILL_PARENT
import android.widget.RelativeLayout
import com.think360.pro.healthguru.doctors.utils.ZoomInOutImageView


/**
 * Created by think360 on 09/08/17.
 */
class ProfileChildFragment : Fragment() {
    var   profileChildFragmentBinding : ProfileChildFragmentBinding? = null

    companion object {
        fun newInstance(): ProfileChildFragment {
            return ProfileChildFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        profileChildFragmentBinding   = DataBindingUtil.inflate<ProfileChildFragmentBinding>(inflater, R.layout.profile_child_fragment, container, false)

        profileChildFragmentBinding!!.buttonAddApnt.setOnClickListener {



            PickImageDialog.build { r ->
                Log.e("RESULT", r.path)
                if (r.error == null) {

                 //   r.bitmap
                  //  r.error



                   // lp.width = 95
                   // lp.height = 70

                    val layoutParams = LinearLayout.LayoutParams(150, 200)
                    layoutParams.setMargins(0,0,6,0)

                    val image  = ImageView(DoctorsActivity.doctorsActivity)

                    image.setImageBitmap(Bitmap.createScaledBitmap(r.bitmap, 150, 200, true))
                    image.setLayoutParams(layoutParams)
                    image.scaleType = ImageView.ScaleType.CENTER_CROP

                    profileChildFragmentBinding!!.llAppPics.addView(image)
                  /*  image.setOnClickListener {
                        v -> profileChildFragmentBinding!!.llAppPics.removeView(v)

                    }*/
                  //  imagePath = r.uri
                    //If you want the Uri.
                    //Mandatory to refresh image from Uri.
                    //getImageView().setImageURI(null);

                    //Setting the real returned image.
                    //getImageView().setImageURI(r.getUri());

                    Log.e("RESULT", r.path)
                    //If you want the Bitmap.
                 //   editProfileBinding.ivUser.setImageBitmap(r.bitmap)


                } else {
                    //Handle possible errors
                    Toast.makeText(activity, r.error.message, Toast.LENGTH_LONG).show()
                }
            }.show(fragmentManager)
        }


        return profileChildFragmentBinding!!.root
    }
}