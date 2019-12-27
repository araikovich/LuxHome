package araikovich.inc.sales.luxhome

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import araikovich.inc.sales.luxhome.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navHost: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        navHost = Navigation.findNavController(this, R.id.nav_host)
        binding.bottomNavigation.setupWithNavController(navHost)
    }
}
