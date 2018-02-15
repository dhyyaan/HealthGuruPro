package com.think360.pro.healthguru.doctors.fragment

import android.app.Dialog
import android.databinding.DataBindingUtil
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.*
import android.widget.LinearLayout
import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.activities.DoctorsActivity
import com.think360.pro.healthguru.doctors.adapter.RequestAppointmentAdapter
import com.think360.pro.healthguru.doctors.databinding.PatientsFragmentBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.RequestAptItem
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import com.rafakob.drawme.DrawMeRelativeLayout
import com.rafakob.drawme.DrawMeTextView


/**
 * Created by think360 on 30/08/17.
 */
class RequestAppointmentFragment : Fragment() {
    companion object {
        fun newInstance(): RequestAppointmentFragment {
            return RequestAppointmentFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val   patientsFragmentBinding   = DataBindingUtil.inflate<PatientsFragmentBinding>(inflater, R.layout.patients_fragment, container, false)
        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.navigation?.visibility =  View.GONE
        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.tvMainTitle?.text = resources.getString(R.string.txt_title_apt_request)


        val actionCallback = object : ActionCallback {
            override   fun onClick(item: Any) {
                val objItem = item as RequestAptItem?
                //Log.d("Notification Detail",objItem?.name)
                showDailog()
            }

        }
        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.ivBack?.setOnClickListener {
            DoctorsActivity?.doctorsActivity?.onBackPressed()
        }
        patientsFragmentBinding.buttonAddApnt.setOnClickListener {  DoctorsActivity.doctorsActivity?.replaceFragment( AddPatientsAppointmentFragment.newInstance()) }
        val mPackagesList = ArrayList<RequestAptItem>()
        mPackagesList.add(0, RequestAptItem(1,"Harpreet Kaur","Corporate","F","10-11", R.drawable.user_1,false))
        mPackagesList.add(1, RequestAptItem(2,"GurPreet Singh","Corporate","M","11-12", R.drawable.user_2,false))
        mPackagesList.add(2, RequestAptItem(3,"Harpreet Kaur","Corporate","F","12-01", R.drawable.user_1,false))
        mPackagesList.add(3, RequestAptItem(4,"GurPreet Singh","Corporate","M","02-03", R.drawable.user_2,false))

        val adapter = RequestAppointmentAdapter(actionCallback,mPackagesList)
        patientsFragmentBinding.rvRearchResult.adapter = adapter
        adapter.notifyDataSetChanged()
        return patientsFragmentBinding.root
    }
    private fun showDailog() {

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
        dialog.window!!.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_IMMERSIVE or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_FULLSCREEN

          if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
               dialog.window!!.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(DoctorsActivity.doctorsActivity, R.color.translucent_black)))

           } else {
               dialog.window!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.translucent_black)))
           }


        dialog.setCancelable(true)
        //dialog.setContentView(R.layout.dailog_choose_time)
        dialog.setContentView(R.layout.dailog_choose_time )
        val window = dialog.window
        val wlp = window!!.attributes

        wlp.gravity = Gravity.CENTER
        wlp.flags = wlp.flags and WindowManager.LayoutParams.FLAG_BLUR_BEHIND.inv()
        window.attributes = wlp
        dialog.window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
       val llTimeSlot = dialog.findViewById<LinearLayout>(R.id.llTimeSlot)

        for (i in 1..5){
            val view = LayoutInflater.from(DoctorsActivity.doctorsActivity).inflate(R.layout.layout_slot, null)
            val drawMorCount : DrawMeTextView = view.findViewById<DrawMeTextView>(R.id.drawMorCount)
            drawMorCount.text = ""+i
            val drawEveCount : DrawMeTextView = view.findViewById<DrawMeTextView>(R.id.drawEveCount)
            drawEveCount.text = ""+(i+1)
            llTimeSlot.addView(view)
            val btnMorning  :  DrawMeRelativeLayout = view.findViewById<DrawMeRelativeLayout>(R.id.llMorningSlot)
            btnMorning.setOnClickListener{


                    Toast.makeText(view.context,
                            "Button clicked index = "+drawMorCount.text, Toast.LENGTH_SHORT)
                            .show()
                }
            val btnEve  :  DrawMeRelativeLayout = view.findViewById<DrawMeRelativeLayout>(R.id.llEveningSlot)
            btnEve.setOnClickListener{

                Toast.makeText(view.context,
                        "Button clicked index = "+drawEveCount.text, Toast.LENGTH_SHORT)
                        .show()
            }
        }


        // welcome_text.setOnClickListener{  dialog.dismiss() }
        /*        val title = dialog.findViewById<View>(R.id.title) as CenturyGothicBold
                val welcome_text = dialog.findViewById<View>(R.id.welcome_text) as CenturyGothicRegular
                title.setText(jsonObject.optString("title"))
                welcome_text.setText(jsonObject.optString("description"))*/

        dialog.show()

    }

}
