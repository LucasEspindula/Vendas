package br.com.dionataferraz.vendas.balance.data.local

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.balance.data.repository.BalanceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BalanceViewModel(application: Application): AndroidViewModel(application) {

    private val repository: BalanceRepository

    init {
        val balanceDao = VendasDatabase.getInstance().DAO()
        repository = BalanceRepository(balanceDao)
    }

    fun addBalance(balanceEntity: BalanceEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addBalance(balanceEntity)
        }
    }
}