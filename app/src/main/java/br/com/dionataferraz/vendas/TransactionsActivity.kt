package br.com.dionataferraz.vendas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.dionataferraz.vendas.databinding.ActivityTransactionsBinding
import java.util.*

class TransactionsActivity : AppCompatActivity(), TransactionAdapter.Listener {

    private lateinit var binding: ActivityTransactionsBinding

    private val adapter: TransactionAdapter by lazy {
        TransactionAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTransactionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rcList.adapter = adapter
        adapter.addList(
            getTransactionList()
        )
    }

    override fun onItemClick(text: String) {
        Toast.makeText(
            this,
            text,
            Toast.LENGTH_LONG
        ).show()
    }

    private fun getTransactionList(): List<TransactionModel> {
        return listOf(
            TransactionModel(
                date = Calendar.getInstance().time,
                value = 10.90,
                description = "Max super",
                transactionType = TransactionType.MARKET
            ),
            TransactionModel(
                date = Calendar.getInstance().time,
                value = 15.10,
                description = "Posto alvorada",
                transactionType = TransactionType.GAS_STATION
            ),
            TransactionModel(
                date = Calendar.getInstance().time,
                value = 12.50,
                description = "Garrison",
                transactionType = TransactionType.PUB
            )
        )
    }
}