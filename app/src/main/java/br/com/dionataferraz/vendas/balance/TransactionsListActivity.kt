package br.com.dionataferraz.vendas.balance

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import br.com.dionataferraz.vendas.databinding.ActivityTransactionsBinding
import br.com.dionataferraz.vendas.model.TransactionModel

class TransactionsListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTransactionsBinding
    private lateinit var viewModel: TransactionsListViewModel

    private val adapterTransaction: TransactionsListAdapter by lazy {
        TransactionsListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTransactionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = TransactionsListViewModel()
        viewModel.callTransactions()

        viewModel.transactionsLiveData.observe(this) { transactions ->
            if (transactions != null && transactions.isNotEmpty()) {
                val transactionsMapper = transactions.map {
                    TransactionModel(
                        id = it.id,
                        value = it.value,
                        description = it.description,
//                        transactionDate = it.transactionDate,
                        transactionType = it.transactionType
                    )
                }

                Log.e(" LIST :::: ", transactionsMapper.toString())
                binding.rcList.adapter = adapterTransaction
                adapterTransaction.addList(transactionsMapper)
            }
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

        val itemTouchHelper = ItemTouchHelper(swipeDeletedTransaction())
        itemTouchHelper.attachToRecyclerView(binding.rcList)
    }

    private fun swipeDeletedTransaction(): ItemTouchHelper.SimpleCallback {
        return object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {
                val position = viewHolder.adapterPosition
                val item = adapterTransaction.removeAt(index = position)
                viewModel.deleteTransactions(item.id)
            }
        }
    }
}