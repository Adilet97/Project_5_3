package com.example.project_5_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController

class FirstFragment : Fragment() {
    private lateinit var textView: TextView
    private lateinit var buttonPlus: Button
    private lateinit var buttonMinus: Button

    private var count = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        textView = view.findViewById(R.id.textView)
        buttonPlus = view.findViewById(R.id.buttonPlus)
        buttonMinus = view.findViewById(R.id.buttonMinus)


        textView.text = "0"


        buttonPlus.setOnClickListener {
            count++
            textView.text = count.toString()
            checkCountAndNavigate()
        }

        buttonMinus.setOnClickListener {
            if (count > 0) {
                count--
                textView.text = count.toString()
                checkCountAndNavigate()
            }


        }

        return view
    }

    private fun checkCountAndNavigate() {
        if (count >= 10) {

            val bundle = Bundle()
            bundle.putInt("count", count)


            findNavController().navigate(
                R.id.action_firstFragment_to_secondFragment,
                bundle
            )
        }
    }
}