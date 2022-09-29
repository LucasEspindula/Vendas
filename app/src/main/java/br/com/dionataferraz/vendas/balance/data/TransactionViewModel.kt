package br.com.dionataferraz.vendas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.balance.data.local.BalanceEntity
import br.com.dionataferraz.vendas.balance.data.local.TypeDeposit
import br.com.dionataferraz.vendas.balance.domain.usecase.BalanceUsecase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class TransactionsViewModel : ViewModel() {

    private val transactionModel: MutableLiveData<List<BalanceEntity>?> = MutableLiveData()
    val transactionLiveData: MutableLiveData<List<BalanceEntity>?> = transactionModel

    private val usecase by lazy {
        BalanceUsecase()
    }

    val tt =
}