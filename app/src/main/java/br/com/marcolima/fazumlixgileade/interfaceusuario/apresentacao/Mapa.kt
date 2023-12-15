package br.com.marcolima.fazumlixgileade.interfaceusuario.apresentacao

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.compose.material3.FloatingActionButtonDefaults
import br.com.marcolima.fazumlixgileade.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions

class Mapa : AppCompatActivity(), OnMapReadyCallback {

lateinit var botaoSair : ImageView

    private val lugares = arrayListOf(
        Lugar("Expo Favela Brasil", LatLng(-23.510506220630404, -46.61194983565848), "Rua José Bernardo Pinto, 333 - Vila Guilherme, São Paulo - SP, 02055-000", 4.9f),
        Lugar("Inovação Gileade", LatLng(-1.4117621418713733, -48.39291721348775), "Conj. Verdejante III, Q. 15, N° 18 - Águas Lindas, Belém - PA, 66690-560", 5.0f)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mapa)

        botaoSair = findViewById(R.id.botao_sair_mapa)

        sairMapa()
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapa_fragment) as SupportMapFragment
        mapFragment.getMapAsync { googleMap -> onMapReady(googleMap)
            googleMap.setOnMapLoadedCallback {
                val limites = LatLngBounds.builder()

                lugares.forEach{
                    limites.include(it.latLng)
                }

                googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(limites.build(), 100))
            }
        }
    }

    fun sairMapa(){
        botaoSair.setOnClickListener {
            finish()
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        lugares.forEach{
            googleMap.addMarker(
                MarkerOptions()
                    .title(it.nome)
                    .snippet(it.endereco)
                    .position(it.latLng)
            )
        }
    }
}

data class Lugar(
    val nome : String,
    val latLng: LatLng,
    val endereco : String,
    val rating: Float
)