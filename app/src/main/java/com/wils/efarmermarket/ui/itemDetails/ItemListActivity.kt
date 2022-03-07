package com.wils.efarmermarket.ui.itemDetails

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.wils.efarmermarket.R
import com.wils.efarmermarket.model.ItemDetails
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_item_list.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class ItemListActivity : AppCompatActivity(),View.OnClickListener {

    lateinit var mAdaptor: ItemListAdaptor
    var listData:ArrayList<ItemDetails> = ArrayList()

    val mViewModel by viewModels<ItemDetailsViewModel>()
    companion object{

        var isEdit:Boolean = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        initObserver()
        initLisiners()
        initAdaptor()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initObserver() {
        mViewModel.getDetails.observe(this){
            listData.clear()
            listData.addAll(it)
            mAdaptor.notifyDataSetChanged()
        }
    }

    private fun initLisiners() {

        addItem.setOnClickListener(this)
    }

    private fun initAdaptor() {
        mAdaptor = ItemListAdaptor(listData,
            onClickDelete = {
                mViewModel.delete(it)
                setData()
            },
            onClickEdit =  {

        }
        )

        adminlistedrecy.adapter = mAdaptor
    }

    override fun onClick(p0: View?) {
        when(p0){
            addItem->{
                isEdit= false
                startActivity(Intent(this,EditItemListActivity::class.java))
            }

        }
    }

    override fun onResume() {
        super.onResume()

        setData()
    }

    private fun setData() {
        mViewModel.getDetails()
    }
}