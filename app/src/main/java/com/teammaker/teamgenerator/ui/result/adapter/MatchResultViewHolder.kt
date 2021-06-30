package com.teammaker.teamgenerator.ui.result.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.teammaker.teamgenerator.databinding.ItemMatchResultBinding
import com.teammaker.teamgenerator.domain.model.MatchTeam

class MatchResultViewHolder  (view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemMatchResultBinding.bind(view)

    fun render(match: Pair<MatchTeam, MatchTeam>){
        if(match.second.team.isNotEmpty()){
            binding.tvMatchResult.text = "Juega ${match.first.team.first().name} vs ${match.second.team.first().name}"
        }else{
            binding.tvMatchResult.text = "${match.first.team.first().name} Pasa automáticamente"
        }
    }
}