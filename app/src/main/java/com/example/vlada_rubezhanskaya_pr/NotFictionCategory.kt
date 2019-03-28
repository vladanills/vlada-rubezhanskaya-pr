package com.example.vlada_rubezhanskaya_pr

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fiction_category.*
import kotlinx.android.synthetic.main.not_fiction_category.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class NotFictionCategory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.not_fiction_category)
        cs.onClick{
            val intent = Intent(this@NotFictionCategory,ProductsActivity::class.java)
            intent.putExtra("productsUrl", "https://gist.githubusercontent.com/vladanills/dc88cb09964f108b284c4f8be8631aac/raw/9fba8c42984732c639daba94f55980cb6b75569d/books.json");
            startActivity(intent)
        }
    }
}
