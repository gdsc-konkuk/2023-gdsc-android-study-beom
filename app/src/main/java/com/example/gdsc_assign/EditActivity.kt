package com.example.gdsc_assign

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast
import com.example.gdsc_assign.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    fun init() {
        binding.apply {
            val nickname = intent.getStringExtra("nickname")
            tvSecondName.text = nickname
            etNickname.setText(nickname)
            btnSave.setOnClickListener {
                if (etNickname.text.trim().isEmpty()) {
                    Toast.makeText(this@EditActivity, "닉네임은 빈칸일 수 없습니다.", Toast.LENGTH_SHORT).show()
                }
                else {
                    tvSecondName.text = etNickname.text.trim()
                }
            }
            ivBackButton2.setOnClickListener {
                val intent = Intent()
                intent.putExtra("nickname",tvSecondName.text.toString())
                setResult(Activity.RESULT_OK,intent)
                finish()
            }
        }
    }
}