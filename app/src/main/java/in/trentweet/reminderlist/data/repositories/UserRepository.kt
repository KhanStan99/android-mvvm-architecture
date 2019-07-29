package `in`.trentweet.reminderlist.data.repositories

import `in`.trentweet.reminderlist.data.db.AppDatabase
import `in`.trentweet.reminderlist.data.db.entities.LoginInput
import `in`.trentweet.reminderlist.data.db.entities.SignupInput
import `in`.trentweet.reminderlist.data.db.entities.User
import `in`.trentweet.reminderlist.data.network.MyApi
import `in`.trentweet.reminderlist.data.network.SafeApiRequest
import `in`.trentweet.reminderlist.data.network.responses.AuthResponse


class UserRepository(
    private val api: MyApi,
    private val db: AppDatabase
) : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { api.userLogin(LoginInput(email, password)) }
    }

    suspend fun userSignup(
        input: SignupInput
    ): User {
        return apiRequest { api.userSignup(input) }
    }

    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)

    fun getUser() = db.getUserDao().getuser()

}