package ru.is88.stroyenergokom2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Task3Fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment2_task3, container, false)
    }

    companion object {
        fun newInstance(): Task3Fragment2 {
            Log.d("KSI", "A new instance of Task3Fragment2 has just been created")
            return Task3Fragment2()
        }
    }
}