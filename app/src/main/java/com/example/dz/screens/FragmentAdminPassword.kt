package com.example.dz.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.dz.R

class FragmentAdminPassword : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_admin_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button2).setOnClickListener {
            if (view.findViewById<EditText>(R.id.editTextPasswordAdmin).text.toString() == "адМин123"){
                findNavController().navigate(R.id.action_fragmentAdminPassword_to_fragment_category_admin2)
            }
            else{
                Toast.makeText(requireContext(), "Неверный пароль", Toast.LENGTH_SHORT).show()
            }
        }
    }
}