package com.example.vlada_rubezhanskaya_pr.screen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.vlada_rubezhanskaya_pr.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login.onClick {
            //longToast("Вы зашли в одну из категорий нашего магазина")
            startActivity<LoginActivity>()
        }
        signin.onClick{
            startActivity<SignInActivity>()
        }
    }
}

