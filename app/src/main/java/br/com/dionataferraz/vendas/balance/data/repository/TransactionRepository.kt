package br.com.dionataferraz.vendas.balance.data.repository

import br.com.dionataferraz.vendas.balance.data.remote.TransactionResponse
import br.com.dionataferraz.vendas.model.ErrorModel
import br.com.dionataferraz.vendas.model.ResultModel
import br.com.dionataferraz.vendas.balance.data.remote.TransactionRemoteDataSource
import br.com.dionataferraz.vendas.model.NewTransactionModel

class TransactionRepository {

    private val dataSource by lazy {
        TransactionRemoteDataSource()
    }

    suspend fun deleteTransaction(id: Int) {
        return dataSource.deleteTransaction(id)
    }

    suspend fun registerTransaction(idUser: Int, newTransactionModel: NewTransactionModel) {
        return dataSource.registerTransaction(idUser, newTransactionModel)
    }

    suspend fun fetchTransactions(idUser: Int): ResultModel<List<TransactionResponse>, ErrorModel> {
        return dataSource.fetchTransactions(idUser)
    }
}