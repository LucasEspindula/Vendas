package br.com.dionataferraz.vendas.balance.data.local

import java.util.*

class LocalDataSource {

    private val database by lazy {
        VendasDatabase.getInstance()
    }

    fun addBalance(value: Double, typeDeposit: TypeDeposit) {
        database.DAO().insertBalance(
            BalanceEntity(
                value = value,
                typeDeposit = typeDeposit,
//            date = Date()
            )
        )
    }
}