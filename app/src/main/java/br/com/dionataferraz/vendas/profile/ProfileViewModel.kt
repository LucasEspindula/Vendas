package br.com.dionataferraz.vendas.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    private val error: MutableLiveData<String> = MutableLiveData()
    val shouldShowError: LiveData<String> = error
    private val profileModel: MutableLiveData<ProfileModel> = MutableLiveData()
    val personLiveData: LiveData<ProfileModel> = profileModel

    fun createPerson(name: String?, age: String?, email: String?, password: String?, option: String?) {
        if (name.isNullOrBlank())
            error.value = "The name field cannot be empty!"
        else if (email.isNullOrBlank())
            error.value = "The email field cannot be empty!"
        else if (password.isNullOrBlank())
            error.value = "The password field cannot be empty!"
        else if (age.isNullOrBlank())
            error.value = "The age field cannot be empty!"
        else if (option.isNullOrBlank())
            error.value = "The gender field must be checked!"
        else {
            val personCreated = ProfileModel(
                name = name,
                age = age,
                email = email,
                password = password,
                option = option
            )
            profileModel.value = personCreated
        }
    }
}