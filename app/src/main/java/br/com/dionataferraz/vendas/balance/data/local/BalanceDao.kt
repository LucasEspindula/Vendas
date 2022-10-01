package br.com.dionataferraz.vendas.balance.data.local

import androidx.room.*
import br.com.dionataferraz.vendas.balance.data.model.BalanceModel

@Dao
interface BalanceDao {

    @Insert()
    fun insertBalance(balanceEntity: BalanceEntity)

    @Query("DELETE FROM balanceTable WHERE id = :id")
    fun removeBalance(id: Int)

    @Query("SELECT * from balanceTable")
    fun getTransactions(): List<BalanceModel>
}