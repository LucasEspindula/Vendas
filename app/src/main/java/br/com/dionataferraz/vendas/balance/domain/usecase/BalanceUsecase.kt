package br.com.dionataferraz.vendas.balance.domain.usecase

import android.util.Log
import br.com.dionataferraz.vendas.balance.data.model.BalanceModel
import br.com.dionataferraz.vendas.balance.data.repository.BalanceRepository

class BalanceUsecase {

    private val repository by lazy {
        BalanceRepository()
    }

    suspend fun depositBalanceUseCase(balanceModel: BalanceModel) {
        repository.depositBalanceRepository(
            balanceModel
        )
        Log.e("USERCASE ::::: ", balanceModel.toString())
    }

    suspend fun withdrawBalanceUseCase(balanceModel: BalanceModel) {
        repository.withdrawBalanceRepository(
            balanceModel
        )
    }

    suspend fun fetchTransactions(): List<BalanceModel> {
        return repository.fetchTransactions()
    }
}