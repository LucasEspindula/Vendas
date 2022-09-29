package br.com.dionataferraz.vendas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.com.dionataferraz.vendas.balance.data.__TransactionsActivity
import br.com.dionataferraz.vendas.balance.data.local.BalanceActivity
import br.com.dionataferraz.vendas.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityHomeBinding.inflate(layoutInflater).run {
            binding = this
            setContentView(root)
        }

        binding.btNovaConta.setOnClickListener {
            val intent = Intent(this, AccountActivity::class.java)
            startActivity(intent)
        }

        binding.btListaTransacoes.setOnClickListener {
            val intent = Intent(this, BalanceActivity::class.java)
            startActivity(intent)
        }

        val makeBalanceClickable: TextView = findViewById(R.id.tv_account_balance)
        makeBalanceClickable.setOnClickListener {
            val intent = Intent(this, __TransactionsActivity::class.java)
            startActivity(intent)
        }


    }
}