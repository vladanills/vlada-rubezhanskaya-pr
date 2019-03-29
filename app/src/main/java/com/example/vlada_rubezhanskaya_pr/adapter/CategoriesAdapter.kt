package com.example.vlada_rubezhanskaya_pr.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.vlada_rubezhanskaya_pr.screen.CategoriesBooksActivity
import com.example.vlada_rubezhanskaya_pr.screen.CategoriesOfficeSup
import com.example.vlada_rubezhanskaya_pr.model.CategoryProd
import com.example.vlada_rubezhanskaya_pr.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.category_item.view.*
import org.jetbrains.anko.layoutInflater
import org.jetbrains.anko.sdk27.coroutines.onClick

class CategoriesAdapter(
    val categories: List<CategoryProd>,
    val context: Context
) : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(recyclerView: ViewGroup, viewType: Int) = run {
        val view = context.layoutInflater.inflate(
            R.layout.category_item,
            recyclerView,
            false
        )
        ViewHolder(view)
    }
    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories[position]
        holder.itemView.textCategory.text = category.title
        Picasso.get()
            .load(category.imageUrl)
            .into(holder.itemView.PictureCategory)
        holder.itemView.onClick {
            if (category.title == "Книги") {
                val intent = Intent(context, CategoriesBooksActivity::class.java)
                context.startActivity(intent)
            }
            if (category.title == "Канцтовары") {
                val intent = Intent(context, CategoriesOfficeSup::class.java)
                context.startActivity(intent)
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}