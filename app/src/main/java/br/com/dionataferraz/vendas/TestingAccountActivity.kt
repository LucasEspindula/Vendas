package br.com.dionataferraz.vendas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class TestingAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testing_account)

        val sharedPreferences = getSharedPreferences(
            "Account",
            MODE_PRIVATE
        )

        val moshi = Moshi
            .Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()

        val adapter = moshi
            .adapter(AccountModel::class.java)

        findViewById<TextView>(R.id.testTextViewAccount).apply {
            val accountFromAdapter = adapter.fromJson(
                sharedPreferences.getString("Account", null)
            )
            if (accountFromAdapter != null)
                text =  "${accountFromAdapter.name} " +
                        "${accountFromAdapter.value} " +
                        "${accountFromAdapter.responsible} " +
                        "${accountFromAdapter.type}"
        }
    }
}