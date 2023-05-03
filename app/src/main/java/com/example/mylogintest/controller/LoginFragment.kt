package com.example.mylogintest.controller

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.mylogintest.R
import com.example.mylogintest.databinding.FragmentLoginBinding
import com.example.mylogintest.model.User
import com.example.mylogintest.viewmodel.LoginViewModel

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        requireActivity().setTitle("登入頁面")
        val viewModel: LoginViewModel by viewModels()
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            viewModel?.uid?.observe(viewLifecycleOwner) {
                inputValid()
            }
            viewModel?.password?.observe(viewLifecycleOwner) {
                inputValid()
            }

            btLoginL.setOnClickListener {
                if (!inputValid()) {
                    return@setOnClickListener
                }
                val bundle = Bundle()
                val uid = viewModel!!.uid.value
                val password = viewModel!!.password.value
                val user = User(uid, password)
                // 可將基本類型或字串放進Bundle
                bundle.putString("uid", uid)
                bundle.putString("password", password)
                // 可將Serializable物件放進Bundle
                bundle.putSerializable("user", user)
                // 將Bundle帶至下一頁
                Navigation.findNavController(it).navigate(
                    R.id.action_loginFragment_to_firstPersonalInfoFragment,
                    bundle
                )
            }

            btForgetPasswordL.setOnClickListener {
                Navigation.findNavController(it).navigate(
                    R.id.action_loginFragment_to_forgetPasswordFragment
                )
            }
        }

    }

    private fun inputValid(): Boolean {
        var valid = true
        with(binding) {
            val uid = viewModel?.uid?.value?.trim()
            val password = viewModel?.password?.value?.trim()
            if (uid == null || uid.isEmpty()) {
                etAccountL.error = getString(R.string.errAccountEmpty)
                valid = false
            }
            if (password == null || password.isEmpty()) {
                etPasswordL.error = getString(R.string.errPasswordEmpty)
                valid = false
            }
        }
        return valid
    }


}