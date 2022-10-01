package br.com.dionataferraz.vendas.balance.data.local

import androidx.room.*
import br.com.dionataferraz.vendas.balance.data.model.BalanceModel

@Dao
interface BalanceDao {

    @Insert()
    fun insertTypeTransaction(balanceEntity: BalanceEntity)

    @Query("SELECT * from balanceTable")
    fun getTransactions(): List<BalanceModel>

    @Query("SELECT SUM(value) AS balance FROM balanceTable")
    fun getBalance(): Double
}