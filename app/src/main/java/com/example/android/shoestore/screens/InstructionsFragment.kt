package com.example.android.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.android.shoestore.R
import com.example.android.shoestore.databinding.InstructionsFragmentBinding

class InstructionsFragment : Fragment() {
    private lateinit var binding: InstructionsFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //I'm using LinearLayout in Fragments and Activity,
        // because I'm gonna need just orientation component and weighted spacing of views.
        // There is no need to create complex UI.
        binding =
            DataBindingUtil.inflate(inflater, R.layout.instructions_fragment, container, false)
        binding.goToShoes.setOnClickListener {
            findNavController().navigate(R.id.action_instructionsFragment_to_shoeListFragment)
        }
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)

        return binding.root
    }
}