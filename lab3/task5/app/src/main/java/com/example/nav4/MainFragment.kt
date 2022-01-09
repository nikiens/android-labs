package com.example.nav4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonToSecond = view.findViewById<Button>(R.id.bnToSecond)
        buttonToSecond.setOnClickListener { onClickToSecond() }
    }

    private fun onClickToSecond() {
        findNavController().navigate(R.id.action_mainFragment_to_fragment2)
    }
}