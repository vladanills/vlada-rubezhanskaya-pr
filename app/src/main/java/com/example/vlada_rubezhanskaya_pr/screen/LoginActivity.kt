package com.example.vlada_rubezhanskaya_pr.screen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.vlada_rubezhanskaya_pr.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.sdk27.coroutines.onClick

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val auth = FirebaseAuth.getInstance()
        if (auth.currentUser != null) {
            val email = auth.currentUser!!.email
            vLoginInputEmail.setText(email)
//            val intent = Intent(this@LoginActivity, CategoryActivity::class.java)
//            startActivity(intent)
//            finish()
        }
    login_login.onClick()
    {
        login_user()
    }
}

private fun login_user() {
    val email = vLoginInputEmail.text.toString()
    val password = editText_password.text.toString()
//            Log.d("LoginActivity", "email is " + email)
//            Log.d("LoginActivity", "password is " + password)
    if (email.isEmpty() || (password.isEmpty())) {
        longToast(getString(R.string.message_type_password))
        return
    }
    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
        .addOnCompleteListener {
            if (!it.isSuccessful)
                return@addOnCompleteListener
            val intent = Intent(this@LoginActivity, CategoryActivity::class.java)
            startActivity(intent)

        }
        .addOnFailureListener {
            longToast(getString(R.string.message_type_correct_data))
        }

}
}
