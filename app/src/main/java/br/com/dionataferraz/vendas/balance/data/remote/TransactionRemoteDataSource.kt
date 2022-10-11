package br.com.dionataferraz.vendas.balance.data.remote

import br.com.dionataferraz.vendas.RetrofitNetworkClient
import br.com.dionataferraz.vendas.model.ErrorModel
import br.com.dionataferraz.vendas.model.NewTransactionModel
import br.com.dionataferraz.vendas.model.ResultModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TransactionRemoteDataSource {

    private val service = RetrofitNetworkClient
        .createNetworkClient()
        .create(TransactionApi::class.java)


    suspend fun deleteTransaction(id: Int) {
        return withContext(Dispatchers.IO) {
            try {
                service.delete(id.toString())
            } catch (exception: Exception) {
                ResultModel.Error(ErrorModel)
            }
        }
    }

    suspend fun registerTransaction(idUser: Int, newTransactionModel: NewTransactionModel) {
        return withContext(Dispatchers.IO) {
            try {
                service.register(idUser.toString(), newTransactionModel)
            } catch (exception: Exception) {
                ResultModel.Error(ErrorModel)
            }
        }
    }

    suspend fun fetchTransactions(idUser: Int): ResultModel<List<TransactionResponse>, ErrorModel> {
        return withContext(Dispatchers.IO) {
            try {
                ResultModel.Success(service.fetch(idUser.toString()))
            } catch (exception: Exception) {
                ResultModel.Error(ErrorModel)
            }
        }
    }
}