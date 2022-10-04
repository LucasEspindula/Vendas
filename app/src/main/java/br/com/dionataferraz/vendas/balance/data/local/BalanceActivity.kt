package br.com.dionataferraz.vendas.balance.data.local

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.dionataferraz.vendas.databinding.ActivityBalanceBinding

class BalanceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBalanceBinding
    private lateinit var viewModel: BalanceViewModel

    private val database: VendasDatabase by lazy {
        VendasDatabase.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBalanceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = BalanceViewModel()

        binding.btDeposit.setOnClickListener {
            viewModel.depositBalanceViewModel(
                binding.etValue.text.toString()
            )
        }

        binding.btWithdraw.setOnClickListener {
            viewModel.withdrawBalanceViewModel(
                binding.etValue.text.toString()
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