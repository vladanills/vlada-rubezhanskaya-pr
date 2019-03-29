package com.example.vlada_rubezhanskaya_pr

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.categories_books.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class CategoriesBooks : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.categories_books)
        vPictureFiction.onClick {
            val intent = Intent(this@CategoriesBooks, FictionCategory::class.java)
            startActivity(intent)
        }
        // с маленькой буквы. Можно еще что-то типа picture_not_fiction / pictureNotFiction ...
        vPictureNotFiction.onClick {
            val intent = Intent(this@CategoriesBooks, NotFictionCategory::class.java)
            startActivity(intent)
        }

        // Если без anko:
        vPictureFiction.setOnClickListener {
            // action
        }
        // полная запись испоьзования метода выше:
        vPictureFiction.setOnClickListener(
            object : View.OnClickListener {
                override fun onClick(v: View?) {
                    // action
                }
            }
        )
    }

    // вариант без анко, в разметке прописан атрибут onClick
    fun onPictureFictionClicked(view: View) {
        // action
    }
}
