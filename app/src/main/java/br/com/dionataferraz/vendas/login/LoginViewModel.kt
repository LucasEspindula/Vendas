package br.com.dionataferraz.vendas.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.login.domain.usecase.GetLoginUsecase
import br.com.dionataferraz.vendas.model.LoginModel
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val usecase by lazy {
        GetLoginUsecase()
    }

    private val error: MutableLiveData<Boolean> = MutableLiveData(false)
    val shouldShowError: LiveData<Boolean> = error

    private val home: MutableLiveData<Boolean> = MutableLiveData(false)
    val shouldShowHome: LiveData<Boolean> = home

    fun login(loginModel: LoginModel) {
        viewModelScope.launch {
            if (loginModel != null) {
                val user = usecase.login(loginModel)

                if (user.get() != null) {
                    home.value = true
                } else {
                    error.value = true
                }
            } else {
                error.value = true
            }
        }
    }
}