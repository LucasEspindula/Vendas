package br.com.dionataferraz.vendas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.com.dionataferraz.vendas.databinding.ActivityTestingProfileBinding
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class TestingProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTestingProfileBinding

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
            .adapter(Person::class.java)

        findViewById<TextView>(R.id.test).apply {
            val personFromSharedPreferences = sharedPreferences.getString("Person", null)
            val personFromAdapter = adapter.fromJson(
                personFromSharedPreferences
            )
            if (personFromAdapter != null)
                text = "   ${personFromAdapter.name} ${personFromAdapter.age} " +
                        "${personFromAdapter.email} ${personFromAdapter.password} ${personFromAdapter.gender}"
        }
    }
}