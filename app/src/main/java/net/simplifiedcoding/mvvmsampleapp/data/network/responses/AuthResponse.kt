package net.simplifiedcoding.mvvmsampleapp.data.network.responses

import net.simplifiedcoding.mvvmsampleapp.data.db.entities.User

data class AuthResponse(
    val token: String,
    val user: User
)