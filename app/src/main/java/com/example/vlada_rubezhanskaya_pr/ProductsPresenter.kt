package com.example.vlada_rubezhanskaya_pr

import kotlinx.serialization.json.Json
import kotlinx.serialization.list
import org.kodein.di.direct
import org.kodein.di.generic.instance

class ProductsPresenter(
    private val productsUrl: String,
    private val view: ProductsView
) {

    private val requestMaker = di.direct.instance<RequestMaker>()

    fun onAppear() {
        requestMaker.make(
            productsUrl,
            onResult = { productsJson ->
                val products = Json.parse(Product.serializer().list, productsJson)
                view.displayProducts(products)
            },
            onError = {
                view.displayError()
            }
        )
    }

//    fun onReturn() {
//        view.showExitAlert()
//    }
}

interface ProductsView {
    fun displayProducts(products: List<Product>)

//    fun showExitAlert()

    fun displayError()

    fun repeat()
}
