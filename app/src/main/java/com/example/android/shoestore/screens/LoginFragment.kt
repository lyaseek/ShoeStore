package com.example.android.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.android.shoestore.R
import com.example.android.shoestore.databinding.LoginFragmentBinding

class Login : Fragment() {
    private lateinit var binding: LoginFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //I'm using LinearLayout in Fragments and Activity,
        // because I'm gonna need just orientation component and weighted spacing of views.
        // There is no need to create complex UI.
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.login_fragment,
            container,
            false
        )

        binding.logInButton.setOnClickListener {
            if (checkData()) {
                return@setOnClickListener
            }
            val bundle = bundleOf("login" to binding.nicknameEdit.text.toString())
            findNavController().navigate(R.id.action_login_to_welcomeFragment, bundle)
        }
        binding.joinNowButton.setOnClickListener {
            if (checkData()) {
                return@setOnClickListener
            }
            val bundle = bundleOf("login" to binding.nicknameEdit.text.toString())
            findNavController().navigate(R.id.action_login_to_welcomeFragment, bundle)
        }
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        return binding.root
    }

    private fun checkData(): Boolean {
        if (binding.nicknameEdit.text.isNullOrEmpty()) {
            Toast.makeText(context, "Enter your Login", Toast.LENGTH_LONG).show()
            return true
        } else if (binding.passwordEdit.text.isNullOrEmpty()) {
            Toast.makeText(context, "Enter your Password", Toast.LENGTH_LONG).show()
            return true
        }
        return false
    }
}