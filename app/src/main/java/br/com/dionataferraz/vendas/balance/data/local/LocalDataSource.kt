package br.com.dionataferraz.vendas.balance.data.local

import br.com.dionataferraz.vendas.balance.data.model.BalanceModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataSource {

    private val database by lazy {
        VendasDatabase.getInstance()
    }

    suspend fun depositBalanceDataSource(balanceModel: BalanceModel) {
        withContext(Dispatchers.IO) {
            database.DAO().insertBalance(
                balanceModel.mapModelToEntity()
            )
        }
    }

    suspend fun withdrawBalanceDataSource(balanceModel: BalanceModel) {
        withContext(Dispatchers.IO) {
            database.DAO().removeBalance(
                balanceModel.mapModelToEntity()
            )
        }
    }

    suspend fun fetchTransactions(): List<BalanceModel> {
        return withContext(Dispatchers.IO) {
            database.DAO().getTransactions()
        }
    }

    private fun BalanceModel.mapModelToEntity(): BalanceEntity {
        return BalanceEntity(
            value = value,
            typeDeposit = typeDeposit
        )
    }

//    private fun BalanceEntity.mapEntityToModel(): BalanceModel {
//        return BalanceModel(
//            value = value,
//            typeDeposit = typeDeposit
//        )
//    }
}