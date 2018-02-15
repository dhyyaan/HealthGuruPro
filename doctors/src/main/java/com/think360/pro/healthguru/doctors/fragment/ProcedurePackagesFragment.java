package com.think360.pro.healthguru.doctors.fragment;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;
import com.think360.pro.healthguru.doctors.R;
import com.think360.pro.healthguru.doctors.customviews.expandablelistview.BaseSwipeMenuExpandableListAdapter;
import com.think360.pro.healthguru.doctors.customviews.expandablelistview.SwipeMenuExpandableCreator;
import com.think360.pro.healthguru.doctors.customviews.expandablelistview.SwipeMenuExpandableListAdapter;
import com.think360.pro.healthguru.doctors.customviews.expandablelistview.SwipeMenuExpandableListView;
import com.think360.pro.healthguru.doctors.customviews.expandablelistview.swipemenu.ContentViewWrapper;
import com.think360.pro.healthguru.doctors.customviews.expandablelistview.swipemenu.SwipeMenu;
import com.think360.pro.healthguru.doctors.customviews.expandablelistview.swipemenu.SwipeMenuItem;
import com.think360.pro.healthguru.doctors.customviews.expandablelistview.swipemenu.SwipeMenuListView;
import com.think360.pro.healthguru.doctors.databinding.ProcedurePackagesFragmentBinding;
import com.think360.pro.healthguru.doctors.model.ProcedurePackagesItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by think360 on 18/08/17.
 */

public class ProcedurePackagesFragment extends Fragment {
    private static final float INITIAL_POSITION = 0.0f;
    private static final float ROTATED_POSITION = 180f;
    private AppAdapter mAdapter;
    private List<ProcedurePackagesItem> mAppList;
 //   private SwipeMenuExpandableListView listView;


    public ProcedurePackagesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * <p>
     * // * @param param1 Parameter 1.
     *
     * @return A new instance of fragment NewsAndEventFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProcedurePackagesFragment newInstance() {
        return new ProcedurePackagesFragment();
    }

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ProcedurePackagesFragmentBinding proPackFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.procedure_packages_fragment, container, false);

       /* Movies movie_one = new Movies("RCT");
        Movies movie_two = new Movies("CT Scan");
        Movies movie_three = new Movies("X-Ray");
        Movies movie_four = new Movies("Blod Test");
        Movies movie_five = new Movies("Hemoglobin");*/


        ProcedurePackagesItem category_one = new ProcedurePackagesItem(1,"Wellness","Body Checkup","15% Health Cash Discount","₹1200",false);
        ProcedurePackagesItem category_two = new ProcedurePackagesItem(2,"Executive Health","Aarogyam 1.2 (includes 60 Tests)","15% Health Cash Discount","₹1500",false);
      //  ProcedurePackagesItem category_three = new ProcedurePackagesItem("Glycosylated Hemoglobin", Arrays.asList(movie_five, movie_one, movie_two, movie_three));
      //  ProcedurePackagesItem category_four = new ProcedurePackagesItem("Lipid Profile(includes 5 tests)", Arrays.asList(movie_five, movie_one, movie_two, movie_three));
       // ProcedurePackagesItem molvie_category_five = ProcedurePackagesItem("Glucose-Fasting Blood)", Arrays.asList(movie_five, movie_one, movie_two, movie_three))
