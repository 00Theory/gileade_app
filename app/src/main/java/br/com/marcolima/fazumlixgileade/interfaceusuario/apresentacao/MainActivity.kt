package br.com.marcolima.fazumlixgileade.interfaceusuario.apresentacao

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import br.com.marcolima.fazumlixgileade.R
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager2: ViewPager2
    lateinit var botaoPular : TextView
    lateinit var botaoInicio : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inicio_tela)
        pegarViews()
        formatacaoEditTexts()
        setupTabs()
        voltarPagina()
    }

    fun pegarViews(){
        tabLayout = findViewById(R.id.tab_layout)
        viewPager2 = findViewById(R.id.vp_view_pager)
        botaoPular = findViewById(R.id.proximo_intro)
        botaoInicio = findViewById(R.id.inicio_intro)
    }

    fun formatacaoEditTexts(){
        //cpf.addTextChangedListener(Mask.mask("###.###.###-##", cpf))
        //dataNascimento.addTextChangedListener(Mask.mask("##/##/####", dataNascimento))
    }

    fun setupTabs(){
        val tabsAdapter = TabAdapter(this)
        viewPager2.adapter = tabsAdapter

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let { viewPager2.currentItem = it.position
                when (it.position){
                    0 -> {
                        botaoInicio.setTextColor(Color.parseColor("#55555555"))
                        botaoPular.text = "Próximo"
                    }
                    1 -> {
                        botaoInicio.setTextColor(Color.parseColor("#333333"))
                        botaoPular.text = "Próximo"
                    }
                    2 -> {
                        botaoInicio.setTextColor(Color.parseColor("#333333"))
                    }
                    }
                    if (viewPager2.currentItem == 2){
                        botaoPular.text = "Continuar"
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                //tab?.let { viewPager2.currentItem = it.position }
                //tabLayout.getTabAt(viewPager2.currentItem)?.setIcon(R.drawable.ponto_padrao)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.getTabAt(position)?.select()
            }
        })
    }

    fun voltarPagina(){

        botaoPular.setOnClickListener{
            //startActivity(Intent(this, LoginAtividade::class.java))
            when (viewPager2.currentItem){
                0 -> viewPager2.currentItem++
                1 -> viewPager2.currentItem++
                2 -> startActivity(Intent(this, TelaPrincipal::class.java))
            }
        }

        botaoInicio.setOnClickListener{
            viewPager2.currentItem--
            botaoPular.text = "Próximo"
        }
    }

}


