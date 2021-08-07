package com.example.csquaretest.view.products

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.csquaretest.R
import com.example.csquaretest.base.BaseActivity
import com.example.csquaretest.data.constants.AppConstants
import com.example.csquaretest.data.networkmodel.NetworkResult
import com.example.csquaretest.di.InjectorUtils
import com.example.csquaretest.view.loader.LottieDialogFragment
import com.example.csquaretest.view.products.adapter.ProductsAdapter
import com.example.csquaretest.view.products.model.Content
import kotlinx.android.synthetic.main.activity_products.*

/**
 * Created by Sharafu
 * Created at 07/08/2021
 */
class ProductsActivity : BaseActivity() {

    companion object {
        private const val PARAM_HEAD_CODE = "head_code"

        fun start(context: Context, headCode: String) {
            val intent = Intent(context, ProductsActivity::class.java)
            intent.putExtra(PARAM_HEAD_CODE, headCode)
            context.startActivity(intent)
        }
    }

    private lateinit var loaderDialog: LottieDialogFragment
    private lateinit var headCode: String
    private lateinit var productsAdapter: ProductsAdapter
    private val productsList = ArrayList<Content>()
    private val viewModel: ProductsViewModel by viewModels {
        InjectorUtils.provideProductsViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loaderDialog = LottieDialogFragment.newInstance()
        viewModel.getProducts(headCode)
        setupObservers()
    }

    override fun getLayoutId(): Int = R.layout.activity_products

    override fun setupUI() {

        productsAdapter = ProductsAdapter(this, productsList)
        rvProducts.adapter = productsAdapter
    }

    override fun setupObservers() {
        viewModel.productsResult.observe(this, {
            when (it.status) {
                NetworkResult.Status.LOADING -> {
                    loaderDialog.show(supportFragmentManager, "")
                }
                NetworkResult.Status.SUCCESS -> {
                    loaderDialog.dismiss()
                    if (it.data == null) {
                        showToast("Null data found")
                    } else {
                        if (it.data.HEADITEMLIST.message == AppConstants.API_STATUS.SUCCESS) {
                            productsList.clear()
                            productsList.addAll(it.data.HEADITEMLIST.content)
                            productsAdapter.notifyDataSetChanged()
                        } else {
                            showToast(it.data.HEADITEMLIST.message)
                        }
                    }
                }
                NetworkResult.Status.ERROR -> {
                    loaderDialog.dismiss()
                    showToast(it.message!!)
                }
            }
        })
    }

    override fun setupArguments() {
        headCode = intent.getStringExtra(PARAM_HEAD_CODE).toString()
    }
}