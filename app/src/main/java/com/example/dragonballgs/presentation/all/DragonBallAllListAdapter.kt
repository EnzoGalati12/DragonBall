package com.example.dragonballgs.presentation.all

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dragonballgs.databinding.ActivityAllItemBinding
import com.example.dragonballgs.databinding.DragonHistoryItemBinding
import com.example.dragonballgs.domain.model.DragonBall

class DragonBallAllListAdapter : RecyclerView.Adapter<DragonBallAllListAdapter.DragonBallAllViewHolder>() {

    private var dragons: List<DragonBall> = emptyList()

    class DragonBallAllViewHolder(val binding: ActivityAllItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragonBallAllViewHolder {
        val binding = ActivityAllItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DragonBallAllViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DragonBallAllViewHolder, position: Int) {
        val currentDragon = dragons[position]

        holder.binding.tvLinhaA.text = "${currentDragon.name}"
        holder.binding.tvLinhaB.text = currentDragon.ki

        Glide.with(holder.itemView.context)
            .load(currentDragon.image)
            .into(holder.binding.dragonImage)
    }

    override fun getItemCount() = dragons.size

    fun setDragons(dragons: List<DragonBall>) {
        this.dragons = dragons
        notifyDataSetChanged()
    }
}
