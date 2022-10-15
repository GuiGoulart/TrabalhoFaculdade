package com.severo.trabalho_arquiterura_sistema.presentation.home.doctor.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.severo.trabalho_arquiterura_sistema.data.model.Client
import com.severo.trabalho_arquiterura_sistema.databinding.ItemClientBinding
import com.severo.trabalho_arquiterura_sistema.util.OnEventItemClick

class HomeDoctorViewHolder(
    itemEventsBinding: ItemClientBinding,
    private val onItemClick: OnEventItemClick<Client>
) : RecyclerView.ViewHolder(itemEventsBinding.root) {

    private val textTitle = itemEventsBinding.textTitle
    private val textDescription = itemEventsBinding.textDescription
    private val textDate = itemEventsBinding.textDate
    private val textHour = itemEventsBinding.textHour

    fun bind(user: Client) {
        textTitle.text = user.title
        textDescription.text = user.description
        textDate.text = user.date
        textHour.text = user.hour

        itemView.setOnClickListener {
            onItemClick.invoke(user)
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            onItemClick: OnEventItemClick<Client>
        ): HomeDoctorViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val itemBinding = ItemClientBinding.inflate(inflater, parent, false)
            return HomeDoctorViewHolder(itemBinding, onItemClick)
        }
    }
}