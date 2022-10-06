package br.com.dionataferraz.vendas.balance.data.local

import br.com.dionataferraz.vendas.balance.data.model.BalanceModel
import br.com.dionataferraz.vendas.database.VendasDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BalanceLocalDataSource {

    private val database by lazy {
        VendasDatabase.getInstance()
    }

    suspend fun typeBalanceDataSource(balanceModel: BalanceModel) {
        withContext(Dispatchers.IO) {
            database.balanceDAO().insertTypeTransaction(
                balanceModel.mapModelToEntity()
            )
        }
    }

    suspend fun fetchTransactionsDataSource(): List<BalanceModel> {
        return withContext(Dispatchers.IO) {
            database.balanceDAO().getTransactions()
        }
    }

    suspend fun fetchBalanceDataSource(): Double {
        return withContext(Dispatchers.IO) {
            database.balanceDAO().getBalance()
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