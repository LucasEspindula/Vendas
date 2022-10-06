package br.com.dionataferraz.vendas.login.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userTable")
data class UserEntity(

    val name: String,
    @PrimaryKey(autoGenerate = true)
    val email: String,
    val password: String,
)