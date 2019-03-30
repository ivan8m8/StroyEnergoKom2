package ru.is88.stroyenergokom2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            1 -> Task3Fragment.newInstance()
            else -> PageFragment.newInstance(position + 1)
        }
    }

    override fun getCount(): Int = 3
}