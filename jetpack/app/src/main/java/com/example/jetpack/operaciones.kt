package com.example.jetpack

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_operaciones.*

class operaciones : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_operaciones, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Calcular.setOnClickListener {

            try {
                if (Suma.isChecked) {
                    var numero1 = Integer.parseInt(Num1.text.toString())
                    var numero2 = Integer.parseInt(Num2.text.toString())
                    var result = numero1 + numero2
                    val directions = operacionesDestionation.actionOperacionesToSuma(resultado = result)
                    Navigation.findNavController(it).navigate(directions)
                }
                if (Resta.isChecked) {
                    var numero1 = Integer.parseInt(Num1.text.toString())
                    var numero2 = Integer.parseInt(Num2.text.toString())
                    var result = numero1 - numero2
                    val directions1 = operacionesDirections.actionOperacionesToResta(resultado = result)
                    Navigation.findNavController(it).navigate(directions1)

                }
                if (Dividir.isChecked) {
                    var numero1 = Integer.parseInt(Num1.text.toString())
                    var numero2 = Integer.parseInt(Num2.text.toString())
                    var result = numero1 / numero2.toFloat()
                    Log.d("AS", "" + result)
                    val directions3 = operacionesDirections.actionOperacionesToDivision(resultado = result)
                    Navigation.findNavController(it).navigate(directions3)

                }
            } catch (e: Exception) {
                Toast.makeText(getActivity(),"Datos vacios", Toast.LENGTH_SHORT).show();
            }

        }

    }

}