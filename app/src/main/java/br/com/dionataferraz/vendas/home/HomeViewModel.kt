package br.com.dionataferraz.vendas.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.balance.domain.usecase.TransactionUseCase
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val homeName: MutableLiveData<String> = MutableLiveData()
    val homeNameLiveData: LiveData<String> = homeName

    private val homeBalance: MutableLiveData<String> = MutableLiveData()
    val homeBalanceLiveData: MutableLiveData<String> = homeBalance

    private val usecase by lazy {
        TransactionUseCase()
    }

    fun attNameHome() = viewModelScope.launch {
        homeName.value = "Hello, ${usecase.fetchUser()?.name.toString()}"
    }

    fun attBalanceHome() = viewModelScope.launch {
        var sumBalance = 0.0

        val userId = usecase.fetchUser()?.id
        if (userId != null) {
            usecase.fetchTransactions(userId).get()?.map { value ->
                sumBalance += value.value
            }
        }
        homeBalance.value = "R$ ${2.formatsNew(sumBalance)}"
    }

    private fun Int.formatsNew(input: Double) = String.format("%.${this}f", input)
}