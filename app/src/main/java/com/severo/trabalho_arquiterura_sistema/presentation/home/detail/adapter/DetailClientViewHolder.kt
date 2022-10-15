package com.severo.trabalho_arquiterura_sistema.presentation.home.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.severo.trabalho_arquiterura_sistema.data.model.HistoricClient
import com.severo.trabalho_arquiterura_sistema.databinding.ItemDetailResultClientBinding
import com.severo.trabalho_arquiterura_sistema.util.OnEventItemClick

class DetailClientViewHolder(
    itemEventsBinding: ItemDetailResultClientBinding,
    private val onItemClick: OnEventItemClick<Boolean>,
) : RecyclerView.ViewHolder(itemEventsBinding.root) {

    private val textDescription = itemEventsBinding.textDescription
    private val textResult = itemEventsBinding.textResult
    private val textDate = itemEventsBinding.textDate
    private val textHour = itemEventsBinding.textHour

    private val buttonDeliverResult = itemEventsBinding.buttonDeliverResult
    private val buttonKeptClinic = itemEventsBinding.buttonKeptClinic

    fun bind(user: HistoricClient) {
        textDescription.text = user.description
        textResult.text = user.result
        textDate.text = user.date
        textHour.text = user.hour

        buttonDeliverResult.setOnClickListener {
            onItemClick.invoke(true)
        }

        buttonKeptClinic.setOnClickListener {
            onItemClick.invoke(false)
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            onItemClick: OnEventItemClick<Boolean>
        ): DetailClientViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val itemBinding = ItemDetailResultClientBinding.inflate(inflater, parent, false)
            return DetailClientViewHolder(itemBinding, onItemClick)
        }
    }
}