package com.pns.dailymotivationalquotes.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "quotes")
data class Quote(

    @SerializedName("quote")
    @PrimaryKey
    val q : String,
    @SerializedName("author")
    val a : String,
    @SerializedName("character")
    val c : String,
    @SerializedName("web")
    val h : String,
)