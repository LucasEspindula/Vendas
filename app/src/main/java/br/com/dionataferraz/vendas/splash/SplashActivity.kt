package br.com.dionataferraz.vendas.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import br.com.dionataferraz.vendas.databinding.ActivitySplashBinding
import br.com.dionataferraz.vendas.home.HomeActivity
import br.com.dionataferraz.vendas.login.LoginActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = SplashViewModel()
        viewModel.verifyUserExists()

        Handler().postDelayed({
            viewModel.splashLiveData.observe(this) { ResultModel ->
                if (!ResultModel) {
                    Intent(this, HomeActivity::class.java).also {
                        startActivity(it)
                    }
                } else {
                    Intent(this, LoginActivity::class.java).also {
                        startActivity(it)
                    }
                }
            }
            finish()
        }, 3000)
    }
}