package com.think360.pro.healthguru.doctors.customviews.expandablelistview;

import com.think360.pro.healthguru.doctors.customviews.expandablelistview.swipemenu.SwipeMenu;


/**
 * 
 * @author yuchentang seperate the group and the child's menu creator
 * 
 */
public interface SwipeMenuExpandableCreator {

    void createGroup(SwipeMenu menu);

    void createChild(SwipeMenu menu);
}
