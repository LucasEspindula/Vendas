package br.com.dionataferraz.vendas.balance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.dionataferraz.vendas.balance.data.local.TypeDeposit
import br.com.dionataferraz.vendas.databinding.ActivityTransactionUnSetBinding
import java.util.*

class TransactionUnSetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTransactionUnSetBinding
    private lateinit var viewModel: TransactionUnSetViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionUnSetBinding.inflate(layoutInflater)
        viewModel = TransactionUnSetViewModel()

        val view = binding.root
        setContentView(view)

        binding.btDeposit.setOnClickListener{
            viewModel.newTransaction(
                Date(),
                binding.etValue.text.toString(),
                TypeDeposit.Deposit
            )
        }

        binding.btDeposit.setOnClickListener{
            viewModel.newTransaction(
                Date(),
                binding.etValue.text.toString(),
                TypeDeposit.Withdraw
            )
        }
    }
}