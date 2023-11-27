package com.example.lovecalculator.presentation.names

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentNameBinding
import com.example.lovecalculator.viewmodel.LoveViewModel


class NameFragment : Fragment() {

    private lateinit var binding: FragmentNameBinding

    private val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() = with(binding) {
        btnCalculate.setOnClickListener {
            viewModel.getLiveLoveData(
                etFname.text.toString(),
                etSname.text.toString()
            ).observe(viewLifecycleOwner, Observer {
                findNavController().navigate(R.id.resultFragment, bundleOf(RESULT_KEY to it))
            })
        }
    }

    companion object {
        const val RESULT_KEY = "result"
    }
}