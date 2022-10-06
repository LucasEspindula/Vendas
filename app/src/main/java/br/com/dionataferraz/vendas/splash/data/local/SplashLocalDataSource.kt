package br.com.dionataferraz.vendas.splash.data.local

import br.com.dionataferraz.vendas.database.VendasDatabase
import br.com.dionataferraz.vendas.login.data.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SplashLocalDataSource {

    private val database by lazy {
        VendasDatabase.getInstance()
    }

    suspend fun fetchUserDataSource(): List<UserModel> {
        return withContext(Dispatchers.IO) {
            database.splashDAO().getUser()
        }
    }
}