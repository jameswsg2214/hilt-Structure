package com.wils.efarmermarket.ui.homePage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionScene
import androidx.recyclerview.widget.RecyclerView
import com.wils.efarmermarket.R
import com.wils.efarmermarket.model.ItemDetails
import com.wils.efarmermarket.model.SelectItem
import kotlinx.android.synthetic.main.listed_item.view.*
import kotlinx.android.synthetic.main.order_list_adapter_view.view.*
import java.lang.Exception

class HomePageItemListAdaptor(
    var listData:ArrayList<SelectItem>,
    val onClick: (SelectItem) -> Unit
) :RecyclerView.Adapter<HomePageItemListAdaptor.HomePageItemListHolder>(){


    inner class HomePageItemListHolder constructor(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageItemListHolder {
        return HomePageItemListHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.order_list_adapter_view,parent,false
                )
        )
    }

    override fun onBindViewHolder(holder: HomePageItemListHolder, position: Int) {
        val model = listData[holder.adapterPosition]

        holder.itemView.apply {
            productTitle.text = model.itemDetails.itemName
            productDescription.text = model.itemDetails.discription

            add.setOnClickListener {
                model.itemQty=1
                add.visibility= View.GONE
                addQtyView.visibility = View.VISIBLE

                onClick(model)
            }
        }

        if (model.itemDetails.image!= null){

            try {

                holder.itemView.itemImage.setImageURI(model.itemDetails.image)
            }
            catch (e:Exception){


            }
        }
    }

    override fun getItemCount() = listData.size
}