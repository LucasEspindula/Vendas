package br.com.dionataferraz.vendas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountViewModel : ViewModel() {

    private val error: MutableLiveData<String> = MutableLiveData()
    val shouldShowError: LiveData<String> = error
    private val account: MutableLiveData<Account> = MutableLiveData()
    val accountLiveData: LiveData<Account> = account

    fun createAccount(
        name_account: String?,
        account_value: String?,
        account_responsible: String?,
        accountRB: String?
    ) {
        if (name_account.isNullOrBlank()) error.value = "O campo nome não pode ser vazio!"
        else if (account_value.isNullOrBlank()) error.value = "O campo valor não pode ser vazio!"
        else if (account_responsible.isNullOrBlank()) error.value = "O campo responsavel não pode ser vazio!"
        else if (accountRB.isNullOrBlank()) error.value = "O campo tipo de conta não pode ser vazio!"
        else {
            val accountCreated = Account(
                name_account = name_account,
                account_value = account_value,
                account_responsible = account_responsible,
                accountRB = accountRB
            )
            account.value = accountCreated
        }
    }
}