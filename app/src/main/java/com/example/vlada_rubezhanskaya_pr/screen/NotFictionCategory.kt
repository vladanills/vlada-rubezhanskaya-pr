package com.example.vlada_rubezhanskaya_pr.screen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.vlada_rubezhanskaya_pr.KEY_PRODUCTS_URL
import com.example.vlada_rubezhanskaya_pr.R
import kotlinx.android.synthetic.main.activity_not_fiction_category.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class NotFictionCategory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_not_fiction_category)
        cs.onClick{
            val intent = Intent(this@NotFictionCategory, ProductsActivity::class.java)
            intent.putExtra(
                KEY_PRODUCTS_URL,
                "https://gist.githubusercontent.com/vladanills/dc88cb09964f108b284c4f8be8631aac/" +
                        "raw/9fba8c42984732c639daba94f55980cb6b75569d/books.json"
            )
            startActivity(intent)
        }
    }
}
