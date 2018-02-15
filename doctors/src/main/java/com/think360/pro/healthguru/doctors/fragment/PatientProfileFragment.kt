package com.think360.pro.healthguru.doctors.fragment

import android.app.Dialog
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.*
import android.widget.ImageView
import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.activities.DoctorsActivity
import com.think360.pro.healthguru.doctors.adapter.PatientProfileAdapter
import com.think360.pro.healthguru.doctors.databinding.PatientDetailFragmentBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.interfaces.ClickListener
import com.think360.pro.healthguru.doctors.model.PatientProfileItem
import com.think360.pro.healthguru.doctors.model.PatientsItem
import com.think360.pro.healthguru.doctors.utils.RecyclerTouchListener
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.widget.TextView
import android.widget.Toast
import com.vansuita.pickimage.dialog.PickImageDialog
import android.graphics.drawable.BitmapDrawable
import android.widget.RelativeLayout


/**
 * Created by think360 on 23/08/17.
 */
class PatientProfileFragment : Fragment() {
    companion object {
        fun newInstance(): PatientProfileFragment {
            return PatientProfileFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val   patientDetailFragmentBinding   = DataBindingUtil.inflate<PatientDetailFragmentBinding>(inflater, R.layout.patient_detail_fragment, container, false)

        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.navigation?.visibility =  View.GONE
        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.tvMainTitle?.text = resources.getString(R.string.txt_title_patient)
        patientDetailFragmentBinding.imageView.setOnClickListener { showDailog(false, (patientDetailFragmentBinding.imageView.getDrawable() as BitmapDrawable).bitmap ) }

        val actionCallback = object : ActionCallback {
            override   fun onClick(item: Any) {
                val objItem = item as PatientsItem?
                Log.d("Notification Detail",objItem?.name)

            }

        }
        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.ivBack?.setOnClickListener {
            DoctorsActivity?.doctorsActivity?.onBackPressed()
        }
        patientDetailFragmentBinding.btnAddTest.setOnClickListener { DoctorsActivity?.doctorsActivity?.replaceFragment(AddTestFragment.newInstance()) }


        patientDetailFragmentBinding.btnAddPrescription.setOnClickListener {
            PickImageDialog.build { r ->
                Log.e("RESULT", r.path)
                if (r.error == null) {

                    //   r.bitmap
                    //  r.error



                    // lp.width = 95
                    // lp.height = 70


                    showDailog(true,r.bitmap)
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



        val mPackagesList = ArrayList<PatientProfileItem>()
        mPackagesList.add(0, PatientProfileItem(R.drawable.scan_qr,"0",false,"Scan QR Code","OK",true))
        mPackagesList.add(1, PatientProfileItem(R.drawable.patient_profile,"0",false,"Patient Profile","OK",false))
        mPackagesList.add(2, PatientProfileItem(R.drawable.appointment_history,"0",false,"Appointment History","OK",false))
        mPackagesList.add(3, PatientProfileItem(R.drawable.advice_test,"3",true,"Advice Test","OK",false))


        val adapter = PatientProfileAdapter(actionCallback,mPackagesList)
        patientDetailFragmentBinding.rvProfile.adapter = adapter


        adapter.notifyDataSetChanged()
        patientDetailFragmentBinding.rvProfile.addOnItemTouchListener( RecyclerTouchListener(activity, patientDetailFragmentBinding.rvProfile,  ClickListener { view: View, i: Int ->
            when(i){
                0 ->DoctorsActivity.doctorsActivity?.replaceFragment( SimpleScannerFragment.newInstance())
                    /*{ val intent = Intent(DoctorsActivity.doctorsActivity, BarcodeCaptureActivity::class.java)
                        startActivity(intent) }*/
                1 -> DoctorsActivity.doctorsActivity?.replaceFragment( PatientProfileDetailFragment.newInstance())
                2 -> DoctorsActivity.doctorsActivity?.replaceFragment( AppointmentHistoryFragment.newInstance())
                3 -> DoctorsActivity.doctorsActivity?.replaceFragment( AdviceTestFragment.newInstance())
            //   DoctorsActivity.doctorsActivity?.replaceFragment( SimpleScannerFragment.newInstance())//For Scan QRCode
            }

        }

        ))
        return patientDetailFragmentBinding.root
    }
    private fun showDailog(type : Boolean, bitmap : Bitmap) {

        val dialog = object : Dialog(DoctorsActivity.doctorsActivity,android.R.style.Theme_Light){
            override fun onTouchEvent(event: MotionEvent): Boolean {
                // Tap anywhere to close dialog.
                // this.dismiss()
                return true
            }
        }
        /* val dialog = object : Dialog(DoctorsActivity.doctorsActivity) {
             override fun onTouchEvent(event: MotionEvent): Boolean {
                 // Tap anywhere to close dialog.
                // this.dismiss()
                 return true
             }
         }*/
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
       // dialog.window!!.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
            //    View.SYSTEM_UI_FLAG_IMMERSIVE or
            //    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY //or
             //   View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION //or
                //View.SYSTEM_UI_FLAG_FULLSCREEN

        /*   if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
               dialog.window!!.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(MoreActivity.self, R.color.translucent_black)))

           } else {
               dialog.window!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.translucent_black)))
           }*/


        dialog.setCancelable(true)
        dialog.setContentView(R.layout.dailog_view_report)
        val window = dialog.window
        val wlp = window!!.attributes

        wlp.gravity = Gravity.CENTER
        wlp.flags = wlp.flags and WindowManager.LayoutParams.FLAG_BLUR_BEHIND.inv()
        window.attributes = wlp
        dialog.window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        val selectPre = dialog.findViewById<TextView>(R.id.tvSelect)
        val rlLayout = dialog.findViewById<RelativeLayout>(R.id.rlLayout)
        if(type) {
            selectPre.visibility = View.VISIBLE
            rlLayout.visibility = View.VISIBLE
            selectPre.setOnClickListener {

            }
        }else{
            selectPre.visibility = View.GONE
            rlLayout.visibility = View.GONE
        }
        val report = dialog.findViewById<ImageView>(R.id.ivReport)
        report.setImageBitmap(bitmap)
        val welcome_text = dialog.findViewById<ImageView>(R.id.ivCancel)
        welcome_text.setOnClickListener{  dialog.dismiss()

         //DoctorsActivity.doctorsActivity!!.  getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
          //  DoctorsActivity.doctorsActivity!!. getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }


        dialog.show()

    }

}