package com.example.gdsc_assign

import android.app.Activity
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.gdsc_assign.databinding.FragmentMyPageBinding
import kotlin.math.log

class MyPageFragment : Fragment() {
   private lateinit var binding : FragmentMyPageBinding
   private val viewModel : NameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

// 현우햄 왈 oncreate 는 fragment에서 안건드리는게 좋다!
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMyPageBinding.inflate(layoutInflater, container, false)
        val nickname = binding.tvMyName.text
        if (nickname != null) {
            binding.tvMyName.text = nickname.toString()
        } else {
            binding.tvMyName.text = "이승범"
        }
        //observer 사용파트
        val nameObserver = Observer<String> { newName ->
            Log.v("newname : ", newName)
            binding.tvMyName.text = newName
        }

        viewModel.currentName.observe(viewLifecycleOwner, nameObserver)
        //
        binding.apply {
            imgBtnInfoChange.setOnClickListener {
                val intent = Intent(requireContext(), EditActivity::class.java) //액티비티 넘어갈때 사용
                //                startActivity(intent)
                intent.putExtra("nickname", tvMyName.text)
                startActivity(intent)
            }
        } // editactivity로 넘어가는 부분
        return binding.root
    }
}

