package com.pns.dailymotivationalquotes.ui.quote

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.pns.dailymotivationalquotes.databinding.ActivityQuoteBinding
import com.pns.dailymotivationalquotes.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuoteActivity : AppCompatActivity() {

    private val viewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityQuoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val quoteAdapter = QuoteAdapter()

        binding.apply {
            recyclerView.apply {
                adapter = quoteAdapter
                layoutManager = LinearLayoutManager(this@QuoteActivity)
            }
            viewModel.quotes.observe(this@QuoteActivity) { result ->
                quoteAdapter.submitList(result.data)

                progressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
                textViewError.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
                textViewError.text = result.error?.localizedMessage
            }
        }
    }
}