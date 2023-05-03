package com.example.mylogintest.controller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.mylogintest.viewmodel.LoginSignUpViewModel
import com.example.mylogintest.R
import com.example.mylogintest.databinding.FragmentLoginSignUpBinding

class LoginSignUpFragment : Fragment() {

    private lateinit var binding: FragmentLoginSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        requireActivity().setTitle("主頁")
        val viewModel: LoginSignUpViewModel by viewModels()
        binding = FragmentLoginSignUpBinding.inflate(inflater,container,false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            btSignUpH.setOnClickListener {
                Navigation.findNavController(it).navigate(
                    R.id.action_loginSignUpFragment_to_signUpFragment
                )
            }
            btLoginH.setOnClickListener {
                Navigation.findNavController(it).navigate(
                    R.id.action_loginSignUpFragment_to_loginFragment
                )
            }

        }

    }



}