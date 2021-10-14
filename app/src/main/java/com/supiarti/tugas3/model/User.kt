package com.supiarti.tugas3.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    val name : String,
    val email : String,
    val umur : String,
    ) : Parcelable

