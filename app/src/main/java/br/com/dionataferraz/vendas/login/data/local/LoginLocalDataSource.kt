package br.com.dionataferraz.vendas.login.data.local

import br.com.dionataferraz.vendas.database.VendasDatabase
import br.com.dionataferraz.vendas.model.NotFoundUser
import br.com.dionataferraz.vendas.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import br.com.dionataferraz.vendas.model.ResultModel

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

    suspend fun getUserDataSource(): ResultModel<UserModel, NotFoundUser> {
        return withContext(Dispatchers.IO) {
            val listUser = database.loginDAO().getUser()

            if (listUser.isEmpty()) {
                ResultModel.Error(NotFoundUser)
            } else {
                ResultModel.Success(listUser.first().mapEntityToModel())
            }
        }
    }

    private fun UserModel.mapModelToEntity(): UserEntity {
        return UserEntity(
            id = id,
            name = name,
            email = email,
            password = password
        )
    }

    private fun UserEntity.mapEntityToModel(): UserModel {
        return UserModel(
            id = id,
            name = name,
            email = email,
            password = password
        )
    }
}