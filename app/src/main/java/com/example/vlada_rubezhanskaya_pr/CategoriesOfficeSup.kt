package com.example.vlada_rubezhanskaya_pr

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.categories_office_sup.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class CategoriesOfficeSup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.categories_office_sup)
        pism.onClick{
            val intent = Intent(this@CategoriesOfficeSup,ProductsActivity::class.java)
            intent.putExtra("productsUrl", "https://gist.githubusercontent.com/vladanills/a9b1c415acea1216d9e3fcf5b07cdc7a/raw/15b29a9948cd8f5f46f51e6b39af17de03e3bfdd/officesupplies.json");
            startActivity(intent)
        }
    }
}
