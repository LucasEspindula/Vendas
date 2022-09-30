package br.com.dionataferraz.vendas

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.balance.data.model.BalanceModel
import br.com.dionataferraz.vendas.balance.domain.usecase.BalanceUsecase
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val transactionModel: MutableLiveData<List<BalanceModel>> = MutableLiveData()
    val transactionLiveData: MutableLiveData<List<BalanceModel>> = transactionModel

    private val usecase by lazy {
        BalanceUsecase()
    }

    fun attBalance() {
        viewModelScope.launch {
            transactionModel.value = usecase.fetchTransactions()
        }
    }
}