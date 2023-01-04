package com.pns.dailymotivationalquotes.ui.quote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pns.dailymotivationalquotes.data.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(repository: QuoteRepository) : ViewModel() {

    val quotes = repository.getQuotes().asLiveData()
}