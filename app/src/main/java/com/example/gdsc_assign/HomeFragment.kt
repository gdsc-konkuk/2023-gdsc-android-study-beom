package com.example.gdsc_assign

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gdsc_assign.databinding.ActivityMainBinding
import com.example.gdsc_assign.databinding.FragmentHomeBinding
import com.example.gdsc_assign.databinding.FragmentMyPageBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    val todolist = ArrayList<ToDo>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        initialize()
        initToDoList()
        return binding.root
    }

    fun initToDoList() {
        val adaptor = ToDoAdaptor(todolist)
        adaptor.todos = todolist
        binding.recyclerView1.adapter = adaptor
        binding.recyclerView1.layoutManager =
            LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }
    fun initialize(){
        with(todolist){
            add(ToDo("11월27일", "안드로이드 스터디 과제하기", false))
            add(ToDo("11월27일", "안드로이드 자기소개 구경하기", true))
            add(ToDo("11월27일", "안드로이드 2주차 공부하기", true))
           add(ToDo("11월27일", "안드로이드 1주차 복습하기", false))
            add(ToDo("11월27일", "이슬톡톡 연마하기", true))
            add(ToDo("11월27일", "살아남기..!", true))
        }
    }

}
