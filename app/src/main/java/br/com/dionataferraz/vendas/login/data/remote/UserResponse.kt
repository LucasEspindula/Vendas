package br.com.dionataferraz.vendas.login.data.remote

data class UserResponse (
    val id: Int,
    val name: String,
    val email: String,
    val password: String
)