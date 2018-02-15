package com.think360.pro.healthguru.doctors.fragment

import android.app.Dialog
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import android.widget.ImageView
import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.activities.DoctorsActivity
import com.think360.pro.healthguru.doctors.adapter.AptHistoryDetailAdapter
import com.think360.pro.healthguru.doctors.databinding.AptHistoryDetailFragmentBinding
import com.think360.pro.healthguru.doctors.interfaces.ActionCallback
import com.think360.pro.healthguru.doctors.model.HisDetailItem

/**
 * Created by think360 on 29/08/17.
 */
class AptHistoryDetailFragment : Fragment() {
    companion object {
        fun newInstance(): AptHistoryDetailFragment {
            return AptHistoryDetailFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val   aptHistoryDetailFragmentBinding   = DataBindingUtil.inflate<AptHistoryDetailFragmentBinding>(inflater, R.layout.apt_history_detail_fragment, container, false)
        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.tvMainTitle?.text = resources.getString(R.string.txt_title_apt_history)


        val actionCallback = object : ActionCallback {
            override   fun onClick(item: Any) {
                showDailog()
            }
        }
        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.ivBack?.setOnClickListener {
            DoctorsActivity?.doctorsActivity?.onBackPressed()
        }
        val mPackagesList = ArrayList<HisDetailItem>()
        mPackagesList.add(0, HisDetailItem(1,"Urine Routine Examination"))
        mPackagesList.add(1, HisDetailItem(2,"Lipid Profile"))


        val adapter = AptHistoryDetailAdapter(actionCallback,mPackagesList)
        aptHistoryDetailFragmentBinding.rvHisDetail.adapter = adapter
        adapter.notifyDataSetChanged()
        aptHistoryDetailFragmentBinding.ivPreception.setOnClickListener { showDailog() }

        return aptHistoryDetailFragmentBinding.root
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
        val welcome_text = dialog.findViewById<ImageView>(R.id.ivCancel)
        welcome_text.setOnClickListener{  dialog.dismiss() }
        /*        val title = dialog.findViewById<View>(R.id.title) as CenturyGothicBold
                val welcome_text = dialog.findViewById<View>(R.id.welcome_text) as CenturyGothicRegular
                title.setText(jsonObject.optString("title"))
                welcome_text.setText(jsonObject.optString("description"))*/

        dialog.show()

    }
}