package com.wils.efarmermarket.ui.carDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionScene
import androidx.recyclerview.widget.RecyclerView
import com.wils.efarmermarket.R
import com.wils.efarmermarket.model.SelectCart
import com.wils.efarmermarket.model.SelectItem
import kotlinx.android.synthetic.main.cart_list.view.*

class CartDetailsListAdaptor(
    var listData:ArrayList<SelectCart>
) :RecyclerView.Adapter<CartDetailsListAdaptor.HomePageItemListHolder>(){


    inner class HomePageItemListHolder constructor(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageItemListHolder {
        return HomePageItemListHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.cart_list,parent,false
                )
        )
    }

    override fun onBindViewHolder(holder: HomePageItemListHolder, position: Int) {
        val model = listData[holder.adapterPosition]

        holder.itemView.apply {
            Pname.text = model.cartDetails.itemName
            Pqty.text = model.cartDetails.qty.toString()
            Pprice.text = model.cartDetails.discription
            Ptotal.text = model.totalPrice.toString()
        }
    }

    override fun getItemCount() = listData.size
}