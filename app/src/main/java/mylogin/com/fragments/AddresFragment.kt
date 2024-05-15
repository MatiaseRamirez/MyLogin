package com.example.activityhome.fragments

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import com.google.gson.Gson
import mylogin.com.Addres
import mylogin.com.R
import mylogin.com.databinding.FragmentAddresBinding
import java.time.temporal.ValueRange

class AddresFragment : Fragment() {

    private lateinit var binding: FragmentAddresBinding
    private lateinit var tvaddres: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentAddresBinding.inflate(inflater, container, false)
        tvaddres = binding.tvaddres
        var addres = Addres("", "", "", "")
        val preferences = requireActivity().getSharedPreferences(ADDRESSES, MODE_PRIVATE)
        val gson = Gson()
        val addresJson = preferences.getString("addres", "No hay registro")

        //PARTE DONDE TIENE QUE VALIDAR QUE EXISTE preferences

        addres = gson.fromJson(addresJson, Addres::class.java)
        val nohayarchivi=addresJson.get()

        if (addres.street == ""){
            addres = gson.fromJson(addresJson, Addres::class.java)
            tvaddres.setText(addresJson)
            tvaddres.setText("Direccion: " + addres.street + " " + addres.height + "\nCodigo Postal: " + addres.postalcode + "\nProvincia: " + addres.state)
            //Capturar variable de SharedPreferences
            tvaddres.setVisibility(View.VISIBLE)

        }else{

        }

       /*elsa {
            addres = gson.fromJson(addresJson, Addres::class.java)
            tvaddres.setText(addresJson)
            tvaddres.setText("Direccion: " + addres.street + " " + addres.height + "\nCodigo Postal: " + addres.postalcode + "\nProvincia: " + addres.state)
            //Capturar variable de SharedPreferences
            tvaddres.setVisibility(View.VISIBLE)
        }*/

            binding.addresBtn.setOnClickListener {
                val dirrecion = binding.direccionInput.text.toString()
                val altura = binding.alturaInput.text.toString()
                val codigopostal = binding.codigoPostalInput.text.toString()
                val provincia = binding.provinciaInput.text.toString()

                if (validateFields(dirrecion, altura, codigopostal, provincia)) {
                    val edit = preferences.edit()
                    val addres = Addres(dirrecion, altura, codigopostal, provincia)
                    val gson = Gson()
                    val addressInJsonFormat = gson.toJson(addres)

                    edit.putString("addres", addressInJsonFormat)
                    edit.apply()
                    Toast.makeText(requireContext(), "Direccion Agregado!", Toast.LENGTH_SHORT).show()
                    tvaddres.setText("Direccion: " + addres.street + " " + addres.height + "\nCodigo Postal: " + addres.postalcode + "\nProvincia: " + addres.state)
                    tvaddres.setVisibility(View.VISIBLE)

                }  else {
                    Toast.makeText(requireContext(), "Debe completar todos los campos!", Toast.LENGTH_SHORT).show()
                }
            }

        return binding.root
    }

    private fun validateFields(street :String, height:String,postalcode:String,state:String ): Boolean {
        return if (street.isNotBlank() && height.isNotBlank() && postalcode.isNotBlank() && state.isNotBlank() != null) {
            true
        } else {
            false
        }
    }
    companion object {
        const val ADDRESSES = "Direcciones"
    }

}