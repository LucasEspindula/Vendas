package br.com.dionataferraz.vendas.profile.data.remote

import br.com.dionataferraz.vendas.RetrofitNetworkClient
import br.com.dionataferraz.vendas.model.ErrorModel
import br.com.dionataferraz.vendas.model.NewUserModel
import br.com.dionataferraz.vendas.model.ResultModel
import br.com.dionataferraz.vendas.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProfileRemoteDataSource {

    private val service = RetrofitNetworkClient
        .createNetworkClient()
        .create(ProfileApi::class.java)

    suspend fun profileRegister(userModel: UserModel): ResultModel<NewUserModel, ErrorModel> {
        return withContext(Dispatchers.IO) {
            try {
                val user = service.profile(userModel)
                ResultModel.Success(user.mapModelToNewModel())
            } catch (exception: Exception) {
                ResultModel.Error(ErrorModel)
            }
        }
    }

    private fun UserModel.mapModelToNewModel(): NewUserModel {
        return NewUserModel(
            name = name,
            email = email,
            password = password
        )
    }
}