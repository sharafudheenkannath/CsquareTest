package com.example.csquaretest.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.csquaretest.data.api.ApiClient
import com.example.csquaretest.data.networkmodel.NetworkResult
import com.example.csquaretest.view.categories.model.CategoriesRequestDataModel
import com.example.csquaretest.view.categories.model.CategoriesResponseDataModel
import com.example.csquaretest.view.products.model.ProductsRequestDataModel
import com.example.csquaretest.view.products.model.ProductsResponseDataModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

/**
 * Created by Sharafu
 * Created at 07/08/2021
 */
class AppRepo {

    companion object {
        fun getInstance() = AppRepo()
    }

    val categoriesResult = MutableLiveData<NetworkResult<CategoriesResponseDataModel>>()
    val productsResult = MutableLiveData<NetworkResult<ProductsResponseDataModel>>()

    fun getCategories() {

        categoriesResult.postValue(NetworkResult.loading())
        val reqData = CategoriesRequestDataModel()
        ApiClient.instance?.apiService?.getCategories(reqData)
            ?.enqueue(object : Callback<CategoriesResponseDataModel> {
                override fun onResponse(
                    call: Call<CategoriesResponseDataModel>,
                    response: Response<CategoriesResponseDataModel>
                ) {
                    if (response.body() == null) {
                        categoriesResult.postValue(NetworkResult.error("Null data found"))
                    } else {
                        categoriesResult.postValue(NetworkResult.success(response.body()!!))
                    }
                }

                override fun onFailure(call: Call<CategoriesResponseDataModel>, t: Throwable) {
                    Timber.d("getCategories Api error -> ${t.message.toString()}")
                    categoriesResult.postValue(NetworkResult.error(t.message.toString()))
                }

            })
    }

    fun getProducts(headCode: String) {

        productsResult.postValue(NetworkResult.loading())
        val reqData = ProductsRequestDataModel(headCode = headCode)
        ApiClient.instance?.apiService?.getProducts(reqData)
            ?.enqueue(object : Callback<ProductsResponseDataModel> {
                override fun onResponse(
                    call: Call<ProductsResponseDataModel>,
                    response: Response<ProductsResponseDataModel>
                ) {
                    if (response.body() == null) {
                        productsResult.postValue(NetworkResult.error("Null data found"))
                    } else {
                        productsResult.postValue(NetworkResult.success(response.body()!!))
                    }
                }

                override fun onFailure(call: Call<ProductsResponseDataModel>, t: Throwable) {
                    Timber.d("getProducts Api error -> ${t.message.toString()}")
                    productsResult.postValue(NetworkResult.error(t.message.toString()))
                }

            })
    }

}