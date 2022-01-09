package com.example.nav4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class Fragment3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonToFirst = view.findViewById<Button>(R.id.bnToFirst)
        buttonToFirst.setOnClickListener { onClickToFirst() }

        val buttonToSecond = view.findViewById<Button>(R.id.bnToSecond)
        buttonToSecond.setOnClickListener { onClickToSecond() }
    }

    private fun onClickToFirst() {
        findNavController().popBackStack(R.id.mainFragment, false)
    }

    private fun onClickToSecond() {
        findNavController().popBackStack()
    }
}