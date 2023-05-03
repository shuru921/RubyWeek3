package com.example.mylogintest.controller

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mylogintest.R
import com.example.mylogintest.databinding.FragmentSignUpBinding
import com.example.mylogintest.model.User
import com.example.mylogintest.viewmodel.SignUpViewModel

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().setTitle("註冊:1111")
        val viewModel: SignUpViewModel by viewModels()
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            viewModel?.uid?.observe(viewLifecycleOwner) {
                inputValid()
            }
            viewModel?.password?.observe(viewLifecycleOwner) {
                inputValid()
            }
            viewModel?.passwordAgain?.observe(viewLifecycleOwner) {
                inputValid()
            }
            viewModel?.verifyCode?.observe(viewLifecycleOwner) {
                inputValid()
            }

            btSignUpSU.setOnClickListener {

                val uid = viewModel!!.uid.value
                val password = viewModel!!.password.value
                val passwordAgain = viewModel!!.passwordAgain.value
                val verifyCode = viewModel!!.verifyCode.value
                val user = User(uid, password)

                if (!inputValid() ) {
                    return@setOnClickListener
                }
                if (password != passwordAgain) {
                    tvResultSU.text = getString(R.string.errPasswordAgainFail)
                    return@setOnClickListener
                }
                if (verifyCode == "1111") {
                    tvResultSU.text = user.toString()
                }else {
                    tvResultSU.text = "驗證碼錯誤"
                }

            }

        }
    }

    private fun inputValid(): Boolean {
        var valid = true
        with(binding) {
            val uid = viewModel?.uid?.value?.trim()
            val password = viewModel?.password?.value?.trim()
            val passwordAgain = viewModel?.passwordAgain?.value?.trim()
            val verifyCode = viewModel?.verifyCode?.value?.trim()

            if (uid == null || uid.isEmpty()) {
                etAccountSU.error = getString(R.string.errAccountEmpty)
                valid = false
            }
            if (password == null || password.isEmpty()) {
                etPasswordSU.error = getString(R.string.errPasswordEmpty)
                valid = false
            }
            if (passwordAgain == null || passwordAgain.isEmpty()) {
                etPasswordAgainSU.error = getString(R.string.errPasswordEmpty)
                valid = false
            }
            if (verifyCode == null || verifyCode.isEmpty()) {
                etVerifySU.error = getString(R.string.errVerifyCodeEmpty)
                valid = false
            }
        }
        return valid
    }

}