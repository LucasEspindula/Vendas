package br.com.dionataferraz.vendas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import br.com.dionataferraz.vendas.databinding.ActivityBottomSheetBinding
import br.com.dionataferraz.vendas.fragments.HomeFragment
import br.com.dionataferraz.vendas.fragments.NotificationFragment
import br.com.dionataferraz.vendas.fragments.ProfileFragment

class BottomSheetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomSheetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navigation.setOnItemSelectedListener { menuItem ->
            onNavigationItemSelected(menuItem)
        }
        binding.navigation.selectedItemId = R.id.navigation_home
    }

    private fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_home -> {
                openFragment(HomeFragment.newInstance())
            }
            R.id.navigation_notification -> {
                openFragment(NotificationFragment.newInstance())
            }
            R.id.navigation_profile -> {
                openFragment(ProfileFragment.newInstance())
            }
        }
        return true
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
