package com.wils.efarmermarket

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.provider.MediaStore
import java.io.ByteArrayOutputStream
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStream
import java.text.SimpleDateFormat
import java.util.*


class Utils {
    companion object{

        @SuppressLint("SimpleDateFormat")
        fun dateFormatChange(formater:String,date:Date):String{
            val sdf = SimpleDateFormat(formater)
            return sdf.format(date)
        }


        fun getImageUri(inContext: Context, inImage: Bitmap): Uri? {
            val bytes = ByteArrayOutputStream()
            inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
            val path = MediaStore.Images.Media.insertImage(
                inContext.contentResolver,
                inImage,
                "Title",
                null
            )
            return Uri.parse(path)
        }

        @Throws(FileNotFoundException::class, IOException::class)
        fun getBitmap(cr: ContentResolver, url: Uri?): Bitmap {
            val input: InputStream? = cr.openInputStream(url!!)
            val bitmap = BitmapFactory.decodeStream(input)
            input?.close()
            return bitmap
        }
    }
}