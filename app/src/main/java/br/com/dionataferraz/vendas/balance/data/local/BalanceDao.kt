package br.com.dionataferraz.vendas.balance.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BalanceDao {

    @Insert
    fun insertBalance(balanceEntity: BalanceEntity)

    @Query("SELECT * from balanceTable")
    fun getTransactions(): List<BalanceEntity>


}