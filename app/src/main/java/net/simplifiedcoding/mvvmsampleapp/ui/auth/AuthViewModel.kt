package net.simplifiedcoding.mvvmsampleapp.ui.auth

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import net.simplifiedcoding.mvvmsampleapp.data.repositories.UserRepository
import net.simplifiedcoding.mvvmsampleapp.util.ApiException
import net.simplifiedcoding.mvvmsampleapp.util.Coroutines
import net.simplifiedcoding.mvvmsampleapp.util.NoInternetException
import java.util.logging.Logger


class AuthViewModel(
    private val repository: UserRepository
) : ViewModel() {

    var firstName: String? = null
    var lastName: String? = null
    var email: String? = null
    var password: String? = null
    var passwordconfirm: String? = null
    var avatar: String = ""

    var authListener: AuthListener? = null

    fun getLoggedInUser() = repository.getUser()


    fun onLoginButtonClick(view: View){
        authListener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListener?.onFailure("Invalid email or password")
            return
        }

        Coroutines.main {
            try {
                val authResponse = repository.userLogin(email!!, password!!)
                authResponse.user.let {
                    authListener?.onSuccess(it)
                    repository.saveUser(it)
                    return@main
                }

            }catch(e: ApiException){
                authListener?.onFailure(e.message!!)
            }catch (e: NoInternetException){
                authListener?.onFailure(e.message!!)
            }
        }

    }

    fun onLogin(view: View){
        Intent(view.context, LoginActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun onSignup(view: View){
        Intent(view.context, SignupActivity::class.java).also {
            view.context.startActivity(it)
        }
    }


    fun onSignupButtonClick(view: View){
        authListener?.onStarted()

        if(firstName.isNullOrEmpty()){
            authListener?.onFailure("First Name is required")
            return
        }

        if(lastName.isNullOrEmpty()){
            authListener?.onFailure("Last Name is required")
            return
        }

        if(email.isNullOrEmpty()){
            authListener?.onFailure("Email is required")
            return
        }

        if(password.isNullOrEmpty()){
            authListener?.onFailure("Please enter a password")
            return
        }

        if(password != passwordconfirm){
            authListener?.onFailure("Password did not match")
            return
        }


        Coroutines.main {
            try {
                val authResponse = repository.userSignup(firstName!!, lastName!!, email!!, password!!, avatar)
                authResponse.user.let {
                    authListener?.onSuccess(it)
                    repository.saveUser(it)
                    return@main
                }
            }catch(e: ApiException){
                authListener?.onFailure(e.message!!)
            }catch (e: NoInternetException){
                authListener?.onFailure(e.message!!)
            }
        }

    }

}