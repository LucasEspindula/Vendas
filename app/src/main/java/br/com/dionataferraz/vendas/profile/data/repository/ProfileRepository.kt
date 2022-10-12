package br.com.dionataferraz.vendas.profile.data.repository

import br.com.dionataferraz.vendas.model.ErrorModel
import br.com.dionataferraz.vendas.model.NewUserModel
import br.com.dionataferraz.vendas.model.ResultModel
import br.com.dionataferraz.vendas.model.UserModel
import br.com.dionataferraz.vendas.profile.data.remote.ProfileRemoteDataSource

class ProfileRepository {

    private val dataSource by lazy {
        ProfileRemoteDataSource()
    }

    suspend fun registerProfile(userModel: UserModel): ResultModel<NewUserModel, ErrorModel> {
        return dataSource.profileRegister(userModel)
    }
}