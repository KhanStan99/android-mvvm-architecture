package net.simplifiedcoding.mvvmsampleapp.data.network

import net.simplifiedcoding.mvvmsampleapp.data.db.entities.LoginInput
import net.simplifiedcoding.mvvmsampleapp.data.db.entities.User
import net.simplifiedcoding.mvvmsampleapp.data.network.responses.AuthResponse
import net.simplifiedcoding.mvvmsampleapp.data.network.responses.QuotesResponse
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface MyApi {

    @Headers("Content-Type: application/json")
    @POST("auth/login")
    suspend fun userLogin(
        @Body input: LoginInput
    ): Response<AuthResponse>

    @POST("auth/signup")
    suspend fun userSignup(
        @Field("firstName") first_name: String,
        @Field("last_name") last_name: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("avatar") avatar: String
    ): Response<AuthResponse>

    @GET("quotes")
    suspend fun getQuotes(): Response<QuotesResponse>

    companion object {
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ): MyApi {

            val okkHttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
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

