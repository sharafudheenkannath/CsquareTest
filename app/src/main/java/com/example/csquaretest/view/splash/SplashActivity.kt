package com.example.csquaretest.view.splash

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.csquaretest.R
import com.example.csquaretest.base.BaseActivity
import com.example.csquaretest.view.categories.CategoriesActivity
/**
 * Created by Sharafu
 * Created at 07/08/2021
 */
@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            CategoriesActivity.start(this)
        }, 1000)
    }

    override fun getLayoutId(): Int =R.layout.activity_splash

    override fun setupUI() {

    }

    override fun setupObservers() {

    }

    override fun setupArguments() {

    }
}