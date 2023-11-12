package com.example.gdsc_assign

import android.app.Activity
import android.content.Intent
import android.media.RouteListingPreference.Item

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.gdsc_assign.databinding.FragmentMyPageBinding


class MyPageFragment : Fragment() {
   private lateinit var binding : FragmentMyPageBinding
   private val viewModel : NameViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMyPageBinding.inflate(layoutInflater, container, false)
        val nickname = binding.tvMyName.text
        if (nickname != null) {
            binding.tvMyName.text = nickname.toString()
        } else {
            binding.tvMyName.text = "이승범"
        }

        val mainlauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                // 다시 돌아왔을 때 할 거
                Toast.makeText(requireContext(),"저장에 성공하였습니다!",Toast.LENGTH_SHORT)
                val nickname = it.data?.getStringExtra("nickname")
                binding.tvMyName.text = nickname
            }
        }
        binding.apply {
            imgBtnInfoChange.setOnClickListener {
                val intent = Intent(requireContext(), EditActivity::class.java) //액티비티 넘어갈때 사용
                //                startActivity(intent)
                intent.putExtra("nickname", tvMyName.text)
                mainlauncher.launch(intent)
            }
        } // editactivity로 넘어가는 부분

        val completetodoObserver = Observer<String> {currentnum ->
            binding.tvCurrentCompleteTodo.text = "완료 투두 : " + currentnum

        }
        viewModel._currentToDoItem.observe(viewLifecycleOwner,completetodoObserver)

        return binding.root
    }

}

