package com.example.csquaretest.view.products

import androidx.lifecycle.ViewModel
import com.example.csquaretest.data.repository.AppRepo
/**
 * Created by Sharafu
 * Created at 07/08/2021
 */
class ProductsViewModel(private val repo: AppRepo) : ViewModel() {

    val productsResult = repo.productsResult

    fun getProducts(headCode: String) {
        repo.getProducts(headCode)
    }
}