package br.com.dionataferraz.vendas.balance.data.local

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface BalanceDao {

    @Insert
    fun insertBalance(balanceEntity: BalanceEntity)
}