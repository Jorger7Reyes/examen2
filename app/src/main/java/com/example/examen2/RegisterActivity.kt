package com.example.examen2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.examen2.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginTV.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        binding.createAccountBtn.setOnClickListener{
            val email = binding.emailRegister.text.toString()
            val password = binding.passwordRegister.text.toString()
            if(email.isNotEmpty() && password.isNotEmpty())
                MainActivity.auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                    if(it.isSuccessful){
                        startActivity(Intent(this, LoginActivity::class.java))
                        finish()
                    }
                }.addOnFailureListener{
                    Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
                }
        }
    }
}