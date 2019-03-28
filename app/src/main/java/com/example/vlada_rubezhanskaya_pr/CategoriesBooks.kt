package com.example.vlada_rubezhanskaya_pr

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.categories_books.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class CategoriesBooks : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.categories_books)
        PictureFiction.onClick {
            val intent = Intent(this@CategoriesBooks, FictionCategory::class.java)
            startActivity(intent)
        }
        PictureNotFiction.onClick {
            val intent = Intent(this@CategoriesBooks, NotFictionCategory::class.java)
            startActivity(intent)
        }
    }
}
