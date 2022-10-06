package br.com.dionataferraz.vendas.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.balance.data.model.BalanceModel
import br.com.dionataferraz.vendas.splash.domain.usecase.SplashUsecase
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    private val splashValue: MutableLiveData<Boolean> = MutableLiveData(false)
    val splashLiveData: MutableLiveData<Boolean> = splashValue

    private val usecase by lazy {
        SplashUsecase()
    }

    fun verifyUserExists() {
        viewModelScope.launch {
            splashValue.value = usecase.fetchUserUseCase().isEmpty()
        }
    }
}