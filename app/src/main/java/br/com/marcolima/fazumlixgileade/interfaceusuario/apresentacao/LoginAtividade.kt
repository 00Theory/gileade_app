package br.com.marcolima.fazumlixgileade.interfaceusuario.apresentacao

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.cardview.widget.CardView
import br.com.marcolima.fazumlixgileade.R

class LoginAtividade : ComponentActivity() {
    lateinit var dataNascimento: EditText
    lateinit var cpf: EditText
    lateinit var btnlogin: Button
    lateinit var btnvoltar: ImageView
    lateinit var cardView: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        pegarViews()
        formatacaoEditTexts()
        cadastrar()
        cardView.cardElevation = 50f
    }

    fun pegarViews() {
        //cpf = findViewById(R.id.cadastro_cpf)
        //dataNascimento = findViewById(R.id.cadastro_nascimento)
        btnlogin = findViewById(R.id.botao_login)
        btnvoltar = findViewById(R.id.x_fechar)
        cardView = findViewById(R.id.cv_cadastro)
    }

    fun formatacaoEditTexts() {
        //cpf.addTextChangedListener(Mask.mask("###.###.###-##", cpf))
        //dataNascimento.addTextChangedListener(Mask.mask("##/##/####", dataNascimento))
    }

    fun cadastrar() {
        btnlogin.setOnClickListener {
            startActivity(Intent(this, TelaPrincipal::class.java))
        }
        btnvoltar.setOnClickListener{
            finish()
        }
    }
}