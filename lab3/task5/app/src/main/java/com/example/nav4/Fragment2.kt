package com.example.nav4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class Fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonToFirst = view.findViewById<Button>(R.id.bnToFirst)
        buttonToFirst.setOnClickListener { onClickToFirst() }

        val buttonToThird = view.findViewById<Button>(R.id.bnToThird)
        buttonToThird.setOnClickListener { onClickToThird() }
    }

    private fun onClickToThird() {
        findNavController().navigate(R.id.action_fragment2_to_fragment3)
    }

    private fun onClickToFirst() {
        findNavController().popBackStack()
    }
}