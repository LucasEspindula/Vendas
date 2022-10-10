package br.com.dionataferraz.vendas.login.data.remote

import br.com.dionataferraz.vendas.RetrofitNetworkClient
import br.com.dionataferraz.vendas.login.data.response.UserResponse
import br.com.dionataferraz.vendas.model.ErrorModel
import br.com.dionataferraz.vendas.model.ResultModel
import br.com.dionataferraz.vendas.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginRemoteDataSource {

    private val service = RetrofitNetworkClient
        .createNetworkClient()
        .create(LoginApi::class.java)

    suspend fun login(email: String, password: String): ResultModel<UserModel, ErrorModel> {
        return withContext(Dispatchers.IO) {
            try {
                val tt = service.login(email, password)
                ResultModel.Success(tt.mapResponseToModel())
            } catch (exception: Exception) {
                ResultModel.Error(ErrorModel)
            }
        }
    }

    private fun UserResponse.mapResponseToModel(): UserModel {
        return UserModel(
            id = id,
            name = name,
            email = email,
            password = password
        )
    }
}