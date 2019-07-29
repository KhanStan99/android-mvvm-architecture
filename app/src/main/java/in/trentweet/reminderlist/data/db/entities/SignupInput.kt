package `in`.trentweet.reminderlist.data.db.entities

data class SignupInput(
    val first_name: String,
    val last_name: String,
    val email: String,
    val password: String,
    val avatar: String
)