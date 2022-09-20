package br.com.dionataferraz.vendas

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
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

        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Account"

        val sharedPreferences = getSharedPreferences(
            "Account",
            MODE_PRIVATE
        )

        val moshi = Moshi
            .Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()

        val adapter = moshi
            .adapter(AccountModel::class.java)

        fun callTestingAccountActivity() {
            val intent = Intent(this,TestingAccountActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.confirmFloatingButton.setOnClickListener {
            val radioGroup: RadioGroup = binding.accountRB
            val radioButtonSelected: Int = radioGroup.checkedRadioButtonId
            val radioButton: RadioButton = findViewById(radioButtonSelected)

            val name = binding.descriptionET.text.toString()
            val value = binding.valueET.text.toString()
            val responsible = binding.responsibleET.text.toString()
            val type: String = radioButton.text.toString()

            viewModel.createAccount(
                name,
                value,
                responsible,
                type
            )
        }

        viewModel.accountLiveData.observe(this) {
                account ->
            val edit = sharedPreferences.edit()

            val accountSave = adapter.toJson(account)
            edit.putString("Account", accountSave)
            edit.apply()

            callTestingAccountActivity()
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
                    "Account created successfully!",
                    Toast.LENGTH_LONG
                )
            }
        }
    }
}