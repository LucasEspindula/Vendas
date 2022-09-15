package br.com.dionataferraz.vendas.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.com.dionataferraz.vendas.R
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class TestingProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testing_profile)

        val sharedPreferences = getSharedPreferences(
            "Profile",
            MODE_PRIVATE
        )

        val moshi = Moshi
            .Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()

        val adapter = moshi
            .adapter(Profile::class.java)

        findViewById<TextView>(R.id.testTextViewProfile).apply {
            val personFromAdapter = sharedPreferences.getString("Person", null)?.let {
                adapter.fromJson(
                    it
                )
            }
            if (personFromAdapter != null)
                text =  "${personFromAdapter.name} " +
                        "${personFromAdapter.age} " +
                        "${personFromAdapter.email} " +
                        "${personFromAdapter.password} " +
                        "${personFromAdapter.option}"
        }
    }
}