package ru.is88.stroyenergokom2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import kotlinx.android.synthetic.main.activity_main.*

@SuppressLint("ShowToast")
class MainActivity : AppCompatActivity() {

    private val VIEWPAGER_TAG = "VPT"

    private val mSharedViewModel by lazy {
        ViewModelProviders.of(this).get(SharedViewModel::class.java)
    }

    private val fragment = Task3Fragment2.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, ViewPagerFragment.newInstance(), VIEWPAGER_TAG)
            .commit()

        // TASK #3
        // показываю ранее созданный фрагмент вместо всего ViewPager (это же требовалось?);
        // правда нет никакой гарантии, что сборщик мусора не уберёт instance фргмента,
        // который мы хотим показать, не создавая.
        // поэтому я такого кейса не встречал пока.
        mSharedViewModel.buttonClicked.observe(this, Observer {
            it.getContentIfNotHandled()?.let {

                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .addToBackStack(null)
                    .commit()

            }
        })
    }

    // TASK #2
    override fun onBackPressed() {

        val viewPagerFragment = supportFragmentManager.findFragmentByTag(VIEWPAGER_TAG) as? ViewPagerFragment
        viewPagerFragment?.let {
            if (it.isVisible) {
                it.onBackPressed {
                    super.onBackPressed()
                }
            } else {
                super.onBackPressed()
            }
        }

    }
}
