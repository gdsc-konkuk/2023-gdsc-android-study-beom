package com.example.gdsc_assign

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.gdsc_assign.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            // 다시 돌아왔을 때 할 거
            val nickname = it.data?.getStringExtra("nickname")
            binding.tvMyName.text = nickname
        }
    }

    fun init() {
        binding.apply {
            imgBtnInfoChange.setOnClickListener {
                val intent = Intent(this@MainActivity, EditActivity::class.java) //액티비티 넘어갈때 사용
//                startActivity(intent)
                intent.putExtra("nickname", tvMyName.text)
                launcher.launch(intent)
            }
        }
    }

}