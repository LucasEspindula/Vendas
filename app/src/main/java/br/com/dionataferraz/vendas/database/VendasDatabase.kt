package br.com.dionataferraz.vendas.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.dionataferraz.vendas.App
import br.com.dionataferraz.vendas.balance.data.converter.DateConverter
import br.com.dionataferraz.vendas.login.data.local.UserDao
import br.com.dionataferraz.vendas.login.data.local.UserEntity
import br.com.dionataferraz.vendas.splash.data.local.SplashDao

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class VendasDatabase : RoomDatabase() {

//    abstract fun balanceDAO(): BalanceDao
    abstract fun splashDAO(): SplashDao
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