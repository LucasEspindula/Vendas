package br.com.dionataferraz.vendas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    private val error: MutableLiveData<String> = MutableLiveData()
    val shouldShowError: LiveData<String> = error
    private val person: MutableLiveData<Person> = MutableLiveData()
    val personLiveData: LiveData<Person> = person

    fun createPerson(
        name: String?,
        age: String?,
        email: String?,
        password: String?,
        gender: String?
    ) {
        if (name.isNullOrBlank()) error.value = "O campo nome não pode ser vazio!"
        else if (email.isNullOrBlank()) error.value = "O campo email não pode ser vazio!"
        else if (password.isNullOrBlank()) error.value = "O campo senha não pode ser vazio!"
        else if (age.isNullOrBlank()) error.value = "O campo idade não pode ser vazio!"
        else if (gender.isNullOrBlank()) error.value = "O campo gênero não pode ser vazio!"
        else {
            val personCreated = Person(
                name = name,
                age = age,
                email = email,
                password = password,
                gender = gender
            )
            person.value = personCreated
        }
    }
}