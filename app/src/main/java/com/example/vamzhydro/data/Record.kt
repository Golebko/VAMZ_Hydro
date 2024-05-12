package com.example.vamzhydro.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "records")
data class Record(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val date: String,
    val time: String,
    val waterAmount: Int
)