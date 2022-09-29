package br.com.dionataferraz.vendas.balance.data.domain.usecase

import br.com.dionataferraz.vendas.balance.data.local.TypeDeposit
import br.com.dionataferraz.vendas.balance.data.repository.BalanceRepository

class BalanceUsecase {

    private val repository by lazy {
        BalanceRepository()
    }

    //date = Date,
    fun addBalance (value: Double, typeDeposit: TypeDeposit) {
        repository.addBalance(
            value ,
            typeDeposit
        )
    }
}