//, category_three, molvie_category_four
        mAppList = new ArrayList(Arrays.asList(category_one, category_two));
        //  mAppList = getActivity().getPackageManager().getInstalledApplications(0);

        // 1. Create View
       // listView =  view.findViewById(R.id.listView);

        proPackFragmentBinding.listView.setmMenuStickTo(SwipeMenuListView.STICK_TO_SCREEN);
        mAdapter = new AppAdapter();
        proPackFragmentBinding.listView.setAdapter(mAdapter);
        // 5.Set OnGroupClickListener
        proPackFragmentBinding.listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                Toast.makeText(getActivity(), "group " + groupPosition + " clicked", Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });

        // 6.Set OnChildClickListener
        proPackFragmentBinding.listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getActivity(),
                        "group " + groupPosition + " child " + childPosition + " clicked", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // 7. Create and set a SwipeMenuExpandableCreator
        // define the group and child creator function
        SwipeMenuExpandableCreator creator = new SwipeMenuExpandableCreator() {
            @Override
            public void createGroup(SwipeMenu menu) {
                // Create different menus depending on the view type
                switch (menu.getViewType()) {
                    case 0:
                        createMenu1(menu);
                        break;
                    case 1:
                        createMenu1(menu);
                        break;
                    case 2:
                        createMenu1(menu);
                        break;
                }
            }

            @Override
            public void createChild(SwipeMenu menu) {
                // Create different menus depending on the view type
                switch (menu.getViewType()) {
                    case 0:
                        createMenu1(menu);
                        break;
                    case 1:
                        createMenu1(menu);
                        break;
                    case 2:
                        createMenu1(menu);
                        break;
                }
            }

            private void createMenu1(SwipeMenu menu) {
                SwipeMenuItem item1 = new SwipeMenuItem(getActivity().getApplicationContext());
                item1.setBackground(new ColorDrawable(Color.rgb(0, 30, 237)));
                item1.setWidth(dp2px(60));
                item1.setIcon(R.drawable.pencil_white);
                item1.setTitle("Edit");
                item1. setTitleSize(12);
                item1.setTitleColor(Color.parseColor("#ffffff"));
                menu.addMenuItem(item1);
                SwipeMenuItem item2 = new SwipeMenuItem(getActivity().getApplicationContext());
                item2.setBackground(new ColorDrawable(Color.rgb(247, 0, 29)));
                item2.setTitle("Remove");
                item2. setTitleSize(12);
                item2.setTitleColor(Color.parseColor("#ffffff"));
                item2.setWidth(dp2px(60));
                item2.setIcon(R.drawable.trash_white);
                menu.addMenuItem(item2);
            }
/*
            private void createMenu2(SwipeMenu menu) {
                SwipeMenuItem item1 = new SwipeMenuItem(getActivity().getApplicationContext());
                item1.setBackground(new ColorDrawable(Color.rgb(0xE5, 0xE0, 0x3F)));
                item1.setWidth(dp2px(90));
                item1.setIcon(R.drawable.nav_icon_appoinments);
                menu.addMenuItem(item1);
                SwipeMenuItem item2 = new SwipeMenuItem(getActivity().getApplicationContext());
                item2.setBackground(new ColorDrawable(Color.rgb(0xF9, 0x3F, 0x25)));
                item2.setWidth(dp2px(90));
                item2.setIcon(R.drawable.acb_icon_notification);
                menu.addMenuItem(item2);
            }

            private void createMenu3(SwipeMenu menu) {
                SwipeMenuItem item1 = new SwipeMenuItem(getActivity().getApplicationContext());
                item1.setBackground(new ColorDrawable(Color.rgb(0x30, 0xB1, 0xF5)));
                item1.setWidth(dp2px(90));
                item1.setIcon(R.drawable.user_1);
                menu.addMenuItem(item1);
                SwipeMenuItem item2 = new SwipeMenuItem(getActivity().getApplicationContext());
                item2.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9, 0xCE)));
                item2.setWidth(dp2px(90));
                item2.setIcon(R.drawable.list_axpand_less);
                menu.addMenuItem(item2);
            }*/
        };
        proPackFragmentBinding.listView.setMenuCreator(creator);

        // 8. Set OnMenuItemClickListener
        proPackFragmentBinding.listView.setOnMenuItemClickListener(new SwipeMenuExpandableListView.OnMenuItemClickListenerForExpandable() {
            @Override
            public boolean onMenuItemClick(int groupPostion, int childPostion, SwipeMenu menu, int index) {
                // ApplicationInfo item = mAppList.get(groupPostion);
                // childPostion == -1991 means it was the group's swipe menu was
                // clicked
                String s = "Group " + groupPostion;
                if (childPostion != SwipeMenuExpandableListAdapter.GROUP_INDEX) {
                    s += " , child " + childPostion;
                }
                s += " , menu index:" + index + " was clicked";
                switch (index) {
                    case 0:
                        // open
                        showDailog();
                        break;
                    case 1:
                        // delete
                        // delete(item);
                        mAppList.remove(groupPostion);
                        mAdapter.notifyDataSetChanged();
                        break;
                }
                Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        proPackFragmentBinding.btnAddProcedureList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDailog();
            }
        });

        return proPackFragmentBinding.getRoot();
    }

    class AppAdapter extends BaseSwipeMenuExpandableListAdapter {

        /**
         * Whether this group item swipable
         *
         * @param groupPosition
         * @return
         * @see BaseSwipeMenuExpandableListAdapter#isGroupSwipable(int)
         */
        @Override
        public boolean isGroupSwipable(int groupPosition) {
            return true;
        }

        /**
         * Whether this child item swipable
         *
         * @param groupPosition
         * @param childPosition
         * @return
         * @see BaseSwipeMenuExpandableListAdapter#isChildSwipable(int,
         *      int)
         */
        @Override
        public boolean isChildSwipable(int groupPosition, int childPosition) {
            if (childPosition == 0)
                return false;
            return true;
        }

        @Override
        public int getChildType(int groupPosition, int childPosition) {
            return childPosition % 3;
        }

        @Override
        public int getChildTypeCount() {
            return 3;
        }

        @Override
        public int getGroupType(int groupPosition) {
            return groupPosition % 3;
        }

        @Override
        public int getGroupTypeCount() {
            return 3;
        }

        class ViewHolder {
          //  ImageView iv_icon;
            TextView tv_pack_title;
            TextView tv_type;
            TextView tv_discount;
            TextView tv_price;
            public ViewHolder(View view) {
             //   iv_icon =  view.findViewById(R.id.iv_arrow_expand);
                tv_pack_title =  view.findViewById(R.id.tvPackProTitle);
                tv_type =  view.findViewById(R.id.tvPackProType);
                tv_discount =  view.findViewById(R.id.tvDiscount);
                tv_price =  view.findViewById(R.id.tvPrice);
                view.setTag(this);
            }
        }

        @Override
        public int getGroupCount() {
            return mAppList.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return 0;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return mAppList.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return "The " + childPosition + "'th child in " + groupPosition + "'th group.";
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public ContentViewWrapper getGroupViewAndReUsable(int groupPosition, boolean isExpanded, View convertView,
                                                          ViewGroup parent) {
            boolean reUseable = true;
            if (convertView == null) {
                convertView = View.inflate(getActivity().getApplicationContext(), R.layout.procedure_packages_list_item, null);
                convertView.setTag(new AppAdapter.ViewHolder(convertView));
                reUseable = false;
            }
           AppAdapter.ViewHolder holder = (AppAdapter.ViewHolder) convertView.getTag();

            holder.tv_pack_title.setText(mAppList.get(groupPosition).getPackProTitle());
            holder.tv_type.setText(mAppList.get(groupPosition).getPackProType());
            holder.tv_discount.setText(mAppList.get(groupPosition).getDiscount());
            holder.tv_price.setText(mAppList.get(groupPosition).getPrice());
         /*   if (isExpanded) {
               holder.iv_icon.setRotation(ROTATED_POSITION);
            } else {
                holder.iv_icon.setRotation(INITIAL_POSITION);
            }*/
            return new ContentViewWrapper(convertView, reUseable);
        }

        @Override
        public ContentViewWrapper getChildViewAndReUsable(int groupPosition, int childPosition, boolean isLastChild, View convertView,
                                                          ViewGroup parent) {
            boolean reUseable = true;
            if (convertView == null) {
                convertView = View.inflate(getActivity().getApplicationContext(), R.layout.procedure_packages_list_item, null);
                convertView.setTag(new AppAdapter.ViewHolder(convertView));
                reUseable = false;
            }
            AppAdapter.ViewHolder holder = (AppAdapter.ViewHolder) convertView.getTag();
            if (null == holder) {
                holder = new AppAdapter.ViewHolder(convertView);
            }
            convertView.setBackgroundColor(Color.GRAY);

           // holder.tv_name.setText("Clorestrol-HDL");
           // holder.tv_rate.setText("1500");
            return new ContentViewWrapper(convertView, reUseable);
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }
    View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            mAdapter.notifyDataSetChanged(true);
        }
    };

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }
    private void showDailog() {


        final Dialog dialog = new Dialog(getActivity()){
            @Override
            public boolean onTouchEvent(MotionEvent event) {
                // Tap anywhere to close dialog.
                this.dismiss();
                return true;
            }
        };
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_FULLSCREEN);

 /*       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(getActivity(),R.color.translucent_black)));

        }else{
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.translucent_black)));
        }*/


        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dailog_add_new_procedure_packages);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();

        wlp.gravity = Gravity.CENTER;
        wlp.flags &= ~WindowManager.LayoutParams.FLAG_BLUR_BEHIND;
        window.setAttributes(wlp);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
       // CenturyGothicBold title=(CenturyGothicBold)dialog.findViewById(R.id.title);
       // CenturyGothicRegular welcome_text=(CenturyGothicRegular)dialog.findViewById(R.id.welcome_text);
       // title.setText(jsonObject.optString("title"));
       // welcome_text.setText(jsonObject.optString("description"));

        dialog.show();
    }
}
