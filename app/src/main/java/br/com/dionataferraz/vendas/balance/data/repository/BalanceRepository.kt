package br.com.dionataferraz.vendas.balance.data.repository

import br.com.dionataferraz.vendas.balance.data.local.BalanceDao
import br.com.dionataferraz.vendas.balance.data.local.BalanceEntity
import br.com.dionataferraz.vendas.balance.data.local.LocalDataSource
import br.com.dionataferraz.vendas.balance.data.local.TypeDeposit

class BalanceRepository() {

    private val dataSource by lazy {
        LocalDataSource()
    }

    fun addBalance(value: Double, typeDeposit: TypeDeposit) {
        dataSource.addBalance(
            value,
            typeDeposit
        )
    }
}