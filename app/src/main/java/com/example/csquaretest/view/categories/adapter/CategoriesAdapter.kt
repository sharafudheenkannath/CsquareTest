package com.example.csquaretest.view.categories.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.csquaretest.R
import com.example.csquaretest.view.categories.model.Content
import kotlinx.android.synthetic.main.grid_categories.view.*

/**
 * Created by Sharafu
 * Created at 07/08/2021
 */
class CategoriesAdapter(
    private val context: Context,
    private val categoryList: ArrayList<Content>,
    private val listener: CategoriesAdapterListener
) : RecyclerView.Adapter<CategoriesAdapter.Holder>() {

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val view = itemView
        fun bind(data: Content, itemPosition: Int) {

            view.apply {
                Glide.with(context).load(data.c_image).error(R.drawable.ic_error).into(ivCategory)
                tvCategoryName.text = data.c_name
                setOnClickListener {
                    listener.onCategoryClicked(data.c_code)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.grid_categories, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(categoryList[position], position)
    }

    override fun getItemCount(): Int = categoryList.size

    interface CategoriesAdapterListener {
        fun onCategoryClicked(headCode: String)
    }
}