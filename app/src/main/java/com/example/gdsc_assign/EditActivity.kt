package com.example.gdsc_assign

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.gdsc_assign.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setMyname()
        backToMyPage()
    }

    private fun makeEditEmpty() {
        binding.apply {
            etNickname.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    etNickname.setText("")
                }
            }
        }
    }

    private fun saveMyname() {

        binding.apply {
            val nowhiteNickname = etNickname.text.trim()
            btnSave.setOnClickListener {
                if (nowhiteNickname.isEmpty()) {
                    Toast.makeText(this@EditActivity, "닉네임은 빈칸일 수 없습니다.", Toast.LENGTH_SHORT).show()
                } else {
                    tvSecondName.text = nowhiteNickname
                    intent.putExtra("nickname", tvSecondName.text.toString())
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }
            }
        }
    }

    private fun backToMyPage() {
        binding.apply {
            ivBackButton2.setOnClickListener {
                val intent = Intent()
                intent.putExtra("nickname", tvSecondName.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }

    private fun setMyname() {
        binding.apply {
            val nickname = intent.getStringExtra("nickname")
            tvSecondName.text = nickname
            etNickname.setText(nickname)
            makeEditEmpty()
            saveMyname()
        }
    }
}

