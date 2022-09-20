package br.com.dionataferraz.vendas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class TransactionsViewModel : ViewModel() {

    private val transactionModel: MutableLiveData<List<TransactionModel>> = MutableLiveData()
    val transactionLiveData: LiveData<List<TransactionModel>> = transactionModel

    fun callTransactionList() {
        transactionModel.value = transactionList
    }

    private val transactionList = listOf(
        TransactionModel(
            value = 10.91,
//            time = Date(2021, 12, 5, 10, 0),
            description = "Max super",
            transactionType = TransactionType.MARKET
        ),
        TransactionModel(
            value = 15.13,
//            time = Date(2021, 12, 5, 10, 0),
            description = "Posto alvorada",
            transactionType = TransactionType.GAS_STATION
        ),
        TransactionModel(
            value = 12.55,
//            time = Date(2021, 12, 5, 10, 0),
            description = "Garrison",
            transactionType = TransactionType.PUB
        )
    )
}