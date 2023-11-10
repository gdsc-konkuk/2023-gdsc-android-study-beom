package com.example.gdsc_assign

import android.app.Activity
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import com.example.gdsc_assign.databinding.FragmentMyPageBinding

class MyPageFragment : Fragment() {
   private lateinit var binding : FragmentMyPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyPageBinding.inflate(layoutInflater, container, false)
        val nickname = binding.tvMyName.text
        if (nickname != null) {
            binding.tvMyName.text = nickname.toString()
        } else {
            binding.tvMyName.text = "허헛~"
        }
        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                // 다시 돌아왔을 때 할 거
                val nickname = it.data?.getStringExtra("nickname")
                binding.tvMyName.text = nickname
            }
        }
        binding.apply {
            imgBtnInfoChange.setOnClickListener {
                val intent = Intent(requireContext(), EditActivity::class.java) //액티비티 넘어갈때 사용
                //                startActivity(intent)
                intent.putExtra("nickname", tvMyName.text)
                launcher.launch(intent)
            }
        }
        return binding.root
    }
}

