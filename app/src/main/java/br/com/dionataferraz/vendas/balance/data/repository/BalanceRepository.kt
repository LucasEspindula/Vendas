package br.com.dionataferraz.vendas.balance.data.repository

import android.util.Log
import br.com.dionataferraz.vendas.balance.data.local.BalanceEntity
import br.com.dionataferraz.vendas.balance.data.local.LocalDataSource
import br.com.dionataferraz.vendas.balance.data.model.BalanceModel

class BalanceRepository() {

    private val dataSource by lazy {
        LocalDataSource()
    }

    fun depositBalanceRepository(balanceModel: BalanceModel) {
        dataSource.depositBalanceDataSource(
            balanceModel
        )
    }

    fun withdrawBalanceRepository(balanceModel: BalanceModel) {
        dataSource.withdrawBalanceDataSource(
            balanceModel
        )
    }

    fun fetchTransactions(): List<BalanceEntity> {
        return dataSource.fetchTransactions()
    }
}