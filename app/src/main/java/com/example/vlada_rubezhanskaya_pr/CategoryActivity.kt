package com.example.vlada_rubezhanskaya_pr

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.android.synthetic.main.activity_products.*
import kotlinx.android.synthetic.main.category_item.view.*
import kotlinx.android.synthetic.main.product_item.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.list
import okhttp3.OkHttpClient
import okhttp3.Request
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class CategoryActivity :CategoryView, AppCompatActivity() {


    lateinit var presenter: CategoryPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        val categoriesListUrl =
            "https://gist.githubusercontent.com/vladanills/ebca25c95f43e2f617f428010564e965/raw/10e926185ccb7be894fcffb8372ba450bc46c894/category.json"
        presenter = CategoryPresenter(categoriesListUrl, view = this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onAppear()
    }

    override fun displayCategories(categories: List<Categoryprod>){
        productsCategoryView.adapter = CategoriesAdapter(categories, this@CategoryActivity)
    }
    override fun onBackPressed() {
        presenter.onReturn()
    }
    override fun displayError() {
        longToast("Произошла ошибка") //To change body of created functions use File | Settings | File Templates.
    }
    override fun showExitAlert() {
        alert("Вы действительно хотите выйти?") {
            yesButton { dialog ->
                super.onBackPressed()
            }
            noButton { dialog ->
            }
        }.show()
    }
}



