package com.example.csquaretest.view.products.model

import com.google.gson.annotations.SerializedName

data class ProductsResponseDataModel(
    val HEADITEMLIST: HEADITEMLIST
)

data class HEADITEMLIST(
    val content: List<Content>,
    val message: String,
    val status: Int
)

data class Content(
    @SerializedName("1")
    val x1: String,
    val `10`: String,
    val `11`: String,
    val `12`: String,
    val `13`: String,
    val `14`: String,
    val `15`: String,
    val `16`: String,
    @SerializedName("2")
    val x2: String,
    val `3`: String,
    @SerializedName("4")
    val x4: String,
    val `5`: String,
    val `6`: String,
    @SerializedName("7")
    val x7: String,
    val `8`: String,
    val `9`: String
)