package com.dicoding.dicodingsubmissionandroidv1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Food(
    val name: String,
    val ingredients: String,
    val photo: Int,
    val preparation: String,
) : Parcelable
