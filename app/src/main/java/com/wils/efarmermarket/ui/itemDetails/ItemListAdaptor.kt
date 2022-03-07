package com.wils.efarmermarket.ui.itemDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionScene
import androidx.recyclerview.widget.RecyclerView
import com.wils.efarmermarket.R
import com.wils.efarmermarket.model.ItemDetails
import kotlinx.android.synthetic.main.listed_item.view.*

class ItemListAdaptor(
    var listData: ArrayList<ItemDetails>,
    val onClickDelete: (ItemDetails) -> Unit,
    val onClickEdit: (ItemDetails) -> Unit

) :RecyclerView.Adapter<ItemListAdaptor.HomePageItemListHolder>(){


    inner class HomePageItemListHolder constructor(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageItemListHolder {
        return HomePageItemListHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.listed_item,parent,false
                )
        )
    }

    override fun onBindViewHolder(holder: HomePageItemListHolder, position: Int) {

        val model = listData[holder.adapterPosition]
        holder.itemView.apply {
            title.text = model.itemName?:""
            cost.text = model.discription?:""

            delete_item.setOnClickListener {
                onClickDelete(model)
            }
            edit_item.setOnClickListener {
                onClickEdit(model)
            }
        }

        if (model.image!= null){

            holder.itemView.image.setImageURI(model.image)
        }
    }

    override fun getItemCount() = listData.size
}