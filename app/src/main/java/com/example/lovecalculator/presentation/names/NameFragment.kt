package com.example.lovecalculator.presentation.names

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.App
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentNameBinding
import com.example.lovecalculator.viewmodel.LoveViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

    private fun initClickers() {
        binding.ivHistory.setOnClickListener {
            findNavController().navigate(R.id.historyFragment)
        }

        binding.btnCalculate.setOnClickListener {
            viewModel.getLiveLoveData(
                binding.etFname.text.toString(),
                binding.etSname.text.toString()
            ).observe(viewLifecycleOwner){ love->
                App.appDatabase.getDao().insert(love)
                Log.e("ololo","initBtnCalculate: $love")
                findNavController().navigate(R.id.resultFragment, bundleOf(RESULT_KEY to love))
            }

        }
    }

    companion object {
        const val RESULT_KEY = "result"
    }
}