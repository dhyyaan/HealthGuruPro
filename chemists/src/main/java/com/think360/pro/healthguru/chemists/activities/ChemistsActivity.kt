package com.think360.pro.healthguru.chemists.activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.think360.pro.healthguru.chemists.R
import com.think360.pro.healthguru.chemists.databinding.ActivityChemistsBinding
import com.think360.pro.healthguru.chemists.fragments.BillsFragment
import com.think360.pro.healthguru.chemists.fragments.ProfileFragment


class ChemistsActivity : AppCompatActivity() {

    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * [FragmentPagerAdapter] derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].
     */
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    private val tabIcons = intArrayOf(R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
    /**
     * The [ViewPager] that will host the section contents.
     */
    private var mViewPager: ViewPager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityChemistsBinding>(this,R.layout.activity_chemists)
        setupTab()

    }
    /**
     * A placeholder fragment containing a simple view.
     */
    class PlaceholderFragment : Fragment() {

        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            val rootView = inflater!!.inflate(R.layout.bills_fragment, container, false)


            return rootView
        }

        companion object {
            /**
             * The fragment argument representing the section number for this
             * fragment.
             */
            private val ARG_SECTION_NUMBER = "section_number"

            /**
             * Returns a new instance of this fragment for the given section
             * number.
             */
            fun newInstance(): PlaceholderFragment {
                val fragment = PlaceholderFragment()

                return fragment
            }
        }
    }
    /**
     * A placeholder fragment containing a simple view.
     */
    class PlaceholderFragment2 : Fragment() {

        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            val rootView = inflater!!.inflate(R.layout.profile_fragment, container, false)


            return rootView
        }

        companion object {


            /**
             * Returns a new instance of this fragment for the given section
             * number.
             */
            fun newInstance(): PlaceholderFragment2 {
                val fragment = PlaceholderFragment2()

                return fragment
            }
        }
    }
    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            when (position) {
                0 -> return BillsFragment.newInstance()
                1 -> return ProfileFragment.newInstance()

            }
            return PlaceholderFragment.newInstance()
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return 2
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> return "Bills"
                1 -> return "Profile"

            }
            return null
        }
    }

    private fun setupTab() {

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.vpContainer) as ViewPager
        mViewPager!!.adapter = mSectionsPagerAdapter

        val tabLayout = findViewById(R.id.tabs) as TabLayout
        tabLayout.setupWithViewPager(mViewPager)

        tabLayout.getTabAt(0)?.setIcon(tabIcons[0]);
        tabLayout.getTabAt(1)?.setIcon(tabIcons[1]);
    }

}
