package br.com.dionataferraz.vendas.balance.data.repository

import br.com.dionataferraz.vendas.balance.data.local.BalanceLocalDataSource
import br.com.dionataferraz.vendas.balance.data.model.BalanceModel

class BalanceRepository() {

    private val dataSource by lazy {
        BalanceLocalDataSource()
    }

    suspend fun typeBalanceRepository(balanceModel: BalanceModel) {
        dataSource.typeBalanceDataSource(
            balanceModel
        )
    }

    suspend fun fetchTransactionsRepository(): List<BalanceModel> {
        return dataSource.fetchTransactionsDataSource()
    }

    suspend fun fetchBalanceRepository(): Double {
        return dataSource.fetchBalanceDataSource()
    }
}