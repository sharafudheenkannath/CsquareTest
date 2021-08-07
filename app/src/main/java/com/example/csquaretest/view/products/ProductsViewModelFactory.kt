package com.example.csquaretest.view.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.csquaretest.data.repository.AppRepo
/**
 * Created by Sharafu
 * Created at 07/08/2021
 */
class ProductsViewModelFactory(private val repo: AppRepo) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductsViewModel(repo) as T
    }
}