package com.example.csquaretest.view.products.model

data class ProductsRequestDataModel(
    val c2code: String = "UAT0C1",
    val endLimit: String = "50",
    val fun_name: String = "HEADITEMLIST",
    val headCode: String,
    val idx: String = "100",
    val res_format: String = "1",
    val startLimit: String = "0"
)