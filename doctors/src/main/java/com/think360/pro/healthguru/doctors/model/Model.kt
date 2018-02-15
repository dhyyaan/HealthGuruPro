package com.think360.pro.healthguru.doctors.model
import com.think360.pro.healthguru.doctors.interfaces.ParentListItem

/**
 * Created by think360 on 01/08/17.
 */
data class PatientsItem(val name: String, val role: String, val gender : String,val timeSlot : String, val image :Int)
data class BlogItem(val itemId : Int,val blogType: String, val blogTitle: String, val doctorName : String,val doctorType : String, val likes :Int,val ivBlog : Int)
data class ProfileItem(val ivProfileImage : Int, val profileName: String,val visibility : Boolean)
data class ProcedurePackagesItem(val id : Int ,val packProTitle : String, val packProType: String, val discount : String ,val price : String,val listItem: Any): ParentListItem {
    override fun getChildItemList(): Any {
        return listItem
    }

    override fun isInitiallyExpanded(): Boolean {
        return false
    }
}

data class FeedbackItem(val id : Int ,val proName : String, val proDate: String, val proText : String ,val proImage :Int)
data class ProcedureListItem(val id : Int ,val name : String, val price: String)
data class ProcedureListCategory(val id : Int ,val name : String,val price : String, val listItem: Any) : ParentListItem {
    override fun getChildItemList(): Any {
        return listItem
    }

    override fun isInitiallyExpanded(): Boolean {
        return false
    }
}
data class NotificationItem(val id : Int ,val name : String, val time: String,val request : String,val gender : String,val timeSlot : String, val image : Int)
data class PatientProfileItem(val ivProfileImage : Int, val count : String,val cVisivility : Boolean,val profileName: String,val ok : String,val oKVisivility : Boolean)

data class LabNearByUItem(val id : Int,val proImage : Int,val labName : String, val mNumber : String,val labAddress : String)
data class ChooseItem( val item : String,val visibility : Boolean)

data class AptHistoryItem( val id : Int, val gender : String,val timeSlot : String,val date : String,val testCount : String,val preCount : String)
data class HisDetailItem( val id : Int,val test : String)
data class AddTestItem( val id : Int,val test : String,val selected : Boolean)

data class RequestAptItem(val id : Int,val name: String, val role: String, val gender : String,val timeSlot : String, val image :Int,val toggle : Boolean)