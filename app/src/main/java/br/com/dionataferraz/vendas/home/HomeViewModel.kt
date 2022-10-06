package br.com.dionataferraz.vendas.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.balance.domain.usecase.BalanceUsecase
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val homeModel: MutableLiveData<String> = MutableLiveData()
    val homeLiveData: MutableLiveData<String> = homeModel

    private val usecase by lazy {
        BalanceUsecase()
    }

    fun attBalance() = viewModelScope.launch {
        ("R$ " + usecase.fetchBalanceUseCase().formats(2)).also { homeModel.value = it }
    }

    private fun Double.formats(scale: Int) = "%.${scale}f".format(this)
}