package `in`.trentweet.reminderlist.ui.home.quotes

import `in`.trentweet.reminderlist.R
import `in`.trentweet.reminderlist.data.db.entities.Quote
import `in`.trentweet.reminderlist.databinding.ItemQuoteBinding
import com.xwray.groupie.databinding.BindableItem

class QuoteItem(
    private val quote: Quote
) : BindableItem<ItemQuoteBinding>() {

    override fun getLayout() = R.layout.item_quote

    override fun bind(viewBinding: ItemQuoteBinding, position: Int) {
        viewBinding.setQuote(quote)
    }
}