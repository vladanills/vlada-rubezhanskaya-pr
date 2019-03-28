package com.example.vlada_rubezhanskaya_pr

import android.content.Context
import kotlinx.serialization.json.Json
import kotlinx.serialization.list
import org.kodein.di.direct
import org.kodein.di.generic.instance

class CategoryPresenter(
    val categoriesListUrl: String,
    val view: CategoryView
){
    val requestMaker = di.direct.instance<RequestMaker>()
    fun onAppear(){
        requestMaker.make(
            categoriesListUrl,
            onResult = { categoriesJson ->
                val categories = Json.parse(Categoryprod.serializer().list, categoriesJson)
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
    fun displayCategories(categories: List<Categoryprod>)
    fun showExitAlert()
    fun displayError()
}