package br.com.dionataferraz.vendas.splash.domain.usecase

import br.com.dionataferraz.vendas.login.data.model.UserModel
import br.com.dionataferraz.vendas.splash.data.repository.SplashRepository

class SplashUsecase {

    private val repository by lazy {
        SplashRepository()
    }

    suspend fun fetchUserUseCase(): List<UserModel> {
        return repository.fetchUserRepository()
    }
}