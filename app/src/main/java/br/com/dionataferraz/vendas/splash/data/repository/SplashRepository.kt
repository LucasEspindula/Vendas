package br.com.dionataferraz.vendas.splash.data.repository

import br.com.dionataferraz.vendas.model.UserModel
import br.com.dionataferraz.vendas.splash.data.local.SplashLocalDataSource

class SplashRepository {

    private val dataSource by lazy {
        SplashLocalDataSource()
    }

    suspend fun fetchUserRepository(): List<UserModel> {
        return dataSource.fetchUserDataSource()
    }
}