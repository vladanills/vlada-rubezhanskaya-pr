package com.example.vlada_rubezhanskaya_pr.screen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.vlada_rubezhanskaya_pr.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.acitivity_sign_in.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.sdk27.coroutines.onClick

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivity_sign_in)
        signin_sigin.onClick {
            registrationUser()

        }
    }

    private fun registrationUser() {
        val email = editText_email_siqnin.text.toString()
        val password = editText_password_siqnin.text.toString()
        Log.d(javaClass.name, "email is $email")
        Log.d("LoginActivity", "password is $password")
        // Взять из ресурсов
        if (email.isEmpty() || (password.isEmpty())) {
            longToast("Пожалуйста введите e-mail и пароль")
            return
        }
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (!it.isSuccessful)
                    return@addOnCompleteListener
                val intent = Intent(this@SignInActivity, CategoryActivity::class.java)
                startActivity(intent)
                //Log.d("SiqnIn", "Пользователь успешно добавлен с uid ${it.result.user.uid}")
            }
            .addOnFailureListener {
                // Вынести в ресурсы
                longToast("Введите корректные данные")
            }
    }
}


