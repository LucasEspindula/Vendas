package br.com.dionataferraz.vendas.balance.domain.usecase

import br.com.dionataferraz.vendas.balance.data.model.BalanceModel
import br.com.dionataferraz.vendas.balance.data.repository.BalanceRepository

class BalanceUsecase {

    private val repository by lazy {
        BalanceRepository()
    }

    suspend fun typeBalanceUseCase(balanceModel: BalanceModel) {
        repository.typeBalanceRepository(
            balanceModel
        )
    }

    suspend fun fetchTransactionsUseCase(): List<BalanceModel> {
        return repository.fetchTransactionsRepository()
    }

    suspend fun fetchBalanceUseCase(): Double {
        return repository.fetchBalanceRepository()
    }
}