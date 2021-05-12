package com.example.myapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btnSave: Button
    private lateinit var btnClear: Button
    private lateinit var etEmail: EditText
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var etName: EditText
    private lateinit var etSurname: EditText
    private lateinit var etAge: EditText
    private lateinit var etArray: Array<EditText>
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        btnSave = findViewById(R.id.btn_save)
        btnClear = findViewById(R.id.btn_clear)
        etEmail = findViewById(R.id.et_email_address)
        etUsername = findViewById(R.id.et_username)
        etPassword = findViewById(R.id.et_password)
        etConfirmPassword = findViewById(R.id.et_confirm_password)
        etName = findViewById(R.id.et_name)
        etSurname = findViewById(R.id.et_surname)
        etAge = findViewById(R.id.et_age)
        etArray =
            arrayOf(etEmail, etUsername, etPassword, etConfirmPassword, etName, etSurname, etAge)

        btnSave.setOnClickListener {
            validateForm()
        }

        btnClear.setOnLongClickListener {
            clear()
            Toast.makeText(this,"all fields are cleared",Toast.LENGTH_LONG).show()
            true
        }
    }

    private fun validateForm() {
        var result = ""
        if (etEmail.text.toString().trim().matches(emailPattern.toRegex())) {
            etEmail.setBackgroundResource(R.color.success_color)
            etEmail.setTextColor(ContextCompat.getColor(this, R.color.valid_text_color))
            etEmail.setHintTextColor(ContextCompat.getColor(this, R.color.valid_hint_color))
        } else {
            etEmail.setBackgroundResource(R.color.error_color)
            etEmail.setTextColor(ContextCompat.getColor(this, R.color.invalid_text_color))
            etEmail.setHintTextColor(ContextCompat.getColor(this, R.color.invalid_hint_color))
            result += "Invalid mail\n"
        }

        if (etUsername.text.length > 9) {
            etUsername.setBackgroundResource(R.color.success_color)
            etUsername.setTextColor(ContextCompat.getColor(this, R.color.valid_text_color))
            etUsername.setHintTextColor(ContextCompat.getColor(this, R.color.valid_hint_color))
        } else {
            etUsername.setBackgroundResource(R.color.error_color)
            etUsername.setTextColor(ContextCompat.getColor(this, R.color.invalid_text_color))
            etUsername.setHintTextColor(ContextCompat.getColor(this, R.color.invalid_hint_color))
            result += "Invalid username\n"
        }

        if (etPassword.length() > 5) {
            etPassword.setBackgroundResource(R.color.success_color)
            etPassword.setTextColor(ContextCompat.getColor(this, R.color.valid_text_color))
            etPassword.setHintTextColor(ContextCompat.getColor(this, R.color.valid_hint_color))
        } else {
            etPassword.setBackgroundResource(R.color.error_color)
            etPassword.setTextColor(ContextCompat.getColor(this, R.color.invalid_text_color))
            etPassword.setHintTextColor(ContextCompat.getColor(this, R.color.invalid_hint_color))
            result += "Invalid password\n"
        }

        if (etConfirmPassword.text.isNotEmpty() && toString() == etPassword.text.toString()) {
            etConfirmPassword.setBackgroundResource(R.color.success_color)
            etConfirmPassword.setTextColor(ContextCompat.getColor(this, R.color.valid_text_color))
            etConfirmPassword.setHintTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.valid_hint_color
                )
            )
        } else {
            etConfirmPassword.setBackgroundResource(R.color.error_color)
            etConfirmPassword.setTextColor(ContextCompat.getColor(this, R.color.invalid_text_color))
            etConfirmPassword.setHintTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.invalid_hint_color
                )
            )
            result += "Invalid password\n"
        }

        if (etName.text.isNotEmpty()) {
            etName.setBackgroundResource(R.color.success_color)
            etName.setTextColor(ContextCompat.getColor(this, R.color.valid_text_color))
            etName.setHintTextColor(ContextCompat.getColor(this, R.color.valid_hint_color))
        } else {
            etName.setBackgroundResource(R.color.error_color)
            etName.setTextColor(ContextCompat.getColor(this, R.color.invalid_text_color))
            etName.setHintTextColor(ContextCompat.getColor(this, R.color.invalid_hint_color))
            result += "Invalid name\n"
        }

        if (etSurname.text.isNotEmpty()) {
            etSurname.setBackgroundResource(R.color.success_color)
            etSurname.setTextColor(ContextCompat.getColor(this, R.color.valid_text_color))
            etSurname.setHintTextColor(ContextCompat.getColor(this, R.color.valid_hint_color))
        } else {
            etSurname.setBackgroundResource(R.color.error_color)
            etSurname.setTextColor(ContextCompat.getColor(this, R.color.invalid_text_color))
            etSurname.setHintTextColor(ContextCompat.getColor(this, R.color.invalid_hint_color))
            result += "Invalid surname\n"
        }

        if (etAge.text.isNotEmpty()
            && etAge.text.toString().toInt() > 0
            && etAge.text.toString().toInt() < 150
        ) {
            etAge.setBackgroundResource(R.color.success_color)
            etAge.setTextColor(ContextCompat.getColor(this, R.color.valid_text_color))
            etAge.setHintTextColor(ContextCompat.getColor(this, R.color.valid_hint_color))
        } else {
            etAge.setBackgroundResource(R.color.error_color)
            etAge.setTextColor(ContextCompat.getColor(this, R.color.invalid_text_color))
            etAge.setHintTextColor(ContextCompat.getColor(this, R.color.invalid_hint_color))
            result += "Invalid age\n"
        }

        if (result.isNotEmpty())
            Toast.makeText(this, result, Toast.LENGTH_LONG).show()
    }


    private fun clear() {
        etArray.forEach {
            it.text.clear()
            it.setBackgroundResource(R.color.line_color)
            it.setHintTextColor(ContextCompat.getColor(this, R.color.hint_color))
        }
    }
}