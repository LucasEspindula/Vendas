package br.com.dionataferraz.vendas.balance.data.local

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.balance.data.repository.BalanceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BalanceViewModel: ViewModel() {

    private val repository: BalanceRepository

    init {
        val balanceDao = VendasDatabase.getInstance().DAO()
        repository = BalanceRepository(balanceDao)
    }

    fun addBalance(balanceEntity: BalanceEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addBalance()
        }
    }
}