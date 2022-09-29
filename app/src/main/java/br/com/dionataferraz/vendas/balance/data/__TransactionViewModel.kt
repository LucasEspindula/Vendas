package br.com.dionataferraz.vendas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.dionataferraz.vendas.balance.data.local.BalanceEntity
import br.com.dionataferraz.vendas.balance.data.local.TypeDeposit
import java.util.*

class TransactionsViewModel : ViewModel() {

    private val transactionModel: MutableLiveData<List<BalanceEntity>> = MutableLiveData()
    val transactionLiveData: LiveData<List<BalanceEntity>> = transactionModel

    fun __CALLTEST() {
        transactionModel.value = transactionList
    }

    private val transactionList = listOf(
        BalanceEntity(
            value = 10.91,
            typeDeposit = TypeDeposit.Deposit
        ),
    )
}