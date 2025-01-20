package com.example.appsegundamano.view


import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.appsegundamano.viewModel.Preferencias
import com.example.appsegundamano.R
import com.example.appsegundamano.databinding.ActivityPantallaPrincipalBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class PantallaPrincipal : AppCompatActivity() {

    //binding
    private lateinit var binding: ActivityPantallaPrincipalBinding

    //tabLayout --> Para manejar las pantallas
    private lateinit var tabLayout: TabLayout

    //view pager2 --> donde se van a mostrar las pantallas
    private lateinit var viewPager: ViewPager2


    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //inicio la toolbar
        val toolbar: MaterialToolbar = binding.cabezaApp
        setSupportActionBar(toolbar)

        tabLayout = binding.tabLayout
        viewPager = binding.viewPager

        //Configuramos un ViewPager2 con los diferentes items
        viewPager.adapter = PagerAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) { tab, index ->
            tab.text = when (index) {
                0 -> {
                    "Popular"
                }

                1 -> {
                    "Moda"
                }

                2 -> {
                    "Deportes"
                }

                3 -> {
                    "Tecnologia"
                }

                else -> {
                    throw Resources.NotFoundException("Seleccione una posicion correcta")
                }
            }
        }.attach()

        //Autocomplete text view
        val products = resources.getStringArray(R.array.pantallas)
        //Array con las sugerencias del arrayAdapter
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, products)
        binding.autocompleteTextView.setAdapter(adapter)


        //Listener del autocomplete text view
        binding.autocompleteTextView.setOnItemClickListener { parent, view, position, id ->
            val pantallaAIr = parent.getItemAtPosition(position) as String

            val fragmentTransaction = supportFragmentManager.beginTransaction()

            when (pantallaAIr){
                "Popular" -> {
                    val intent = Intent(this, PantallaPrincipal::class.java)
                    intent.putExtra("item_seleccionado", pantallaAIr)
                    startActivity(intent)
                }
                "Moda" -> {
                    fragmentTransaction.replace(R.id.viewPager, FragmentModa())
                }
                "Deportes" -> {
                    fragmentTransaction.replace(R.id.viewPager, FragmentDeportes())
                }
                "Tecnología" -> {
                    fragmentTransaction.replace(R.id.viewPager, FragmentTecnologia())
                }
            }

        }



    }

    //Funcion para crear el menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mi_menu, menu)
        return true
    }

    //Funcion que da funcionalidad al menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            //Da funcionalidad a preferencias
            R.id.preferencias -> {
                //Te lleva al fragment de preferencias para cambiar el tema de fondo de color
                startActivity(Intent(this, Preferencias::class.java))
                true
            }
            //Te lleva a una pagina web
            R.id.acceso_pg_web -> {
                val webpage:Uri = Uri.parse("https://es.wallapop.com/")
                val webIntent:Intent = Intent(Intent.ACTION_VIEW, webpage)
                startActivity(webIntent)
                true
            }
            //Te lleva al activity AcercaDe2, simplemenete es una informacion sobre la aplicacion
            R.id.acerca_de -> {
                startActivity(Intent(this, AcercaDe2::class.java))
                true
            }
            //Controlamos por si hubiera algún error
            else -> {
                throw Resources.NotFoundException("Posicion no encontrada")
            }
        }
    }



}