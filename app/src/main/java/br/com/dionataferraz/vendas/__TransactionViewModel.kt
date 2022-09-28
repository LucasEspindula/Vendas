package br.com.dionataferraz.vendas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class TransactionsViewModel : ViewModel() {

    private val transactionModel: MutableLiveData<List<__TransactionModel>> = MutableLiveData()
    val transactionLiveData: LiveData<List<__TransactionModel>> = transactionModel

    fun callTransactionList() {
        transactionModel.value = transactionList
    }

    private val transactionList = listOf(
        __TransactionModel(
            value = 10.91,
            time = Date(2021, 12, 5, 10, 12),
            description = "Max super",
            transactionType = __TransactionType.MARKET
        ),
        __TransactionModel(
            value = 15.13,
            time = Date(2021, 12, 5, 10, 42),
            description = "Posto alvorada",
            transactionType = __TransactionType.GAS_STATION
        ),
        __TransactionModel(
            value = 12.55,
            time = Date(2021, 12, 5, 10, 35),
            description = "Garrison",
            transactionType = __TransactionType.PUB
        )
    )
}