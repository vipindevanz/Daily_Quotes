package com.pns.dailymotivationalquotes.data.network

import com.pns.dailymotivationalquotes.data.entity.Quote
import retrofit2.http.GET

interface QuoteApi {

    companion object {
        const val BASE_URL = "https://zenquotes.io/api/"
    }

    @GET("quotes")
    suspend fun getQuotes() : List<Quote>
}