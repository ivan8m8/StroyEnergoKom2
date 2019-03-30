package ru.is88.stroyenergokom2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.fragment_view_pager.*

@SuppressLint("ShowToast")
class ViewPagerFragment : Fragment() {

    private val mToast: Toast by lazy {
        Toast.makeText(context, "You switched a fragment", Toast.LENGTH_SHORT)
    }

    private var mPagerAdapter: PagerAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        mPagerAdapter = PagerAdapter(childFragmentManager)

        viewPager.adapter = mPagerAdapter

        // TASK #1
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
                // no action, ISP violation
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                // no action, ISP violation
            }

            override fun onPageSelected(position: Int) {
                // need synchronization fot this
                //if (mToast.view.isShown)
                //mToast.cancel()

                mToast.show()
            }

        })

        super.onViewCreated(view, savedInstanceState)
    }

    // TASK #2
    fun onBackPressed(passControlToActivity: () -> Unit) {
        if (viewPager?.currentItem != 0)
            viewPager?.setCurrentItem(0, true)
        else
            passControlToActivity()
    }

    companion object {
        fun newInstance(): ViewPagerFragment = ViewPagerFragment()
    }
}