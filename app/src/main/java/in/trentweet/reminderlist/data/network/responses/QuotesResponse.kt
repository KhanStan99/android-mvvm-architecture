package `in`.trentweet.reminderlist.data.network.responses

import `in`.trentweet.reminderlist.data.db.entities.Quote


data class QuotesResponse (
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)