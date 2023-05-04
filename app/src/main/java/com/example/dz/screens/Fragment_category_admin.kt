package com.example.dz.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.dz.R
import com.example.dz.databinding.FragmentCategoryAdminBinding
import com.example.dz.viewModels.DataModel

class Fragment_category_admin : Fragment() {
    private lateinit var binding: FragmentCategoryAdminBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCategoryAdminBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAdminMath.setOnClickListener {
            dataModel.adminItem.value = "Математика"
            findNavController().navigate(R.id.action_fragment_category_admin_to_fragmentAdminDoHomeWork)
        }
        binding.buttonAdminRussianLang.setOnClickListener {
            dataModel.adminItem.value = "Русский язык"
            findNavController().navigate(R.id.action_fragment_category_admin_to_fragmentAdminDoHomeWork)
        }
        binding.buttonAdminEnglishLang.setOnClickListener {
            dataModel.adminItem.value = "Английский язык"
            findNavController().navigate(R.id.action_fragment_category_admin_to_fragmentAdminDoHomeWork)
        }
        binding.buttonAdminPhizicks.setOnClickListener {
            dataModel.adminItem.value = "Физика"
            findNavController().navigate(R.id.action_fragment_category_admin_to_fragmentAdminDoHomeWork)
        }
        binding.buttonAdminInformation.setOnClickListener {
            dataModel.adminItem.value = "Информатика"
            findNavController().navigate(R.id.action_fragment_category_admin_to_fragmentAdminDoHomeWork)
        }
        binding.buttonAdminPCulture.setOnClickListener {
            dataModel.adminItem.value = "Физическая культура"
            findNavController().navigate(R.id.action_fragment_category_admin_to_fragmentAdminDoHomeWork)
        }
        binding.buttonAdminProf.setOnClickListener {
            dataModel.adminItem.value = "Введение в профессию"
            findNavController().navigate(R.id.action_fragment_category_admin_to_fragmentAdminDoHomeWork)
        }
        binding.buttonAdminHistory.setOnClickListener {
            dataModel.adminItem.value = "История"
            findNavController().navigate(R.id.action_fragment_category_admin_to_fragmentAdminDoHomeWork)
        }
    }
}