package com.example.android.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.android.shoestore.R
import com.example.android.shoestore.viewModel.ShoeListViewModel
import com.example.android.shoestore.databinding.ShoeDetailFragmentBinding
import java.lang.NumberFormatException

class ShoeDetailsFragment : Fragment() {
    private lateinit var binding: ShoeDetailFragmentBinding
    private val viewModel: ShoeListViewModel by activityViewModels()
    private lateinit var shoeName: String
    private lateinit var shoeSize: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoe_detail_fragment, container, false
        )
        binding.cancelButton.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.saveButton.setOnClickListener {
            shoeName = binding.newShoeName.text.toString()
            shoeSize = binding.newShoeSize.text.toString()
            if (shoeName.isEmpty()) {
                Toast.makeText(context, "Enter Shoe's Name", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            try {
                shoeSize.toDouble()
            } catch (e: NumberFormatException) {
                Toast.makeText(context, "Enter Shoe's Size", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            viewModel.description.value = binding.newShoeDescription.text.toString()
            viewModel.name.value = shoeName
            viewModel.company.value = binding.newShoeCompany.text.toString()
            viewModel.size.value = shoeSize.toDouble()
            viewModel.addShoe()
            findNavController().navigateUp()
        }
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        return binding.root
    }
}