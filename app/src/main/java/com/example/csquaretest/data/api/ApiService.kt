package com.example.csquaretest.data.api


import com.example.csquaretest.view.categories.model.CategoriesRequestDataModel
import com.example.csquaretest.view.categories.model.CategoriesResponseDataModel
import com.example.csquaretest.view.products.model.ProductsRequestDataModel
import com.example.csquaretest.view.products.model.ProductsResponseDataModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * Created by Sharafu
 * Created at 07/08/2021
 */
interface ApiService {

    @Headers("Content-Type: application/json")
    @POST("/lcapi/backend/web/apk/get-commondata")
    fun getCategories(@Body req: CategoriesRequestDataModel): Call<CategoriesResponseDataModel>

    @Headers("Content-Type: application/json")
    @POST("/lcapi/backend/web/apk/get-commondata")
    fun getProducts(@Body req: ProductsRequestDataModel): Call<ProductsResponseDataModel>
}
