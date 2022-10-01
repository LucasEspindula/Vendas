package br.com.dionataferraz.vendas.balance.data.local

import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.dionataferraz.vendas.App

@Database(entities = [BalanceEntity::class], version = 1)
@TypeConverters(DateConverter::class)
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