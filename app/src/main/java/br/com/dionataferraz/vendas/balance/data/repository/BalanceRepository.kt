package br.com.dionataferraz.vendas.balance.data.repository

import br.com.dionataferraz.vendas.balance.data.local.LocalDataSource
import br.com.dionataferraz.vendas.balance.data.model.BalanceModel

class BalanceRepository() {

    private val dataSource by lazy {
        LocalDataSource()
    }

    suspend fun depositBalanceRepository(balanceModel: BalanceModel) {
        dataSource.depositBalanceDataSource(
            balanceModel
        )
    }

    suspend fun withdrawBalanceRepository(balanceModel: BalanceModel) {
        dataSource.withdrawBalanceDataSource(
            balanceModel
        )
    }

    suspend fun fetchTransactions(): List<BalanceModel> {
        return dataSource.fetchTransactions()
    }
}