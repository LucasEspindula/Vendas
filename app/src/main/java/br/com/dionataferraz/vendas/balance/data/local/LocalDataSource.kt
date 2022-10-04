package br.com.dionataferraz.vendas.balance.data.local

import br.com.dionataferraz.vendas.balance.data.model.BalanceModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataSource {

    private val database by lazy {
        VendasDatabase.getInstance()
    }

    suspend fun typeBalanceDataSource(balanceModel: BalanceModel) {
        withContext(Dispatchers.IO) {
            database.DAO().insertTypeTransaction(
                balanceModel.mapModelToEntity()
            )
        }
    }

    suspend fun fetchTransactionsDataSource(): List<BalanceModel> {
        return withContext(Dispatchers.IO) {
            database.DAO().getTransactions()
        }
    }

    suspend fun fetchBalanceDataSource(): Double {
        return withContext(Dispatchers.IO) {
            database.DAO().getBalance()
        }
    }

    private fun BalanceModel.mapModelToEntity(): BalanceEntity {
        return BalanceEntity(
            value = value,
            date = date,
            nameTypeBalance = nameTypeBalance,
            typeDeposit = typeDeposit
        )
    }
}