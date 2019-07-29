package `in`.trentweet.reminderlist.ui.home.quotes

import `in`.trentweet.reminderlist.data.repositories.QuotesRepository
import `in`.trentweet.reminderlist.util.lazyDeferred
import androidx.lifecycle.ViewModel;

class QuotesViewModel(
    repository: QuotesRepository
) : ViewModel() {

    val quotes by lazyDeferred {
        repository.getQuotes()
    }
}
