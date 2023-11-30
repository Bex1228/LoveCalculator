package com.example.lovecalculator.presentation.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.data.Pref
import com.example.lovecalculator.databinding.ActivityMainBinding
import com.example.lovecalculator.databinding.FragmentNameBinding
import com.example.lovecalculator.databinding.FragmentOnBoardBinding
import com.example.lovecalculator.presentation.onboard.adapter.OnBoardAdapter
import me.relex.circleindicator.CircleIndicator3
import javax.inject.Inject

class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding

    private lateinit var adapter: OnBoardAdapter
    @Inject
    lateinit var pref: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(layoutInflater)
        pref = Pref(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = OnBoardAdapter(this::onClick)
        binding.viewPager.adapter = adapter
        setIndicator()
        if (pref.isUserSeen()){
            findNavController().navigate(R.id.nameFragment)
        }
    }

    private fun setIndicator() {
        val indicator: CircleIndicator3 = binding.indicator
        val viewPager = binding.viewPager
        indicator.setViewPager(viewPager)
    }

    private fun onClick() {
        pref.saveUserSeen()
        findNavController().navigate(R.id.onBoardFragment)
    }
}