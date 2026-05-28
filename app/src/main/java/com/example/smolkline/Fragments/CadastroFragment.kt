package com.example.smolkline.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.smolkline.R
import com.example.smolkline.databinding.CadastroFragmentBinding

class CadastroFragment : Fragment(R.layout.cadastro_fragment) {

    private var _binding: CadastroFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = CadastroFragmentBinding.bind(view)

        requireActivity()
            .findViewById<View>(R.id.buttomNav_View)
            .visibility = View.GONE

        binding.txtLogin.setOnClickListener {
            findNavController().navigate(R.id.action_cadastroFragment_to_homepageFrament)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}