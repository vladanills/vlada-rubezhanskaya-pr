package com.example.vlada_rubezhanskaya_pr.screen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.vlada_rubezhanskaya_pr.KEY_PRODUCTS_URL
import com.example.vlada_rubezhanskaya_pr.R
import kotlinx.android.synthetic.main.activity_fiction_category.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class FictionCategory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fiction_category)
        sovrprosa.onClick{
            val intent = Intent(this@FictionCategory, ProductsActivity::class.java)
            intent.putExtra(
                KEY_PRODUCTS_URL,
                "https://gist.githubusercontent.com/vladanills/e4a16ea959925c06030be22003295928/" +
                        "raw/fb54fb69cf074a17d0213ed1173f03ff65301e85/modern_prose.json"
            )
            startActivity(intent)
        }
        detect.onClick{
            val intent = Intent(this@FictionCategory, ProductsActivity::class.java)
            intent.putExtra(
                KEY_PRODUCTS_URL,
                "https://gist.githubusercontent.com/vladanills/099eb61db614fd81f8222c53864352e2/" +
                        "raw/5e80c42dd5ffbe019feaf6d00dafe6829dbe22de/detect.json"
            )
            startActivity(intent)
        }
    }
}
