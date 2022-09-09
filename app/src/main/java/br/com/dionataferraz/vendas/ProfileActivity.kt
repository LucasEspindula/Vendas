package br.com.dionataferraz.vendas

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.dionataferraz.vendas.databinding.ActivityProfileBinding
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var viewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        viewModel = ProfileViewModel()

        val view = binding.root
        setContentView(view)

        val sharedPreferences = getSharedPreferences(
            "Profile",
            MODE_PRIVATE
        )

        val moshi = Moshi
            .Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()

        val adapter = moshi
            .adapter(Person::class.java)

        fun callTestingProfileActivity() {
            val intent = Intent(this, TestingProfileActivity::class.java)
            startActivity(intent)
            finish()
        }

        fun clearSharedPreferencesAndFields() {
            binding.etName.text = null
            binding.etAge.text = null
            binding.etEmail.text = null
            binding.etPassword.text = null
            binding.rg.clearCheck()

            sharedPreferences.edit().clear().apply()
        }

        binding.btSave.setOnClickListener {
            val radioGroup: RadioGroup = binding.rg
            val radioButtonSelected: Int = radioGroup.checkedRadioButtonId
            val radioButton: RadioButton? = findViewById(radioButtonSelected)

            val name = binding.etName.text.toString()
            val age = binding.etAge.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val option: String = radioButton?.text.toString()

            viewModel.createPerson(
                name,
                age,
                email,
                password,
                option
            )

            viewModel.personLiveData.observe(this) { person ->
                val edit = sharedPreferences.edit()

                val personSave = adapter.toJson(person)
                edit.putString("Person", personSave)
                edit.apply()

                callTestingProfileActivity()
            }
        }

        binding.btClear.setOnClickListener {
            clearSharedPreferencesAndFields()
            callTestingProfileActivity()
        }

        viewModel.shouldShowError.observe(this) { shouldShow ->
            if (shouldShow != null) {
                Toast.makeText(
                    this,
                    shouldShow,
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "Profile created successfully!",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}