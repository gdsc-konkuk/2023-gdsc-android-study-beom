package com.example.gdsc_assign.RoomData

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDo(
    @ColumnInfo(name = "number") val number: String?,
    @ColumnInfo(name = "body") val body: String,
    @ColumnInfo(name = "isDone") var isDone: Boolean,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "todoid") val todoid: Int = 0
)


