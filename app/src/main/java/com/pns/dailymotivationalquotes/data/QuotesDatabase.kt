package com.pns.dailymotivationalquotes.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pns.dailymotivationalquotes.data.dao.QuotesDao
import com.pns.dailymotivationalquotes.data.entity.Quote

@Database(entities = [Quote::class], version = 1)
abstract class QuotesDatabase : RoomDatabase() {

    abstract fun quotesDao() : QuotesDao
}