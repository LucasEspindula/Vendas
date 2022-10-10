package br.com.dionataferraz.vendas.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.balance.domain.usecase.TransactionUseCase
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val homeName: MutableLiveData<String> = MutableLiveData()
    val homeNameLiveData: LiveData<String> = homeName

    private val homeBalance: MutableLiveData<String> = MutableLiveData()
    val homeBalanceLiveData: MutableLiveData<String> = homeBalance

    private val usecase by lazy {
        TransactionUseCase()
    }

    fun attNameHome() = viewModelScope.launch {
        homeName.value = "Olá, ${usecase.fetchUser()?.name.toString()}"
    }

    fun attBalanceHome() = viewModelScope.launch {
        var sumBalance = 0.0

        homeBalance.value = "R$ $sumBalance"

        val userId = usecase.fetchUserId()
        if (userId != null) {
            usecase.fetchTransactions(userId).get()?.map { value ->
                sumBalance += value.value
            }
        }
    }


//    ("R$ " + usecase.fetchBalanceUseCase().formats(2)).also { homeModel.value = it }
//    private fun Double.formats(scale: Int) = "%.${scale}f".format(this)
}