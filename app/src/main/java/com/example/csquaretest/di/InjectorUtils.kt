package com.example.csquaretest.di

import android.content.Context
import com.example.csquaretest.data.repository.AppRepo
import com.example.csquaretest.view.categories.CategoriesViewModelFactory
import com.example.csquaretest.view.products.ProductsViewModelFactory


/**
 * Static methods used to inject classes needed for various Activities and Fragments.
 */
object InjectorUtils {

    fun provideCategoriesViewModelFactory(): CategoriesViewModelFactory {
        return CategoriesViewModelFactory(AppRepo.getInstance())
    }

    fun provideProductsViewModelFactory(): ProductsViewModelFactory {
        return ProductsViewModelFactory(AppRepo.getInstance())
    }
}