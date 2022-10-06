package br.com.dionataferraz.vendas.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.dionataferraz.vendas.account.AccountActivity
import br.com.dionataferraz.vendas.balance.TransactionsActivity
import br.com.dionataferraz.vendas.balance.data.local.BalanceActivity
import br.com.dionataferraz.vendas.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = HomeViewModel()
        viewModel.attBalance()

        viewModel.homeLiveData.observe(this) { balance ->
            balance.toString().also { binding.tvAccountBalance.text = it }
        }

        binding.btNovaConta.setOnClickListener {
            Intent(this, AccountActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btListaTransacoes.setOnClickListener {
            Intent(this, BalanceActivity::class.java).also {
                startActivity(it)
            }
            recreate()
        }

        binding.tvAccountBalance.setOnClickListener {
            Intent(this, TransactionsActivity::class.java).also {
                startActivity(it)
            }
            recreate()
        }
    }
}