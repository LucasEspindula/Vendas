package br.com.dionataferraz.vendas.login.data.local

import br.com.dionataferraz.vendas.database.VendasDatabase
import br.com.dionataferraz.vendas.login.data.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginLocalDataSource {

    private val database by lazy {
        VendasDatabase.getInstance()
    }

    suspend fun insertUserDataSource(userModel: UserModel) {
        withContext(Dispatchers.IO) {
            database.loginDAO().insertUser(
                userModel.mapModelToEntity()
            )
        }
    }

    private fun UserEntity.mapEntityToModel(): UserModel {
        return UserModel(
            name = name,
            email = email,
            password = password
        )
    }

    private fun UserModel.mapModelToEntity(): UserEntity {
        return UserEntity(
            name = name,
            email = email,
            password = password
        )
    }
}