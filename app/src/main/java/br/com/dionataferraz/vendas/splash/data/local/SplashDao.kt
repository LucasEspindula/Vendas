package br.com.dionataferraz.vendas.splash.data.local

import androidx.room.Dao
import androidx.room.Query
import br.com.dionataferraz.vendas.login.data.model.UserModel

@Dao
interface SplashDao {

    @Query("SELECT * from userTable")
    fun getUser(): List<UserModel>
}