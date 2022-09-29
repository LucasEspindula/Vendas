package br.com.dionataferraz.vendas.balance.data.local

import android.util.Log
import br.com.dionataferraz.vendas.balance.data.model.BalanceModel

class LocalDataSource {

    private val database by lazy {
        VendasDatabase.getInstance()
    }

    fun depositBalanceDataSource(balanceModel: BalanceModel) {
        database.DAO().insertBalance(
            balanceModel.mapModelToEntity()
        )
    }

    fun withdrawBalanceDataSource(balanceModel: BalanceModel) {
        database.DAO().removeBalance(
            balanceModel.mapModelToEntity()
        )
    }

    fun fetchTransactions(): List<BalanceEntity> {
        return database.DAO().getTransactions()
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