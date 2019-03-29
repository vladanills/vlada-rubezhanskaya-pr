package com.example.vlada_rubezhanskaya_pr

import kotlinx.serialization.json.Json
import kotlinx.serialization.list
import org.kodein.di.direct
import org.kodein.di.generic.instance

class CategoryPresenter(
    private val categoriesListUrl: String,
    private val view: CategoryView
) {
    private val requestMaker = di.direct.instance<RequestMaker>()

    fun onAppear(){
        requestMaker.make(
            categoriesListUrl,
            onResult = { categoriesJson ->
                val categories = Json.parse(CategoryProd.serializer().list, categoriesJson)
                view.displayCategories(categories)
            },
            onError = {
               view.displayError()
            }
        )
    }

    fun onReturn() {
        view.showExitAlert()
    }
}

interface CategoryView {

    fun displayCategories(categories: List<CategoryProd>)

    fun showExitAlert()

    fun displayError()
}