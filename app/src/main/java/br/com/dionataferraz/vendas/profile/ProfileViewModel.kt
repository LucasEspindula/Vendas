package br.com.dionataferraz.vendas.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.model.UserModel
import br.com.dionataferraz.vendas.profile.domain.usecase.ProfileUseCase
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    private val usecase by lazy {
        ProfileUseCase()
    }

    private val userCreated: MutableLiveData<Boolean> = MutableLiveData(false)
    val userCreatedLiveData: LiveData<Boolean> = userCreated

    private val message: MutableLiveData<String> = MutableLiveData()
    val shouldShowMessage: LiveData<String> = message

    fun createPerson(name: String, email: String, password: String) {
        viewModelScope.launch {
            if (name.isBlank()) {
                message.value = "The name field cannot be empty!"
            } else if (email.isBlank()) {
                message.value = "The email field cannot be empty!"
            } else if (password.isBlank()) {
                message.value = "The password field cannot be empty!"
            } else {
                val newUser = UserModel(
                    name = name,
                    email = email,
                    password = password
                )

                userCreated.value = true
                usecase.registerProfile(newUser)
                message.value = "Profile created successfully!"
            }
        }
    }
}