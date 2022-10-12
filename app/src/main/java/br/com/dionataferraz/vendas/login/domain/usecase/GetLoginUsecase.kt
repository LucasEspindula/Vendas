package br.com.dionataferraz.vendas.login.domain.usecase

import br.com.dionataferraz.vendas.model.UserModel
import br.com.dionataferraz.vendas.model.ErrorModel
import br.com.dionataferraz.vendas.model.ResultModel
import br.com.dionataferraz.vendas.login.data.repository.LoginRepository
import br.com.dionataferraz.vendas.model.LoginModel

class GetLoginUsecase {

    private val repository by lazy {
        LoginRepository()
    }

    suspend fun login(loginModel: LoginModel): ResultModel<UserModel, ErrorModel> {
        return repository.login(loginModel)
    }
}