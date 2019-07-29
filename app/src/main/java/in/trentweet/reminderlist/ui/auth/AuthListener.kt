package `in`.trentweet.reminderlist.ui.auth

import `in`.trentweet.reminderlist.data.db.entities.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
}