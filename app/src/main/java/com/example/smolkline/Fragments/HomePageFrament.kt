package com.example.smolkline.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.smolkline.R
import com.example.smolkline.databinding.HomePageBinding

class HomePageFrament : Fragment(R.layout.home_page) {

    private var _binding: HomePageBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = HomePageBinding.bind(view)

        binding.button.alpha = 0f

        binding.button.animate()
            .translationY(8f)
            .setDuration(200)
            .withEndAction {
                binding.button.animate()
                    .translationY(0f)
                    .setDuration(200)
            }

        binding.button.animate()
            .alpha(1f)
            .setDuration(2000)
            .start()

        binding.button.setOnClickListener {

            it.animate()
                .scaleX(0.95f)
                .scaleY(0.95f)
                .setDuration(80)
                .withEndAction {

                    it.animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .setDuration(80)
                        .start()

                    findNavController()
                        .navigate(R.id.action_homepageFrament_to_home_screen)
                }
                .start()

        }

        binding.txtRegister.setOnClickListener {
            findNavController().navigate(
                R.id.action_homePageFragment_to_cadastroFragment
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}