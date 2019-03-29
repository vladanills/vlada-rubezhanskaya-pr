package com.example.vlada_rubezhanskaya_pr

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_products.*
import org.jetbrains.anko.longToast

class ProductsActivity : ProductsView, AppCompatActivity() {

    override fun repeat() {

    }

    private lateinit var presenter: ProductsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val productsUrl = intent.getStringExtra(KEY_PRODUCTS_URL)
        // Можно так заменить, чтобы руками не писать разные теги
        Log.d(javaClass.name,"products url is $productsUrl")
        presenter = ProductsPresenter(productsUrl, view = this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onAppear()
    }

    override fun displayProducts(products: List<Product>) {
       productsListView.adapter = ProductsAdapter(products, this@ProductsActivity)
    }

    // Взыть из ресурсов
    override  fun displayError(){
        longToast("Произошла ошибка")
    }

}


