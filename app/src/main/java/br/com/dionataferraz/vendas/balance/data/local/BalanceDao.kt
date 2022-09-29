package br.com.dionataferraz.vendas.balance.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BalanceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBalance(balanceEntity: BalanceEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun removeBalance(balanceEntity: BalanceEntity)

    @Query("SELECT * from balanceTable")
    fun getTransactions(): List<BalanceEntity>
}