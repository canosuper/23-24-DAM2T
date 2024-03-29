package com.example.fragmentsantonio

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fragmentsantonio.databinding.FragmentFragmentoABinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentoA.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentoA : Fragment() {
    // TODO: Rename and change types of parameters


    private lateinit var binding: FragmentFragmentoABinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFragmentoABinding.inflate(inflater, container, false)
        val view = binding.root
        // Gets the data from the passed bundle
        val bundle = arguments
        val message = bundle!!.getString("variabe1")

        // Sets the derived data (type String) in the TextView
        binding.txtF1.text = message

        return view
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_fragmento_a, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //No tiene mucho sentido regargar elmimso Activity como hace este ejemplo, pero sí se podría ir a otro,así tenéis el código.
        //val boton: Button = view.findViewById<Button>(R.id.btnFA)
        binding.btnFA.setOnClickListener(){
//            val texto = requireActivity().findViewById<View>(R.id.edCaja) as EditText
//            texto.setText("Desde el fragment")
            val editProfileIntent = Intent(this.context, MainActivity::class.java)
            editProfileIntent.putExtra("ValorFromIntent","Desde Intent")
            startActivity(editProfileIntent)
            Toast.makeText(this.context,"Pulsado el botón de dentro del F1", Toast.LENGTH_SHORT).show()
        }
    }

}