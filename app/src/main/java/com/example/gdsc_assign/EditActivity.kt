package com.example.gdsc_assign

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnFocusChangeListener

import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.example.gdsc_assign.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding
    private val viewModel : NameViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setMyname()
        backToMyPage()
    }

    fun makeEditEmpty() {
        binding.apply {
            etNickname.setOnFocusChangeListener(View.OnFocusChangeListener { v, hasFocus ->
                if (hasFocus) {
                    etNickname.setText("")
                }
            })
        }
    }

    fun saveMyname() {
        binding.apply {
            btnSave.setOnClickListener {
                if (etNickname.text.trim().isEmpty()) {
                    Toast.makeText(this@EditActivity, "닉네임은 빈칸일 수 없습니다.", Toast.LENGTH_SHORT).show()
                } else {
                    tvSecondName.text = etNickname.text.trim()
                    val changeName = tvSecondName.text
                    viewModel._currentName.postValue(changeName.toString())
                    finish()
                }
            }
        }
    }

    fun backToMyPage() {
        binding.apply {
            ivBackButton2.setOnClickListener {
                val intent = Intent()
                intent.putExtra("nickname", tvSecondName.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }

    fun setMyname() {
        binding.apply {
            val nickname = intent.getStringExtra("nickname")
            tvSecondName.text = nickname
            etNickname.setText(nickname)
            makeEditEmpty()
            saveMyname()


        }
    }
}

