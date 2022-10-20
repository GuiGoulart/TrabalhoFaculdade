package com.severo.trabalho_arquiterura_sistema.presentation.home.doctor.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.severo.trabalho_arquiterura_sistema.data.model.Client
import com.severo.trabalho_arquiterura_sistema.util.OnEventItemClick
import javax.inject.Inject

class HomeReceptionistAdapter @Inject constructor(
    private val onItemClick: OnEventItemClick<Client>
) : ListAdapter<Client, HomeReceptionistViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeReceptionistViewHolder {
        return HomeDoctorViewHolder.create(parent, onItemClick)
    }

    override fun onBindViewHolder(holder: HomeReceptionistViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Client>() {
            override fun areItemsTheSame(
                oldItem: Client,
                newItem: Client
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: Client,
                newItem: Client
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}