package com.pns.dailymotivationalquotes.di.module

import android.app.Application
import androidx.room.Room
import com.pns.dailymotivationalquotes.data.QuotesDatabase
import com.pns.dailymotivationalquotes.data.network.QuoteApi
import com.pns.dailymotivationalquotes.data.network.QuoteApi.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providesQuoteApi(retrofit: Retrofit): QuoteApi =
        retrofit.create(QuoteApi::class.java)

    @Provides
    @Singleton
    fun providesDatabase(app : Application) : QuotesDatabase =
        Room.databaseBuilder(app, QuotesDatabase::class.java, "quotes_db")
            .build()
}