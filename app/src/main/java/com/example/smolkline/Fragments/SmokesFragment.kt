package com.example.smolkline.Fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smolkline.Classes.Smolk
import com.example.smolkline.R
import com.example.smolkline.adapters.BannerAdapter
import com.example.smolkline.adapters.SmolkAdapter
import com.example.smolkline.databinding.SmokesFragmentBinding


class SmokesFragment : Fragment(R.layout.smokes_fragment) {

 private val handler = Handler(Looper.getMainLooper())
 private var currentPage = 0

 private val bannerRunnable = object : Runnable {
  override fun run() {
   if (_binding == null) return

   val adapter = binding.viewPagerBanner.adapter ?: return
   val total = adapter.itemCount

   if(total == 0 ) return

   binding.viewPagerBanner.setCurrentItem(currentPage, true)
   currentPage = (currentPage + 1 ) % total

   handler.postDelayed(this, 3000)
  }
 }

 private var _binding: SmokesFragmentBinding? = null
 private val binding get() = _binding!!

 override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
  super.onViewCreated(view, savedInstanceState)

  _binding = SmokesFragmentBinding.bind(view)

  val lista = listOf(
   Smolk(
    "Bomb B Smolk Miragem",
    "Smolk CT",

    R.drawable.smolk_icon
   ),

   Smolk(
    "Bomb A Smolk",
    "Smolk Cabecinha",
    R.drawable.cabecinha
   )
  )

  binding.recyclerSmolk.layoutManager =
   LinearLayoutManager(requireContext())

  binding.recyclerSmolk.adapter =
   SmolkAdapter(lista)

   val listaBanners = listOf(
    R.drawable.infbanner,
    R.drawable.mirabanner,
    R.drawable.miragebanner,

   )
  binding.viewPagerBanner.adapter = BannerAdapter(listaBanners)
  handler.postDelayed(bannerRunnable, 3000)


 }


 override fun onDestroyView() {
  super.onDestroyView()
  handler.removeCallbacks(bannerRunnable)
  _binding = null
 }
}


