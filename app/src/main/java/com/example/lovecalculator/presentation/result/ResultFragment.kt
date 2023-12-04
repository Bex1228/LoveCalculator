package com.example.lovecalculator.presentation.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentResultBinding
import com.example.lovecalculator.presentation.names.NameFragment.Companion.RESULT_KEY
import com.example.lovecalculator.remote.LoveModel

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        result()
        initListener()
    }

    private fun initListener() {
        binding.btnTryAgain.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.ivHistory.setOnClickListener {
            findNavController().navigate(R.id.historyFragment)
        }
    }

    private fun result() {
        val result = arguments?.getSerializable(RESULT_KEY) as LoveModel
        binding.tvNamef.text = result.sName
        binding.tvNames.text = result.fName
        binding.tvScore.text = result.percentage + "%"
        binding.tvResult.text = result.result
    }
}

