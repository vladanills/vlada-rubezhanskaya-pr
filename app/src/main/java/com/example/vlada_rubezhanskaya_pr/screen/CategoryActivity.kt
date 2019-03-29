package com.example.vlada_rubezhanskaya_pr.screen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.vlada_rubezhanskaya_pr.model.CategoryProd
import com.example.vlada_rubezhanskaya_pr.R
import com.example.vlada_rubezhanskaya_pr.adapter.CategoriesAdapter
import kotlinx.android.synthetic.main.activity_category.*
import org.jetbrains.anko.*

class CategoryActivity : CategoryView, AppCompatActivity() {

    private lateinit var presenter: CategoryPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        val categoriesListUrl =
            "https://gist.githubusercontent.com/vladanills/ebca25c95f43e2f617f428010564e965/" +
                    "raw/10e926185ccb7be894fcffb8372ba450bc46c894/category.json"
        presenter = CategoryPresenter(categoriesListUrl, view = this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onAppear()
    }

    override fun displayCategories(categories: List<CategoryProd>){
        productsCategoryView.adapter =
            CategoriesAdapter(categories, this@CategoryActivity)
    }
    override fun onBackPressed() {
        presenter.onReturn()
    }

    // Сроки должны быть в ресурсах
    override fun displayError() {
        longToast(getString(R.string.error_default)) //To change body of created functions use File | Settings | File Templates.
    }

    // Сроки должны быть в ресурсах
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



