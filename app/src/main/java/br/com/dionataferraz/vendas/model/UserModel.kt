package br.com.dionataferraz.vendas.model

data class UserModel(
    val id: Int = 0,
    val name: String,
    val email: String,
    val password: String
)
