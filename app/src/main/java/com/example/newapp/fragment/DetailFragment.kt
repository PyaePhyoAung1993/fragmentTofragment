package com.example.newapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newapp.R
import kotlinx.android.synthetic.main.item_topheadlines.*

class DetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var messageArgs = arguments?.let { DetailFragmentArgs.fromBundle(it) }

        var message = messageArgs?.message
        Log.d("message",message.toString())
        t1.text = message.toString()
    }
}