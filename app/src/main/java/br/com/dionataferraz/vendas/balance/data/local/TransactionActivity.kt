package br.com.dionataferraz.vendas.balance.data.local

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import br.com.dionataferraz.vendas.databinding.ActivityBalanceBinding

class TransactionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBalanceBinding
    private lateinit var viewModel: TransactionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBalanceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = TransactionViewModel()

        binding.btSave.setOnClickListener {

            val radioGroup: RadioGroup = binding.transactionRB
            val radioButtonSelected: Int = radioGroup.checkedRadioButtonId
            val radioButton: RadioButton = findViewById(radioButtonSelected)
            val type: String = radioButton.text.toString()
            var setType = TransactionType.MARKET

            when (type) {
                "Market" -> setType = TransactionType.MARKET
                "Gas station" -> setType = TransactionType.GAS_STATION
                "Pub" -> setType = TransactionType.PUB
            }

            viewModel.createTransaction(
                value = binding.etValue.text.toString(),
                description = binding.etDescription.text.toString(),
                type = setType
            )
        }

        viewModel.shouldShowError.observe(this) { shouldShow ->
            if (shouldShow != null) {
                Toast.makeText(
                    this,
                    shouldShow,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}