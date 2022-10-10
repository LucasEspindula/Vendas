package br.com.dionataferraz.vendas.balance.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.balance.domain.usecase.TransactionUseCase
import br.com.dionataferraz.vendas.model.NewTransactionModel
import kotlinx.coroutines.launch

class TransactionViewModel : ViewModel() {

    private val usecase by lazy {
        TransactionUseCase()
    }

    private val error: MutableLiveData<String> = MutableLiveData()
    val shouldShowError: LiveData<String> = error

    fun createTransaction(newTransactionModel: NewTransactionModel) {
        viewModelScope.launch {
            when {
                newTransactionModel.value.isNaN() -> error.value = "The value field cannot be empty!"
                newTransactionModel.description.isBlank() -> error.value = "The description field cannot be empty!"

                else -> {
                    val userId = usecase.fetchUserId()
                    if (userId != null) {
                        usecase.registerTransaction(userId, newTransactionModel)
                    }
                }
            }
        }
    }
}