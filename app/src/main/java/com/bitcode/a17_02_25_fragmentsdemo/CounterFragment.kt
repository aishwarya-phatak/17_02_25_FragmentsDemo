package com.bitcode.a17_02_25_fragmentsdemo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bitcode.a17_02_25_fragmentsdemo.databinding.CounterFragmentBinding

class CounterFragment : Fragment() {
    private lateinit var txtViewForCounterDisplay : TextView
    private lateinit var btnDecrement : Button
    private lateinit var btnIncrement : Button
    private var count = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var counterFragmentView = inflater.inflate(R.layout.counter_fragment,null)
        txtViewForCounterDisplay = counterFragmentView.findViewById(R.id.txtViewForCounterDisplay)
        btnIncrement = counterFragmentView.findViewById(R.id.btnIncrement)
        btnDecrement = counterFragmentView.findViewById(R.id.btnDecrement)

        btnIncrement.setOnClickListener(MyIncrementBtnClickListener())

        btnDecrement.setOnClickListener {
            if (it == btnDecrement) {
                Log.e("tag", "$it")
            }
                if (count > 0){
                    count--
                }
            txtViewForCounterDisplay.text = "$count"
        }
        return counterFragmentView
    }

    inner class MyIncrementBtnClickListener : View.OnClickListener{
        override fun onClick(v: View?) {
                count++
            txtViewForCounterDisplay.text = "$count"
        }
    }
}