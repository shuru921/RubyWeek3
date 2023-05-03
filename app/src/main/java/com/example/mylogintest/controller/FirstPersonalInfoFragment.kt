package com.example.mylogintest.controller

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mylogintest.viewmodel.FirstPersonalInfoViewModel
import com.example.mylogintest.R
import com.example.mylogintest.databinding.FragmentFirstPersonalInfoBinding
import com.example.mylogintest.model.User

class FirstPersonalInfoFragment : Fragment() {

    private lateinit var binding: FragmentFirstPersonalInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().setTitle("第一次資料填寫")
        val viewModel: FirstPersonalInfoViewModel by viewModels()
        binding = FragmentFirstPersonalInfoBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            // arguments即為前頁傳來的bundle，如果不為null即可取值
            arguments?.let {
                viewModel?.user?.value = it.getSerializable("user") as User?
            }


        }
    }

}