package com.example.gdsc_assign

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gdsc_assign.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: NameViewModel by activityViewModels()
    private var todolist: MutableList<ToDo> = mutableListOf(
        ToDo("11월27일", "안드로이드 스터디 과제하기", true),
        ToDo("11월27일", "안드로이드 자기소개 구경하기", false),
        ToDo("11월27일", "안드로이드 2주차 공부하기", false),
        ToDo("11월27일", "안드로이드 1주차 복습하기", false),
        ToDo("11월27일", "이슬톡톡 연마하기", false),
        ToDo("11월27일", "살아남기..!", false)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        initToDoList()
        return binding.root
    }

    override fun onPause() {
        super.onPause()
        val completeNumbers: Int = checkCompleteTodo()
        viewModel._currentToDoItem.postValue(completeNumbers.toString())
    }

    private fun initToDoList() {
        val adaptor = ToDoAdaptor(todolist)
        binding.recyclerView1.adapter = adaptor
        binding.recyclerView1.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }


    private fun checkCompleteTodo(): Int {
        var a = 0
        for (i: Int in 0..<todolist.size) {
            if (todolist[i].isDone) {
                a++
            }
        }
        return a
    }


}
