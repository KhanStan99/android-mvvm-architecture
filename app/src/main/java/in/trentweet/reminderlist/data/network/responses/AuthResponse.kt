package `in`.trentweet.reminderlist.data.network.responses

import `in`.trentweet.reminderlist.data.db.entities.User

data class AuthResponse(
    val token: String,
    val user: User
)