package br.com.dionataferraz.vendas

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import br.com.dionataferraz.vendas.databinding.ActivityAccountBinding
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class AccountActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAccountBinding
    private lateinit var viewModel: AccountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        binding = ActivityAccountBinding.inflate(layoutInflater)
        viewModel = AccountViewModel()

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

        binding.confirmFloatingButton.setOnClickListener {
            val radioGroup: RadioGroup = binding.accountRB
            val radioButtonSelected: Int = radioGroup.checkedRadioButtonId
            val radioButton: RadioButton? = findViewById(radioButtonSelected)

            val nameAccount = binding.descriptionET.text.toString()
            val accountValue = binding.valueET.text.toString()
            val accountResponsible = binding.responsibleET.text.toString()
            val accountRB: String = radioButton?.text.toString()

            viewModel.createAccount(
                nameAccount,
                accountValue,
                accountResponsible,
                accountRB
            )

            viewModel.accountLiveData.observe(this) { account ->
                val edit = sharedPreferences.edit()

                val personSave = adapter.toJson(account)
                edit.putString("Person", personSave)
                edit.apply()

                callTestingProfileActivity()
            }
        }
    }

    private fun configureActionBar(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}