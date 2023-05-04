package com.example.dz

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.dz.constants.Constants
import com.example.dz.databinding.FragmentAdminDoHomeWorkBinding
import com.example.dz.firebase.User
import com.example.dz.viewModels.DataModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FragmentAdminDoHomeWork : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    private lateinit var binding: FragmentAdminDoHomeWorkBinding
    private lateinit var mBase: DatabaseReference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAdminDoHomeWorkBinding.inflate(inflater)
        mBase = FirebaseDatabase.getInstance().getReference(Constants.USER_KEY)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bCreate.setOnClickListener { addRasp() }
    }
    private fun addRasp(){
        val id = mBase.key.toString()
        var name = "name"
        val theme = binding.edTheme.text.toString()
        val date = binding.edDate.text.toString()
        val description = binding.edExercise.text.toString()

        dataModel.adminItem.observe(activity as LifecycleOwner, {
            name = it
        })

        val user = User(id = id, date = date, name = name, description = description, theme = theme)

            if (!TextUtils.isEmpty(binding.edDate.text) &&
                !TextUtils.isEmpty(binding.edTheme.text) &&
                !TextUtils.isEmpty(binding.edExercise.text)) {

                mBase.push().setValue(user)
                Toast.makeText(requireContext(), "Сохранено", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_SHORT).show()
            }

    }
}