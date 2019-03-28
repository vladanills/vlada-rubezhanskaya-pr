package com.example.vlada_rubezhanskaya_pr

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_products.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.longToast
import org.jetbrains.anko.noButton
import org.jetbrains.anko.yesButton

class ProductsActivity() :ProductsView, AppCompatActivity() {
    override fun repeate() {

    }

    lateinit var presenter: ProductsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val productsUrl = intent.getStringExtra("productsUrl")
        Log.d("Prod","productsurl is $productsUrl")
        presenter = ProductsPresenter(productsUrl, view = this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onAppear()
    }

    override fun displayProducts(products: List<Product>) {
       productsListView.adapter = ProductsAdapter(products, this@ProductsActivity)
    }

    override  fun displayError(){
        longToast("Произошла ошибка")
    }

}


