package com.grandtask.utils

import android.graphics.drawable.Drawable
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

import androidx.databinding.BindingAdapter
import com.bumptech.glide.request.target.Target

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, thumbnailImage: String) {
    if (thumbnailImage.isNotEmpty()) {
        view.visibility = View.VISIBLE
        Glide.with(view.context)
            .load(thumbnailImage)
            .into(view)
    } else {
        view.visibility = View.GONE
    }
}

data class Article(val title:String, val body:String, val thumbnailImage:String):Parcelable {
   private constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(body)
        parcel.writeString(thumbnailImage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Article> {
        override fun createFromParcel(parcel: Parcel): Article {
            return Article(parcel)
        }

        override fun newArray(size: Int): Array<Article?> {
            return arrayOfNulls(size)
        }
    }
}
