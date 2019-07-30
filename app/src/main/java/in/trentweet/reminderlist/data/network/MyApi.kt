package `in`.trentweet.reminderlist.data.network

import `in`.trentweet.reminderlist.data.db.entities.LoginInput
import `in`.trentweet.reminderlist.data.db.entities.SignupInput
import `in`.trentweet.reminderlist.data.db.entities.User
import `in`.trentweet.reminderlist.data.network.responses.AuthResponse
import `in`.trentweet.reminderlist.data.network.responses.QuotesResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

interface MyApi {

    @Headers("Content-Type: application/json")
    @POST("auth/login")
    suspend fun userLogin(
        @Body input: LoginInput
    ): Response<AuthResponse>

    @POST("auth/signup")
    suspend fun userSignup(
        @Body input: SignupInput
    ): Response<User>

    @GET("quotes")
    suspend fun getQuotes(): Response<QuotesResponse>

    companion object {
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ): MyApi {

            val okkHttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .readTimeout(10, TimeUnit.SECONDS)
                .build()

            return Retrofit.Builder()
                .client(okkHttpclient)
                .baseUrl("http://khan-reminder-list.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }

}

