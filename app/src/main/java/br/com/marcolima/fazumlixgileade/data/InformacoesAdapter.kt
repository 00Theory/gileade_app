package br.com.marcolima.fazumlixgileade.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.marcolima.fazumlixgileade.R
import br.com.marcolima.fazumlixgileade.dominio.LixoEletronico

class InformacoesAdapter(private val lixos: List<LixoEletronico>) : RecyclerView.Adapter<InformacoesAdapter.ViewHolder>(){

    // Cria uma nova View
    override fun onCreateViewHolder (parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.texto_inicio, parent, false)
        return ViewHolder(view)
    }

    // Pega o conteúdo da View e troca pela informação de item de uma lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fragment1.text = lixos[position].texto1
    }

    // pega a quantidade da lista
    override fun getItemCount(): Int = lixos.size

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val fragment1 : TextView
        init {
            fragment1 = view.findViewById(R.id.texto_inicio)

        }
    }

}