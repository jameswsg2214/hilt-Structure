package com.wils.efarmermarket.ui.itemDetails

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.activity.viewModels
import com.wils.efarmermarket.R
import com.wils.efarmermarket.Utils
import com.wils.efarmermarket.model.ItemDetails
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_edititem_list.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.net.URI


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class EditItemListActivity : AppCompatActivity(),View.OnClickListener {

    val mViewModel by viewModels<ItemDetailsViewModel>()

    val REQUEST_CODE = 100
    val REQUEST_CODE_CAPTURE = 200

    var image:Bitmap?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edititem_list)

        setOnClickListener()
        getData()

    }

    private fun setOnClickListener() {
        editPicIcon.setOnClickListener(this)
        saveItem.setOnClickListener(this)
        editPicIconfromGalery.setOnClickListener(this)
    }

    private fun getData() {

        ItemListActivity.isEdit.let {
            if(it!= null){

                if (it){


                }
                else{


                }

            }
        }

    }

    override fun onClick(p0: View?) {
        when(p0){
            saveItem->{

                val itemDetails = ItemDetails(
                    seller_uuid =1,
                    itemName = editTitle.text.toString(),
                    prize = costRs.text.toString(),
                    unit = costUnit.text.toString(),
                    discription =   costRs.text.toString()+" / "+ costUnit.text.toString(),
                    image = image
                )


                mViewModel.insert(itemDetails)

                finish()

            }
            editPicIcon->{
                capturePhoto()

            }
            editPicIconfromGalery->{

                openGalleryForImage()

            }

        }
    }

    fun capturePhoto() {

        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, REQUEST_CODE_CAPTURE)
    }


    private fun openGalleryForImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){
            editimage.setImageURI(data?.data) // handle chosen image
            image = data?.data
        }
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_CAPTURE){
            editimage.setImageBitmap(data?.extras?.get("data") as Bitmap) // handle chosen image

            val data = data?.extras?.get("data") as Bitmap

            image =data
//            val imageVu:Image= data?.extras?.get("data") as Image

        }
    }
}