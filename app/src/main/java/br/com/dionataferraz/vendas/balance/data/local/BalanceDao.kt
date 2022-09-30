package br.com.dionataferraz.vendas.balance.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.dionataferraz.vendas.balance.data.model.BalanceModel

@Dao
interface BalanceDao {

    @Insert()
    fun insertBalance(balanceEntity: BalanceEntity)

    @Insert()
    fun removeBalance(balanceEntity: BalanceEntity)

    @Query("SELECT * from balanceTable")
    fun getTransactions(): List<BalanceModel>
}