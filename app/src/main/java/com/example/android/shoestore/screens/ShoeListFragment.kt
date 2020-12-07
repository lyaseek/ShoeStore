package com.example.android.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.android.shoestore.R
import com.example.android.shoestore.viewModel.ShoeListViewModel
import com.example.android.shoestore.databinding.ShoeListFragmentBinding


class ShoeListFragment : Fragment() {
    private val viewModel: ShoeListViewModel by activityViewModels()
    private lateinit var binding: ShoeListFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoe_list_fragment, container, false
        )
        binding.shoeListViewModel = viewModel
        binding.setLifecycleOwner { this.lifecycle }
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        binding.toolbar.inflateMenu(R.menu.logout_menu)
        viewModel.shoesArray.observe(viewLifecycleOwner, Observer {
            for (item in it.iterator()) {
                val name = TextView(context)
                name.text = item.name
                name.textSize = resources.getDimension(R.dimen.text_shoe_name)
                val size = TextView(context)
                size.text = item.size.toString()
                size.textSize = resources.getDimension(R.dimen.text_shoe_params)
                val company = TextView(context)
                company.text = item.company
                company.textSize = resources.getDimension(R.dimen.text_shoe_params)
                val description = TextView(context)
                description.text = item.description
                description.textSize = resources.getDimension(R.dimen.text_shoe_params)
                val parent = LinearLayout(context)
                val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
                )
                parent.layoutParams = layoutParams
                parent.orientation = LinearLayout.VERTICAL
                parent.setPadding(16, 16, 16, 16)
                parent.addView(name)
                parent.addView(size)
                parent.addView(company)
                parent.addView(description)
                binding.listShoesLayout.addView(parent)
            }
        })
        binding.addShoeButton.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailsFragment)
        }

        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.login -> navController.navigate(R.id.action_shoeListFragment_to_login)
            }
            true
        }
        return binding.root
    }

}