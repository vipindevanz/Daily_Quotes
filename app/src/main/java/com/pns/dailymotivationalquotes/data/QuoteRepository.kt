package com.pns.dailymotivationalquotes.data

import androidx.room.withTransaction
import com.pns.dailymotivationalquotes.data.network.QuoteApi
import com.pns.dailymotivationalquotes.utils.networkBoundResource
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteApi,
    private val db: QuotesDatabase
) {
    private val quotesDao = db.quotesDao()

    fun getQuotes() = networkBoundResource(
        query = {
            quotesDao.getAllQuotes()
        },
        fetch = {
            api.getQuotes()
        },
        saveFetchResult = { quotes ->
            db.withTransaction {
                quotesDao.deleteAllQuotes()
                quotesDao.insertQuote(quotes)
            }
        }
    )
}