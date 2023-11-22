package com.example.lovecalculator.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentNameBinding
import com.example.lovecalculator.ui.LoveView
import com.example.lovecalculator.ui.Presenter
import com.example.lovecalculator.ui.model.LoveModel


class NameFragment : Fragment(), LoveView {

    private lateinit var binding: FragmentNameBinding

    private val presenter = Presenter(this)

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
            presenter.getLove(etFname.text.toString(), etSname.text.toString())
        }
    }

    override fun showResponse(loveModel: LoveModel) {
        findNavController().navigate(R.id.resultFragment, bundleOf(RESULT_KEY to loveModel))
    }

    override fun showError(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val RESULT_KEY = "result"
    }
}