package com.example.gdsc_assign.RoomData

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

interface ToDoDao {
    @Insert
    fun insert(user: ToDo)

    @Delete
    fun delete(user: ToDo)

    @Query("SELECT * FROM ToDo")
    fun selectAll(): List<ToDo>

    @Query("SELECT * FROM ToDo WHERE todoid =  todoid")
    fun selectByToDoId(todoid: Int): ToDo

    @Query("UPDATE ToDo SET body = :name  WHERE todoid = :name")
    fun updateNameByUserId(userId: Int, name: String)

}