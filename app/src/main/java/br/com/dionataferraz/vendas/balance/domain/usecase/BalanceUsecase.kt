package br.com.dionataferraz.vendas.balance.domain.usecase

import android.util.Log
import br.com.dionataferraz.vendas.balance.data.local.BalanceEntity
import br.com.dionataferraz.vendas.balance.data.model.BalanceModel
import br.com.dionataferraz.vendas.balance.data.repository.BalanceRepository

class BalanceUsecase {

    private val repository by lazy {
        BalanceRepository()
    }

    fun depositBalanceUseCase(balanceModel: BalanceModel) {
        repository.depositBalanceRepository(
            balanceModel
        )
    }

    fun withdrawBalanceUseCase(balanceModel: BalanceModel) {
        repository.withdrawBalanceRepository(
            balanceModel
        )
    }

    fun fetchTransactions(): List<BalanceEntity> {
        return repository.fetchTransactions()
    }
}