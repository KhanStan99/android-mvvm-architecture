package `in`.trentweet.reminderlist.ui.home.quotes

import `in`.trentweet.reminderlist.data.db.entities.Quote
import `in`.trentweet.reminderlist.data.repositories.QuotesRepository
import `in`.trentweet.reminderlist.ui.auth.AuthListener
import `in`.trentweet.reminderlist.util.ApiException
import `in`.trentweet.reminderlist.util.Coroutines
import `in`.trentweet.reminderlist.util.NoInternetException
import `in`.trentweet.reminderlist.util.lazyDeferred
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel;
import kotlinx.coroutines.Deferred

class QuotesViewModel(
    private val repository: QuotesRepository
) : ViewModel() {

    var authListener: AuthListener? = null

    fun returnQuotes() {
        authListener?.onStarted()
        Coroutines.io {
            try {
                return@io
            } catch (e: ApiException) {
                authListener?.onFailure(e.message!!)
            } catch (e: NoInternetException) {
                authListener?.onFailure(e.message!!)
            }
        }
        return
    }

    val quotes by lazyDeferred {
        repository.getQuotes()
    }
}
