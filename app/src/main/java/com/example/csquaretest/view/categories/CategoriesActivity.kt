package com.example.csquaretest.view.categories

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.csquaretest.R
import com.example.csquaretest.base.BaseActivity
import com.example.csquaretest.data.constants.AppConstants.API_STATUS.SUCCESS
import com.example.csquaretest.data.networkmodel.NetworkResult
import com.example.csquaretest.di.InjectorUtils
import com.example.csquaretest.view.categories.adapter.CategoriesAdapter
import com.example.csquaretest.view.categories.model.Content
import com.example.csquaretest.view.loader.LottieDialogFragment
import com.example.csquaretest.view.products.ProductsActivity
import kotlinx.android.synthetic.main.activity_categories.*

/**
 * Created by Sharafu
 * Created at 07/08/2021
 */
class CategoriesActivity : BaseActivity(), CategoriesAdapter.CategoriesAdapterListener {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, CategoriesActivity::class.java)
            context.startActivity(intent)
        }
    }

    private lateinit var loaderDialog: LottieDialogFragment
    private lateinit var categoryAdapter: CategoriesAdapter
    private val categoryList = ArrayList<Content>()
    private val viewModel: CategoriesViewModel by viewModels {
        InjectorUtils.provideCategoriesViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loaderDialog = LottieDialogFragment.newInstance()
        setupObservers()
    }

    override fun getLayoutId(): Int = R.layout.activity_categories

    override fun setupUI() {

        categoryAdapter = CategoriesAdapter(this, categoryList, this)
        rvCategories.adapter = categoryAdapter
    }

    override fun setupObservers() {
        viewModel.categoriesResult.observe(this, Observer {
            when (it.status) {
                NetworkResult.Status.LOADING -> {
                    loaderDialog.show(supportFragmentManager, "")
                }
                NetworkResult.Status.SUCCESS -> {
                        loaderDialog.dismiss()
                    if (it.data == null) {
                        showToast("Null data found")
                    } else {
                        if (it.data.HEAD.message == SUCCESS) {
                            categoryList.clear()
                            categoryList.addAll(it.data.HEAD.content)
                            categoryAdapter.notifyDataSetChanged()
                        } else {
                            showToast(it.data.HEAD.message)
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

    }

    override fun onCategoryClicked(headCode: String) {
        ProductsActivity.start(this, headCode)
    }
}