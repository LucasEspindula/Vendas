package br.com.dionataferraz.vendas.balance.data.local

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.dionataferraz.vendas.App

@Database(entities = [BalanceEntity::class], version = 1)
abstract class VendasDatabase : RoomDatabase() {

    abstract fun DAO(): BalanceDao

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