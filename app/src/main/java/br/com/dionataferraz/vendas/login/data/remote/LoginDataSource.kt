package br.com.dionataferraz.vendas.login.data.remote

import br.com.dionataferraz.vendas.login.data.response.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class LoginDataSource {
    private val service = RetrofitNetworkClient
        .createNetworkClient()
        .create(LoginApi::class.java)

    suspend fun login(email: String, password: String) {
        Result<UserResponse, ErrorModel> {

        }
        return withContext(Dispatchers.IO) {
            try {
                val user = service.login(email, password)
                Result.Sucess(user)
            } catch (exception:Exception) {
                Result.Error(ErrorModel)
            }
        }
    }
}

object ErrorModel
sealed class Result<out S, out E> {
    data class Sucess<S>(val value: S) : Result<S, Nothing>()
    data class Error<E>(val value: E) : Result<Nothing, E>()

    fun get():S? {
        return when(this) {
            is Sucess -> value
            else -> null
        }
    }
}