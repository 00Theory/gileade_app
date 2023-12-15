package br.com.marcolima.fazumlixgileade.interfaceusuario.apresentacao

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import br.com.marcolima.fazumlixgileade.R


class TelaPrincipal : AppCompatActivity(){
    lateinit var botaoLIX : CardView
    lateinit var botaoMapa : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_principal)
        setupViews()
        botaoLix()
        botaoMapa()
    }


    fun setupViews(){
        botaoLIX = findViewById<CardView>(R.id.card_lix)
        botaoMapa = findViewById<CardView>(R.id.card_mapa)
    }

    fun botaoLix() {
        botaoLIX.setOnClickListener {
            startActivity(Intent(this, LixTela::class.java))
        }
    }

    fun botaoMapa() {
        botaoMapa.setOnClickListener {
            startActivity(Intent(this, Mapa::class.java))
        }
    }
}