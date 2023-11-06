package com.example.gdsc_assign


data class ToDo(
    val num : Int,
    val body : String,
    val isDone :Boolean
){
    companion object {
        val DummyList = listOf(
            ToDo(1, "안드로이드 스터디 과제하기", false),
            ToDo(2, "졸프 설계서 작성하기", true),
            ToDo(3, "친구 생일선물 사기", true),
            ToDo(4, "슬랙 확인하기", false),
            ToDo(5, "23시 회의", true),
            ToDo(6, "안드로이드 스터디 자료만들기", true)
        )
    }
}

