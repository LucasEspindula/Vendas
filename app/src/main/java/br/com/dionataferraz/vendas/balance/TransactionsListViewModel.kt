package br.com.dionataferraz.vendas.balance

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.balance.data.remote.TransactionResponse
import br.com.dionataferraz.vendas.balance.domain.usecase.TransactionUseCase
import kotlinx.coroutines.launch

class TransactionsListViewModel : ViewModel() {

    private val transactions: MutableLiveData<List<TransactionResponse>> = MutableLiveData()
    val transactionsLiveData: LiveData<List<TransactionResponse>> = transactions

    private val error: MutableLiveData<String> = MutableLiveData()
    val shouldShowError: LiveData<String> = error

    private val usecase by lazy {
        TransactionUseCase()
    }

    fun callTransactions() {
        viewModelScope.launch {
            val userId = usecase.fetchUserId()
            if (userId != null) {
                transactions.value = usecase.fetchTransactions(userId).get()
            } else {
                error.value = "No transactions found!"
            }
        }
    }

    fun deleteTransactions(Id: Int) {
        viewModelScope.launch {
            usecase.deleteTransaction(Id)
        }
    }
}