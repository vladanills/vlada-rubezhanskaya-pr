package com.example.vlada_rubezhanskaya_pr

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_item.view.*
import org.jetbrains.anko.layoutInflater

class ProductsAdapter(
    val products: List<Product>,
    val context: Context
) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(recyclerView: ViewGroup, viewType: Int) = run {
        val view = context.layoutInflater.inflate(
            R.layout.product_item,
            recyclerView,
            false
        )
        ViewHolder(view)
    }

    override fun getItemCount(): Int = products.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pr = products.get(position)
        holder.itemView.titleView.text = pr.title
        holder.itemView.titleView2.text = pr.author
        holder.itemView.price.text = pr.price
        Picasso.get()
            .load(pr.imageUrl)
            .into(holder.itemView.pictureView)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
