package br.com.dionataferraz.vendas.profile.domain.usecase

import br.com.dionataferraz.vendas.model.ErrorModel
import br.com.dionataferraz.vendas.model.NewUserModel
import br.com.dionataferraz.vendas.model.ResultModel
import br.com.dionataferraz.vendas.model.UserModel
import br.com.dionataferraz.vendas.profile.data.repository.ProfileRepository

class ProfileUseCase {

    private val repository by lazy {
        ProfileRepository()
    }

    suspend fun registerProfile(userModel: UserModel): ResultModel<NewUserModel, ErrorModel> {
        return repository.registerProfile(userModel)
    }
}