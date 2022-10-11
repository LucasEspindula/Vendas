package br.com.dionataferraz.vendas.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.login.domain.usecase.GetLoginUsecase
import br.com.dionataferraz.vendas.model.LoginModel
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val home: MutableLiveData<Boolean> = MutableLiveData(false)
    val shouldShowHome: LiveData<Boolean> = home

    private val error: MutableLiveData<String> = MutableLiveData()
    val shouldShowError: LiveData<String> = error

    private val usecase by lazy {
        GetLoginUsecase()
    }

    fun login(loginModel: LoginModel) {
        viewModelScope.launch {
            if (usecase.login(loginModel).get() != null) {
                home.value = true
            } else {
                error.value = "Invalid email or password."
            }
        }
    }
}