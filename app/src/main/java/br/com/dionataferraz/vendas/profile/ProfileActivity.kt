package br.com.dionataferraz.vendas.profile

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.dionataferraz.vendas.R
import br.com.dionataferraz.vendas.databinding.ActivityProfileBinding
import br.com.dionataferraz.vendas.login.LoginActivity

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var viewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        viewModel = ProfileViewModel()

        setContentView(binding.root)

        binding.btClear.setOnClickListener {
            binding.etName.text = null
            binding.etEmail.text = null
            binding.etPassword.text = null
        }

        binding.btSave.setOnClickListener {
            viewModel.createPerson(
                name = binding.etName.text.toString(),
                email = binding.etEmail.text.toString(),
                password = binding.etPassword.text.toString()
            )
        }

        viewModel.userCreatedLiveData.observe(this) { userCreated ->
            if (userCreated) {
                Intent(this, LoginActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }

        viewModel.shouldShowMessage.observe(this) { shouldShow ->
            if (!shouldShow.isNullOrBlank()) {
                Toast.makeText(
                    this,
                    shouldShow,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}