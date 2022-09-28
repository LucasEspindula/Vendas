package br.com.dionataferraz.vendas

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.dionataferraz.vendas.databinding.ActivityTransactionsBinding
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.lang.reflect.Type
import java.util.*


class __TransactionsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTransactionsBinding
    private lateinit var viewModel: TransactionsViewModel

    private val adapterTransaction: TransactionAdapter by lazy {
        TransactionAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTransactionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rcList.adapter = adapterTransaction

        viewModel = TransactionsViewModel()
        viewModel.callTransactionList()

        viewModel.transactionLiveData.observe(this) { transaction ->

            val sharedPreferences = getSharedPreferences(
                "Transaction",
                MODE_PRIVATE
            )

            var transactionShared = sharedPreferences
                .getString(
                    "Transaction",
                    null
                )

            val transactionToJson = moshiAdapterFunc()
                .toJson(
                    transaction
                )

            if (transactionShared.isNullOrBlank()) {
                sharedPreferences
                    .edit()
                    .putString("Transaction", transactionToJson)
                    .apply()

                transactionShared = sharedPreferences
                    .getString("Transaction", null)
            }

            val listTransactionJson = transactionShared?.let {
                moshiAdapterFunc().fromJson(it)
            }

            if (listTransactionJson != null) {
                adapterTransaction.addList(
                    listTransactionJson
                )
            } else Toast.makeText(
                this,
                "NÃO CAIU NO IFZIN LEK PELOAMORDIDEUZ",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun moshiAdapterFunc(): JsonAdapter<List<__TransactionModel>> {
        val moshi = Moshi
            .Builder()
            .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
            .addLast(KotlinJsonAdapterFactory())
            .build()

        val listMyData: Type = Types.newParameterizedType(
            List::class.java,
            __TransactionModel::class.java
        )

        return moshi.adapter(listMyData)
    }
}