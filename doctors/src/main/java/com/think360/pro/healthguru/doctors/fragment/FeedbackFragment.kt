package com.think360.pro.healthguru.doctors.fragment

import android.app.Dialog
import android.databinding.DataBindingUtil
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.*
import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.activities.DoctorsActivity
import com.think360.pro.healthguru.doctors.adapter.FeedbackBindingAdapter
import com.think360.pro.healthguru.doctors.adapter.PatientsBindingAdapter
import com.think360.pro.healthguru.doctors.databinding.FeedbackFragmentBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.FeedbackItem
import com.think360.pro.healthguru.doctors.model.PatientsItem
import org.json.JSONException
import org.json.JSONObject
import java.util.HashMap

/**
 * Created by think360 on 11/08/17.
 */
class FeedbackFragment : Fragment() {
    companion object {
        fun newInstance(): FeedbackFragment {
            return FeedbackFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val   feedbackFragmentBinding   = DataBindingUtil.inflate<FeedbackFragmentBinding>(inflater, R.layout.feedback_fragment, container, false)

        val actionCallback = object : ActionCallback {
            override   fun onClick(item: Any) {
                val objItem = item as FeedbackItem?
             // Log.d("Feedback",objItem?.proName)
                showDailog();
            }

        }
        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.tvMainTitle?.text = resources.getString(R.string.txt_not_feedback)
        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.ivBack?.setOnClickListener {
            DoctorsActivity?.doctorsActivity?.onBackPressed()
        }
        val mPackagesList = ArrayList<FeedbackItem>()
        mPackagesList.add(0, FeedbackItem(1,"Rajni Singh","2 days ago","Experianced doctor with a well equipped clinic.Completely saticefactory with the consultation.I recomonded him for any type of skin problems",R.drawable.user_1))
        mPackagesList.add(1, FeedbackItem(2,"Neha Singh","3 days ago","Experianced doctor with a well equipped clinic.Completely saticefactory with the consultation.I recomonded him for any type of skin problems",R.drawable.user_2))
        mPackagesList.add(2, FeedbackItem(3,"Tejinder Singh","1 days ago","Experianced doctor with a well equipped clinic.Completely saticefactory with the consultation.I recomonded him for any type of skin problems",R.drawable.user_1))
        mPackagesList.add(3, FeedbackItem(4,"Salini Kashyap","5 days ago","Experianced doctor with a well equipped clinic.Completely saticefactory with the consultation.I recomonded him for any type of skin problems",R.drawable.user_2))

        val adapter = FeedbackBindingAdapter(actionCallback,mPackagesList )

        feedbackFragmentBinding.rvLatestFeedback.adapter = adapter
        adapter.notifyDataSetChanged()


        return feedbackFragmentBinding.root
    }

    private fun showDailog() {


                        val dialog = object : Dialog(DoctorsActivity.doctorsActivity) {
                            override fun onTouchEvent(event: MotionEvent): Boolean {
                                // Tap anywhere to close dialog.
                                this.dismiss()
                                return true
                            }
                        }
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                        dialog.window!!.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                                View.SYSTEM_UI_FLAG_IMMERSIVE or
                                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                                View.SYSTEM_UI_FLAG_FULLSCREEN

                     /*   if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            dialog.window!!.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(MoreActivity.self, R.color.translucent_black)))

                        } else {
                            dialog.window!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.translucent_black)))
                        }*/


                        dialog.setCancelable(true)
                        dialog.setContentView(R.layout.dailog_feedback_report)
                        val window = dialog.window
                        val wlp = window!!.attributes

                        wlp.gravity = Gravity.CENTER
                        wlp.flags = wlp.flags and WindowManager.LayoutParams.FLAG_BLUR_BEHIND.inv()
                        window.attributes = wlp
                        dialog.window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                /*        val title = dialog.findViewById<View>(R.id.title) as CenturyGothicBold
                        val welcome_text = dialog.findViewById<View>(R.id.welcome_text) as CenturyGothicRegular
                        title.setText(jsonObject.optString("title"))
                        welcome_text.setText(jsonObject.optString("description"))*/

                        dialog.show()

    }
}
