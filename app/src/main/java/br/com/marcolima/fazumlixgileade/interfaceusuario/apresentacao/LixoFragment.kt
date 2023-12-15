package br.com.marcolima.fazumlixgileade.interfaceusuario.apresentacao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.marcolima.fazumlixgileade.R

class LixoFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.texto1_fragment, container, false)
    }

}