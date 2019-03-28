package com.example.vlada_rubezhanskaya_pr

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.signin.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.sdk27.coroutines.onClick

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin)
        signin_sigin.onClick {
            registrationUser()

        }
    }

    private fun registrationUser() {
        val email = editText_email_siqnin.text.toString()
        val password = editText_password_siqnin.text.toString()
        Log.d("LoginActivity", "email is " + email)
        Log.d("LoginActivity", "password is " + password)
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
                Log.d("SiqnIn", "Пользователь успешно добавлен с uid ${it.result.user.uid}")
            }
            .addOnFailureListener {
                longToast("Введите корректные данные")
            }
    }
}


