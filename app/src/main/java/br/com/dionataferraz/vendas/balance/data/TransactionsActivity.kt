package br.com.dionataferraz.vendas.balance.data

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.dionataferraz.vendas.TransactionAdapter
import br.com.dionataferraz.vendas.TransactionsViewModel
import br.com.dionataferraz.vendas.databinding.ActivityTransactionsBinding


class TransactionsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTransactionsBinding
    private lateinit var viewModel: TransactionsViewModel

    private val adapterTransaction: TransactionAdapter by lazy {
        TransactionAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTransactionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = TransactionsViewModel()
//        viewModel.__CALLTEST()

        viewModel.transactionLiveData.observe(this) { transaction ->
            adapterTransaction.addList(
                transaction
            )
        }
    }
}