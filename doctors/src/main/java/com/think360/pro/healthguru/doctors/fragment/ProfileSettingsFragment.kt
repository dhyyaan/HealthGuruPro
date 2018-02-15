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
import android.widget.LinearLayout
import android.widget.Toast
import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.activities.DoctorsActivity
import com.think360.pro.healthguru.doctors.adapter.ProfileBindingAdapter
import com.think360.pro.healthguru.doctors.databinding.ProfileSettingsFragmentBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.interfaces.ClickListener
import com.think360.pro.healthguru.doctors.model.PatientsItem
import com.think360.pro.healthguru.doctors.model.ProfileItem
import com.think360.pro.healthguru.doctors.utils.RecyclerTouchListener
import com.vansuita.pickimage.dialog.PickImageDialog


/**
 * Created by think360 on 09/08/17.
 */
class ProfileSettingsFragment : Fragment() {
    companion object {
        fun newInstance(): ProfileSettingsFragment {
            return ProfileSettingsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val   profileSetFragmentBinding   = DataBindingUtil.inflate<ProfileSettingsFragmentBinding>(inflater, R.layout.profile_settings_fragment, container, false)

       // DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.navigation?.visibility =  View.GONE
        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.tvMainTitle?.text = resources.getString(R.string.txt_title_settings)


        val actionCallback = object : ActionCallback {
            override   fun onClick(item: Any) {
                val objItem = item as PatientsItem?
                Log.d("Notification Detail",objItem?.name)

            }

        }
        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.ivBack?.setOnClickListener {
            DoctorsActivity?.doctorsActivity?.onBackPressed()
        }

        val mPackagesList = ArrayList<ProfileItem>()
        mPackagesList.add(0, ProfileItem(R.drawable.patient_profile,"Profile",true))
        mPackagesList.add(1, ProfileItem(R.drawable.procedure,"Procedure List",true))
        mPackagesList.add(2, ProfileItem(R.drawable.procedure,"Procedure Packages",true))
        mPackagesList.add(3, ProfileItem(R.drawable.bell,"Notifications",true))
        mPackagesList.add(4, ProfileItem(R.drawable.blue_like,"Feedback",true))
        mPackagesList.add(5, ProfileItem(R.drawable.app_rating,"Rate Us",true))

        val adapter = ProfileBindingAdapter(mPackagesList)
        profileSetFragmentBinding.rvProfile.adapter = adapter


        adapter.notifyDataSetChanged()
        profileSetFragmentBinding.rvProfile.addOnItemTouchListener( RecyclerTouchListener(activity, profileSetFragmentBinding.rvProfile,  ClickListener { view: View, i: Int ->
           when(i){
                  0 ->    DoctorsActivity.doctorsActivity?.replaceFragment( ProfileChildFragment.newInstance())
                  1,2 ->  DoctorsActivity.doctorsActivity?.replaceFragment( ProcedureListFragment.newInstance(i-1))
                  3 ->    DoctorsActivity.doctorsActivity?.replaceFragment( NotificationSettingsFragment.newInstance())
                  4 ->    DoctorsActivity.doctorsActivity?.replaceFragment( FeedbackFragment.newInstance())
           }

        }

        ))
        profileSetFragmentBinding.ivProfileImageEdit!!.setOnClickListener {



            PickImageDialog.build { r ->
                Log.e("RESULT", r.path)
                if (r.error == null) {

                    //   r.bitmap
                    //  r.error



                    // lp.width = 95
                    // lp.height = 70


                    profileSetFragmentBinding!!.cIvProfilePic.setImageURI(r.uri)
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
        return profileSetFragmentBinding.root
    }


}
