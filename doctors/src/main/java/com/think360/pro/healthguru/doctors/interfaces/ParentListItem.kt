package com.think360.pro.healthguru.doctors.interfaces

/**
 * Created by think360 on 18/08/17.
 */
interface ParentListItem {
    abstract fun getChildItemList(): Any
    abstract fun isInitiallyExpanded(): Boolean
}