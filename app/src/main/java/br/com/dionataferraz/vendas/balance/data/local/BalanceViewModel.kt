package br.com.dionataferraz.vendas.balance.data.local

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.balance.data.model.BalanceModel
import br.com.dionataferraz.vendas.balance.data.repository.BalanceRepository
import br.com.dionataferraz.vendas.balance.domain.usecase.BalanceUsecase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BalanceViewModel : ViewModel() {

    private val usecase by lazy {
        BalanceUsecase()
    }

    fun depositBalanceViewModel(value: String) {
        viewModelScope.launch(Dispatchers.IO) {
            usecase.depositBalanceUseCase(
                BalanceModel(
                    value = value.toDouble(),
                    typeDeposit = TypeDeposit.Deposit
                )
            )
        }
    }

    fun withdrawBalanceViewModel(value: String) {
        viewModelScope.launch(Dispatchers.IO) {
            usecase.withdrawBalanceUseCase(
                BalanceModel(
                    value = value.toDouble(),
                    typeDeposit = TypeDeposit.Withdraw
                )
            )
        }
    }
}