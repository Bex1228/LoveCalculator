package com.example.lovecalculator.presentation.onboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.ItemOnBoardBinding
import com.example.lovecalculator.model.OnBoardModel

class OnBoardAdapter(private val onClick: () -> Unit) :
    RecyclerView.Adapter<OnBoardAdapter.OnBoardViewHolder>() {

    private val list = arrayListOf(
        OnBoardModel(
            "Have a good time",
            "You should take the time to help those who need you",
            R.drawable.img_ob2
        ),
        OnBoardModel(
            "Cherishing love",
            "It is now no longer possible for you to cherish love",
            R.drawable.img_ob3
        ),
        OnBoardModel(
            "Have a break up?",
            "We have made the correction for you don't worry. Maybe someone is waiting for you",
            R.drawable.img_ob4
        ),
        OnBoardModel(
            "It's Funs and Many more", "",
            R.drawable.img_ob1
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardViewHolder {
        return OnBoardViewHolder(
            ItemOnBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class OnBoardViewHolder(private val binding: ItemOnBoardBinding) :
        ViewHolder(binding.root) {

        fun bind(onBoard: OnBoardModel) {
            binding.apply {
                imgBoard.setImageResource(onBoard.img)
                tvTitle.text = onBoard.title
                tvDesc.text = onBoard.desc
            }
            binding.btnStart.isVisible = adapterPosition == list.lastIndex
            binding.btnStart.setOnClickListener {
                onClick()
            }
        }
    }
}