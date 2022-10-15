package com.severo.trabalho_arquiterura_sistema.presentation.home.detail.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.severo.trabalho_arquiterura_sistema.data.model.HistoricClient
import com.severo.trabalho_arquiterura_sistema.util.OnEventItemClick
import javax.inject.Inject

class DetailClientAdapter @Inject constructor(
    private val onItemClick: OnEventItemClick<Boolean>
) : ListAdapter<HistoricClient, DetailClientViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailClientViewHolder {
        return DetailClientViewHolder.create(parent, onItemClick)
    }

    override fun onBindViewHolder(holder: DetailClientViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<HistoricClient>() {
            override fun areItemsTheSame(
                oldItem: HistoricClient,
                newItem: HistoricClient
            ): Boolean {
                return oldItem.description == newItem.description
            }

            override fun areContentsTheSame(
                oldItem: HistoricClient,
                newItem: HistoricClient
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}