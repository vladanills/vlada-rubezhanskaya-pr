package com.example.vlada_rubezhanskaya_pr

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.login.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.sdk27.coroutines.onClick

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        login_login.onClick {
            login_user()
        }
    }
    private fun login_user(){val email = editText_email.text.toString()
        val password = editText_password.text.toString()
//            Log.d("LoginActivity", "email is " + email)
//            Log.d("LoginActivity", "password is " + password)
        if (email.isEmpty() || (password.isEmpty())) {
            longToast("Пожалуйста введите e-mail и пароль")
            return
        }
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if(!it.isSuccessful)
                    return@addOnCompleteListener
                val intent = Intent(this@LoginActivity,CategoryActivity::class.java)
                startActivity(intent)
            }
            .addOnFailureListener {
                longToast("Введите корректные данные")
            }

    }
}
