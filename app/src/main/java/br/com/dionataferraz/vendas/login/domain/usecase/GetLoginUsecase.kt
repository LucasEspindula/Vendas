package br.com.dionataferraz.vendas.login.domain.usecase

import br.com.dionataferraz.vendas.login.data.model.UserModel
import br.com.dionataferraz.vendas.login.data.remote.ErrorModel
import br.com.dionataferraz.vendas.login.data.remote.Result
import br.com.dionataferraz.vendas.login.data.repository.LoginRepository

class GetLoginUsecase {

    private val repository by lazy {
        LoginRepository()
    }

    suspend fun login(email: String, password: String):
            Result<UserModel, ErrorModel> {
        return repository.login(password = password, email = email)
    }
}