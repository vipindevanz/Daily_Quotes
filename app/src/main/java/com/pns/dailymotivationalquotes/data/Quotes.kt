package com.pns.dailymotivationalquotes.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "quotes")
data class Quote(

    @SerializedName("q")
    @PrimaryKey
    val quotes : String,

    @SerializedName("a")
    val author : String,

    val character : String,
    val h : String,
)