package com.example.activityhome.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mylogin.com.databinding.FragmentClaimsBinding

class ClaimsFragment : Fragment() {

    private lateinit var binding: FragmentClaimsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentClaimsBinding.inflate(inflater, container, false)





        return binding.root
    }


}