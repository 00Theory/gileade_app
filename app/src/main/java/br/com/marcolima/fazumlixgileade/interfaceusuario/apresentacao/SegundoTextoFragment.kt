package br.com.marcolima.fazumlixgileade.interfaceusuario.apresentacao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.marcolima.fazumlixgileade.R

class SegundoTextoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.texto2_fragment, container, false)    }
}