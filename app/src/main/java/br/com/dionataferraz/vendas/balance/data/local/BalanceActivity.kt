package br.com.dionataferraz.vendas.balance.data.local

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.dionataferraz.vendas.databinding.ActivityBalanceBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

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
                binding.etValue.text.toString(),
            )
        }

        binding.btWithdraw.setOnClickListener {
            viewModel.withdrawBalanceViewModel(
                binding.etValue.text.toString(),
            )
        }
    }
}