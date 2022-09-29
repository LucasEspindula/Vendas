package br.com.dionataferraz.vendas.balance.data.local

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.dionataferraz.vendas.databinding.ActivityBalanceBinding
import br.com.dionataferraz.vendas.databinding.ActivityTransactionUnSetBinding
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
//        viewModel = TransactionUnSetViewModel()

        val view = binding.root
        setContentView(view)

        binding.btDeposit.setOnClickListener {
            viewModel.newTransaction(
//                Date(),
                binding.etValue.text.toString(),
                TypeDeposit.Deposit
            )
        }

        binding.btDeposit.setOnClickListener {
            viewModel.newTransaction(
//                Date(),
                binding.etValue.text.toString(),
                TypeDeposit.Withdraw
            )
        }

//        viewModel.shouldShowError.observe(this) { shouldShow ->
//            if (shouldShow != null) {
//                Toast.makeText(
//                    this,
//                    shouldShow,
//                    Toast.LENGTH_LONG
//                ).show()
//            }
//        }

        CoroutineScope(Dispatchers.IO).launch {

            database.DAO().insertBalance(
                BalanceEntity(
//                    date = Date(),
                    value = 10.50,
                    typeDeposit = TypeDeposit.Deposit
                )
            )

            val transactions = database.DAO().getTransactions()
            Log.e("DAO ::: ", transactions.toString())
        }
    }
}