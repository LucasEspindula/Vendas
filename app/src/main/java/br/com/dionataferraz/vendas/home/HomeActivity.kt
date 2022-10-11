package br.com.dionataferraz.vendas.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.dionataferraz.vendas.balance.TransactionsListActivity
import br.com.dionataferraz.vendas.balance.data.local.TransactionActivity
import br.com.dionataferraz.vendas.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = HomeViewModel()

        binding = ActivityHomeBinding.inflate(layoutInflater).apply {
            data = viewModel
        }

        setContentView(binding.root)

        viewModel.attNameHome()
        viewModel.homeNameLiveData.observe(this) { attNameHome ->
//             binding.tvNameAccount.text = attNameHome
            Log.e(" ::::::::::: ", attNameHome)
        }

        viewModel.attBalanceHome()
        viewModel.homeBalanceLiveData.observe(this) { attBalanceHome ->
            binding.tvAccountBalance.text = attBalanceHome
        }

        binding.btNewTransacoes.setOnClickListener {
            Intent(this, TransactionActivity::class.java).also {
                startActivity(it)
            }
            recreate()
        }

        binding.tvAccountBalance.setOnClickListener {
            Intent(this, TransactionsListActivity::class.java).also {
                startActivity(it)
            }
            recreate()
        }
    }
}