package com.example.csquaretest.view.categories.model

data class CategoriesResponseDataModel(
    val HEAD: HEAD
)

data class HEAD(
    val content: List<Content>,
    val message: String,
    val status: Int
)

data class Content(
    val c_code: String,
    val c_image: String,
    val c_name: String
)