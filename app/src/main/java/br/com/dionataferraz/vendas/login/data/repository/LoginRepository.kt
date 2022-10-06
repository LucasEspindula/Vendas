package br.com.dionataferraz.vendas.login.data.repository

import br.com.dionataferraz.vendas.login.data.local.LoginLocalDataSource
import br.com.dionataferraz.vendas.login.data.model.UserModel
import br.com.dionataferraz.vendas.login.data.remote.ErrorModel
import br.com.dionataferraz.vendas.login.data.remote.LoginRemoteDataSource
import br.com.dionataferraz.vendas.login.data.remote.Result

class LoginRepository {

    private val dataSource by lazy {
        LoginRemoteDataSource()
    }

    private val localdataSource by lazy {
        LoginLocalDataSource()
    }

    suspend fun login(email: String, password: String): Result<UserModel, ErrorModel> {
        val resultUser = dataSource.login(password = password, email = email)
        if (resultUser is Result.Success) {
            insertUserRepository(resultUser.value)
        }
        return resultUser
    }

    private suspend fun insertUserRepository(userModel: UserModel) {
        localdataSource.insertUserDataSource(
            userModel
        )
    }
}