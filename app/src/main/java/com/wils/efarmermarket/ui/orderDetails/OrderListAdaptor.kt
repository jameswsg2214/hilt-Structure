package com.wils.efarmermarket.ui.orderDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionScene
import androidx.recyclerview.widget.RecyclerView
import com.wils.efarmermarket.R
import com.wils.efarmermarket.Utils
import com.wils.efarmermarket.model.ItemDetails
import com.wils.efarmermarket.model.SelectItem
import com.wils.efarmermarket.model.SelectOrder
import kotlinx.android.synthetic.main.admin_order_card.view.*

class OrderListAdaptor(
    var listData:ArrayList<SelectOrder>,
    val onClick: (SelectOrder) -> Unit
) :RecyclerView.Adapter<OrderListAdaptor.HomePageItemListHolder>(){


    inner class HomePageItemListHolder constructor(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageItemListHolder {
        return HomePageItemListHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.admin_order_card,parent,false
                )
        )
    }

    override fun onBindViewHolder(holder: HomePageItemListHolder, position: Int) {
        val model = listData[holder.adapterPosition]

        holder.itemView.apply {
            orderName.text = model.orderDetails.user_name
            orderstatus.text = model.orderStatus
            orderTotal.text = model.orderDetails.priceDescription
//            orderDate.text = model.orderDetails.orderDate.toString()
            orderDate.text = Utils.dateFormatChange("dd MMM yyyy", model.orderDetails.orderDate!!)
        }

        holder.itemView.setOnClickListener {

            onClick(model)
        }
    }

    override fun getItemCount() = listData.size
}