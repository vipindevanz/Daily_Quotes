package com.pns.dailymotivationalquotes.ui.quote

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pns.dailymotivationalquotes.data.Quote
import com.pns.dailymotivationalquotes.databinding.QuoteItemBinding

class QuoteAdapter : ListAdapter<Quote, QuoteAdapter.QuoteViewHolder>(QuoteComparator()) {

    class QuoteViewHolder(private val binding: QuoteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(quote: Quote) {
            binding.apply {
                this.quotes = quote
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val binding = QuoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val currentQuote = getItem(position)
        if (currentQuote != null) {
            holder.bind(currentQuote)
        }
    }

    class QuoteComparator : DiffUtil.ItemCallback<Quote>() {

        override fun areItemsTheSame(oldItem: Quote, newItem: Quote) =
            oldItem.quote == newItem.quote

        override fun areContentsTheSame(oldItem: Quote, newItem: Quote) = oldItem == newItem
    }
}