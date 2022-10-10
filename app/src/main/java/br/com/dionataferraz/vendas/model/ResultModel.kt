package br.com.dionataferraz.vendas.model

object ErrorModel
object NotFoundUser

sealed class ResultModel<out S, out E> {
    data class Success<S>(val value: S) : ResultModel<S, Nothing>()
    data class Error<E>(val value: E) : ResultModel<Nothing, E>()

    fun get(): S? {
        return when (this) {
            is Success -> value
            else -> null
        }
    }
}