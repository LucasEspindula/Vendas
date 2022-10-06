package br.com.dionataferraz.vendas.balance.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.balance.data.model.BalanceModel
import br.com.dionataferraz.vendas.balance.domain.usecase.BalanceUsecase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class BalanceViewModel : ViewModel() {

    private val errorLiveData: MutableLiveData<String> = MutableLiveData()
    val shouldShowError: LiveData<String> = errorLiveData

    private val usecase by lazy {
        BalanceUsecase()
    }

    fun depositBalanceViewModel(value: String) {
        viewModelScope.launch {
            usecase.typeBalanceUseCase(
                BalanceModel(
                    value = value.toDouble(),
                    date = Date(),
                    nameTypeBalance = "Depósito",
                    typeDeposit = TypeDeposit.DEPOSIT
                )
            )
        }
    }

    fun withdrawBalanceViewModel(value: String) {
        viewModelScope.launch(Dispatchers.IO) {
            if (value.toDouble() > usecase.fetchBalanceUseCase()) {
                errorLiveData.postValue("Valor maior que seu saldo")
            } else {
                usecase.typeBalanceUseCase(
                    BalanceModel(
                        value = value.toDouble() * -1,
                        date = Date(),
                        nameTypeBalance = "Dinheiro resgatado",
                        typeDeposit = TypeDeposit.WITHDRAW
                    )
                )
            }
        }
    }
}