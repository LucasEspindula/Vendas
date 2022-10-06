package br.com.dionataferraz.vendas.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.dionataferraz.vendas.App
import br.com.dionataferraz.vendas.balance.data.local.BalanceDao
import br.com.dionataferraz.vendas.balance.data.local.BalanceEntity
import br.com.dionataferraz.vendas.balance.data.local.DateConverter
import br.com.dionataferraz.vendas.login.data.local.UserDao
import br.com.dionataferraz.vendas.login.data.local.UserEntity

@Database(entities = [BalanceEntity::class, UserEntity::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class VendasDatabase : RoomDatabase() {

    abstract fun balanceDAO(): BalanceDao
    abstract fun loginDAO(): UserDao

    companion object {
        fun getInstance(): VendasDatabase {
            return Room.databaseBuilder(
                App.context,
                VendasDatabase::class.java,
                "vendas.db"
            ).build()
        }
    }
}