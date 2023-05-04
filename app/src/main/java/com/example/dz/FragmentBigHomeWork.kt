package com.example.dz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.dz.databinding.FragmentBigHomeWorkBinding
import com.example.dz.viewModels.DataModel

class FragmentBigHomeWork : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    private lateinit var binding: FragmentBigHomeWorkBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBigHomeWorkBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataModel.description.observe(activity as LifecycleOwner, {
            binding.homeWork.text = it
        })
        dataModel.nameItem.observe(activity as LifecycleOwner, {
            binding.bigSubject.text = it
        })
    }
}