package br.com.dionataferraz.vendas

import android.content.Intent
import android.os.Bundle
import android.text.Selection
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.dionataferraz.vendas.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        viewModel = LoginViewModel()

        val view = binding.root
        setContentView(view)

        binding.btLogin.setOnClickListener {
            viewModel.login(null, null)
            val intent  = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        fun TextView.makeLinks(vararg links: Pair<String, View.OnClickListener>) {
            val spannableString = SpannableString(this.text)
            for (link in links) {
                val clickableSpan = object : ClickableSpan() {
                    override fun onClick(view: View) {
                        Selection.setSelection((view as TextView).text as Spannable, 0)
                        view.invalidate()
                        link.second.onClick(view)
                    }
                }
                val startIndexOfLink = this.text.toString().indexOf(link.first)
                spannableString.setSpan(clickableSpan, startIndexOfLink, startIndexOfLink + link.first.length,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
            this.movementMethod = LinkMovementMethod.getInstance()
            this.setText(spannableString, TextView.BufferType.SPANNABLE)
        }

        binding.btRegistro.makeLinks(
            Pair("Registrar", View.OnClickListener {
                val intent  = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            })
        )

        viewModel.shouldShowError.observe(this) { shouldShow ->
            if (shouldShow){
                Toast.makeText(
                    this,
                    "Deu ruim",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}