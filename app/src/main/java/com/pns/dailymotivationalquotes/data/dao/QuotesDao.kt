package com.pns.dailymotivationalquotes.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pns.dailymotivationalquotes.data.entity.Quote
import kotlinx.coroutines.flow.Flow

@Dao
interface QuotesDao {

    @Query("select * from quotes")
    fun getAllQuotes(): Flow<List<Quote>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuote(quote: List<Quote>)

    @Query("delete from quotes")
    suspend fun deleteAllQuotes()
}