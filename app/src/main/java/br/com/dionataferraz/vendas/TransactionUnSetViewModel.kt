//package br.com.dionataferraz.vendas.balance
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import br.com.dionataferraz.vendas.balance.data.local.BalanceEntity
//import br.com.dionataferraz.vendas.balance.data.local.TypeDeposit
//import java.util.*
//
//class TransactionUnSetViewModel : ViewModel() {
//
//    private val error: MutableLiveData<String> = MutableLiveData()
//    val shouldShowError: LiveData<String> = error
//    private val newTransaction: MutableLiveData<BalanceEntity> = MutableLiveData()
//    val shouldShowHome: LiveData<BalanceEntity> = newTransaction
//
//    fun newTransaction(
////        date: Date,
//        value: String, typeDeposit: TypeDeposit) {
//        val createTransaction = BalanceEntity(
////            date = date,
//            value = value.toDouble(),
//            typeDeposit = typeDeposit
//        )
//        newTransaction.value = createTransaction
//    }
//}