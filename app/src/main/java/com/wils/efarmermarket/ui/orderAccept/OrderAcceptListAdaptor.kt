package com.wils.efarmermarket.ui.orderAccept

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionScene
import androidx.recyclerview.widget.RecyclerView
import com.wils.efarmermarket.R
import com.wils.efarmermarket.Utils
import com.wils.efarmermarket.model.*
import kotlinx.android.synthetic.main.order_card.view.*

class OrderAcceptListAdaptor(
    var listData:ArrayList<SelectDispathchData>,
    val onClick: (SelectDispathchData) -> Unit
) :RecyclerView.Adapter<OrderAcceptListAdaptor.HomePageItemListHolder>(){


    inner class HomePageItemListHolder constructor(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageItemListHolder {
        return HomePageItemListHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.order_card,parent,false
                )
        )
    }

    override fun onBindViewHolder(holder: HomePageItemListHolder, position: Int) {
        val model = listData[holder.adapterPosition]

        holder.itemView.apply {
            date.text = model.date.toString()
            date.text = Utils.dateFormatChange("dd MMM yyyy",model.date)
            name.text = model.itemName
            status.text = model.status
            total.text = model.discription
        }

        holder.itemView.setOnClickListener {

            onClick(model)
        }
    }

    override fun getItemCount() = listData.size
}