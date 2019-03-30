package ru.is88.stroyenergokom2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_task3.*

class Task3Fragment : Fragment() {

    private val mSharedViewModel by lazy {
        activity?.let {
            ViewModelProviders.of(it).get(SharedViewModel::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_task3, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {

        button.setOnClickListener {
            mSharedViewModel?.onButtonClick()
        }

        super.onActivityCreated(savedInstanceState)
    }

    companion object {
        fun newInstance(): Task3Fragment = Task3Fragment()
    }
}