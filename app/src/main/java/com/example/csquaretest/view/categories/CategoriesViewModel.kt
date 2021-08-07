package com.example.csquaretest.view.categories

import androidx.lifecycle.ViewModel
import com.example.csquaretest.data.repository.AppRepo

/**
 * Created by Sharafu
 * Created at 07/08/2021
 */
class CategoriesViewModel(repo: AppRepo) : ViewModel() {

    val categoriesResult = repo.categoriesResult

    init {
        repo.getCategories()
    }

}