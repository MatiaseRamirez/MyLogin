package com.example.activityhome

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.activityhome.fragments.CardFragment
import com.example.activityhome.fragments.AddresFragment
import com.example.activityhome.fragments.ClaimsFragment
import com.example.activityhome.fragments.FavoritesFragment
import com.example.activityhome.fragments.PhoneFragment
import com.google.android.material.navigation.NavigationView
import mylogin.com.MainActivity
import mylogin.com.R
import mylogin.com.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar=binding.toolbarHome
        setSupportActionBar(toolbar)

        drawerLayout =binding.drawerLayout
        toggle=ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_drawer_home_open,R.string.nav_drawer_home_close)
        drawerLayout.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)

       val navigationView = binding.navigationViewHome
        navigationView.setNavigationItemSelectedListener(this)



    }



    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_item_cards -> {
                replaceFragment(CardFragment())
            }

            R.id.nav_item_addres -> {
                replaceFragment(AddresFragment())
            }

            R.id.nav_item_phone -> {
                replaceFragment(PhoneFragment())
            }
            R.id.nav_item_favorites -> {
            replaceFragment(FavoritesFragment())
            }
            R.id.nav_item_claims -> {
                replaceFragment(ClaimsFragment())
            }

            R.id.nav_item_singoff -> {
                Toast.makeText(this, "Cerrando Sesion", Toast.LENGTH_SHORT).show()
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()
    }

}
