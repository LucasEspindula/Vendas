package br.com.dionataferraz.vendas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.dionataferraz.vendas.databinding.ActivityAccountBinding

class AccountActivity : AppCompatActivity() {
    lateinit var binding: ActivityAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureActionBar()
    }

    private fun configureActionBar(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}