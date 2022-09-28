package br.com.dionataferraz.vendas.balance.data.repository

import br.com.dionataferraz.vendas.balance.data.local.BalanceDao
import br.com.dionataferraz.vendas.balance.data.local.BalanceEntity

class BalanceRepository(private val balanceDao: BalanceDao) {

    suspend fun addBalance(balanceEntity: BalanceEntity) {
        balanceDao.insertBalance(balanceEntity)
    }
}