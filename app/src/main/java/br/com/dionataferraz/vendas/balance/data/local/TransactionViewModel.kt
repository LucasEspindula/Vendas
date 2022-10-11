package br.com.dionataferraz.vendas.balance.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.balance.domain.usecase.TransactionUseCase
import br.com.dionataferraz.vendas.model.NewTransactionModel
import kotlinx.coroutines.launch

class TransactionViewModel : ViewModel() {

    private val error: MutableLiveData<String> = MutableLiveData()
    val shouldShowError: LiveData<String> = error

    private val usecase by lazy {
        TransactionUseCase()
    }

    fun createTransaction(value: String, description: String, type: TransactionType) {
        viewModelScope.launch {
            when {
                value.isBlank() -> error.value = "The value field cannot be empty!"
                description.isBlank() -> error.value = "The description field cannot be empty!"

                else -> {
                    val newTransaction = NewTransactionModel(
                        value = value.toDouble(),
                        description = description,
                        transactionType = type
                    )

                    val userId = usecase.fetchUser()?.id
                    if (userId != null) {
                        usecase.registerTransaction(userId, newTransaction)
                    }
                }
            }
        }
    }
}