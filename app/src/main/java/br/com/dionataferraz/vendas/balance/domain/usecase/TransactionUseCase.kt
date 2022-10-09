package br.com.dionataferraz.vendas.balance.domain.usecase

import br.com.dionataferraz.vendas.balance.data.remote.TransactionResponse
import br.com.dionataferraz.vendas.balance.data.repository.TransactionRepository
import br.com.dionataferraz.vendas.login.data.repository.LoginRepository
import br.com.dionataferraz.vendas.model.*

class TransactionUseCase {

    private val repository by lazy {
        TransactionRepository()
    }

    private val repositoryLogin by lazy {
        LoginRepository()
    }

    suspend fun fetchUserId(): Int? {
        return repositoryLogin.fetchUser().get()?.id
    }

    suspend fun fetchUser(): UserModel? {
        return repositoryLogin.fetchUser().get()
    }

    suspend fun fetchTransactions(idUser: Int): ResultModel<List<TransactionResponse>, ErrorModel> {
        return repository.fetchTransactions(idUser)
    }

    suspend fun registerTransaction(idUser: Int, newTransactionModel: NewTransactionModel) {
        return repository.registerTransaction(idUser, newTransactionModel)
    }

    suspend fun deleteTransaction(id: Int) {
        repository.deleteTransaction(id)
    }
}