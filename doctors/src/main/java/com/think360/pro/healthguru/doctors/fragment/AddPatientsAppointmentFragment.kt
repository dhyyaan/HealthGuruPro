package com.think360.pro.healthguru.doctors.fragment

import android.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.think360.pro.healthguru.doctors.R
import com.think360.pro.healthguru.doctors.activities.DoctorsActivity
import com.think360.pro.healthguru.doctors.databinding.AddPatientsAppointmentFragmentBinding
import android.widget.Toast
import android.widget.DatePicker
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.view.View.OnClickListener
import java.util.*
import android.databinding.adapters.TextViewBindingAdapter.setText
import android.support.v4.app.FragmentManager
import android.widget.TimePicker




/**
 * Created by think360 on 21/08/17.
 */
class AddPatientsAppointmentFragment : Fragment() {
    var   addPatAptFragmentBinding : AddPatientsAppointmentFragmentBinding? = null
    companion object {
        fun newInstance(): AddPatientsAppointmentFragment {
            return AddPatientsAppointmentFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        addPatAptFragmentBinding   = DataBindingUtil.inflate<AddPatientsAppointmentFragmentBinding>(inflater, R.layout.add_patients_appointment_fragment, container, false)
        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.tvMainTitle?.text = resources.getString(R.string.txt_title_new_patient)
       DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.navigation?.visibility = View.GONE

        addPatAptFragmentBinding?.btnSubmit?.setOnClickListener (mOnClickListener)
        addPatAptFragmentBinding?.etDate?.setOnClickListener (mOnClickListener)
        addPatAptFragmentBinding?.etAptTime?.setOnClickListener (mOnClickListener)
        DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.ivBack?.setOnClickListener {
            DoctorsActivity?.doctorsActivity?.onBackPressed()
        }

        return addPatAptFragmentBinding?.root
    }

    private val mOnClickListener = OnClickListener  { item ->
        when (item.id) {
            R.id.btnSubmit -> {
                DoctorsActivity.doctorsActivity?.activityDoctorsBinding?.tvMainTitle?.text = resources.getString(R.string.nav_title_patients)
                DoctorsActivity.doctorsActivity!!.activityDoctorsBinding!!.ivBack?.visibility = View.GONE
                DoctorsActivity.doctorsActivity!!. activityDoctorsBinding?.navigation?.selectedItemId =  R.id.navigation_patients
                DoctorsActivity?.doctorsActivity?.activityDoctorsBinding?.navigation?.visibility = View.VISIBLE
                fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

            }
            R.id.etDate -> {
                             val c = Calendar.getInstance()
                             val year = c.get(Calendar.YEAR)
                             val month = c.get(Calendar.MONTH)
                             val day = c.get(Calendar.DAY_OF_MONTH)
                val mdiDialog = DatePickerDialog(DoctorsActivity.doctorsActivity, DatePickerDialog.OnDateSetListener {
                    view, year, monthOfYear, dayOfMonth ->

                    addPatAptFragmentBinding?.etDate?.setText("$dayOfMonth-$monthOfYear-$year")


                    }
                        , year, month, day )
                mdiDialog.show()
            }
            R.id.etAptTime -> {
                val mcurrentTime = Calendar.getInstance()
                val hour = mcurrentTime.get(Calendar.HOUR_OF_DAY)
                val minute = mcurrentTime.get(Calendar.MINUTE)
                val mTimePicker: TimePickerDialog
                mTimePicker = TimePickerDialog(DoctorsActivity.doctorsActivity, TimePickerDialog.OnTimeSetListener { timePicker, selectedHour, selectedMinute ->
                    addPatAptFragmentBinding?.etAptTime?.setText("$selectedHour:$selectedMinute")
                 }, hour, minute, false)//Yes 24 hour time
               // mTimePicker.setTitle("Select Time")
                mTimePicker.show()

            }
        }
    }
}