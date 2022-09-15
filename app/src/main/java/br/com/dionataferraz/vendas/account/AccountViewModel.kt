package br.com.dionataferraz.vendas.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountViewModel : ViewModel() {

    private val error: MutableLiveData<String> = MutableLiveData()
    val shouldShowError: LiveData<String> = error
    private val account: MutableLiveData<Account> = MutableLiveData()
    val accountLiveData: LiveData<Account> = account

    fun createAccount(name: String?, value: String?, responsible: String?, type: String?) {
        if (name.isNullOrBlank())
            error.value = "The name field cannot be empty!"
        else if (value.isNullOrBlank())
            error.value = "The value field cannot be empty!"
        else if (responsible.isNullOrBlank())
            error.value = "The responsible field cannot be empty!"
        else if (type.isNullOrBlank())
            error.value = "The account type field must be checked!"
        else {
            val accountCreated = Account(
                name = name,
                value = value,
                responsible = responsible,
                type = type
            )
            account.value = accountCreated
        }
    }
}