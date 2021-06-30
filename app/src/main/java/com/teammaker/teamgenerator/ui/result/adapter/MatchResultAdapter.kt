package com.teammaker.teamgenerator.ui.result.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teammaker.teamgenerator.R
import com.teammaker.teamgenerator.domain.model.MatchTeam

class MatchResultAdapter(val result:List<Pair<MatchTeam, MatchTeam>>)  : RecyclerView.Adapter<MatchResultViewHolder>() {

    override fun onBindViewHolder(holder: MatchResultViewHolder, position: Int) {
        val item = result[position]
        holder.render(item)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchResultViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MatchResultViewHolder(layoutInflater.inflate(R.layout.item_match_result, parent, false))
    }
    override fun getItemCount(): Int {
        return result.size
    }
}