package com.example.jetpack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation


class unoFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                System.exit(0)
            }
        }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_uno, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bnav = view.findViewById<Button>(R.id.bNav)
        val bcam = view.findViewById<Button>(R.id.bCam)
        val bcal = view.findViewById<Button>(R.id.bCalcular)

        bnav.setOnClickListener{
            val ir = unoFragmentDirections.actionUnoFragmentToNavegador()
            Navigation.findNavController(it).navigate(ir)
        }

        bcam.setOnClickListener{
            val ir = unoFragmentDirections.actionUnoFragmentToCamara()
            Navigation.findNavController(it).navigate(ir)
        }

        bcal.setOnClickListener{
            val ir = unoFragmentDirections.actionUnoFragmentToOperaciones()
            Navigation.findNavController(it).navigate(ir)
        }
    }
}