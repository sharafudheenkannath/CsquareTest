package com.example.csquaretest.view.products.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.csquaretest.R
import com.example.csquaretest.view.products.model.Content
import kotlinx.android.synthetic.main.grid_products.view.*

/**
 * Created by Sharafu
 * Created at 07/08/2021
 */
class ProductsAdapter(private val context: Context, private val productList: ArrayList<Content>) :
    RecyclerView.Adapter<ProductsAdapter.Holder>() {

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val view = itemView
        fun bind(data: Content, itemPosition: Int) {

            view.apply {
                tvProductName.text = data.x1
                Glide.with(context).load(data.x4).error(R.drawable.ic_error).into(ivProduct)
                tvValuePack.text = context.resources.getString(R.string.pack_value, data.x7)
                tvValuePrice.text = context.resources.getString(R.string.price_label, data.x2)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.grid_products, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(productList[position], position)
    }

    override fun getItemCount(): Int = productList.size
}