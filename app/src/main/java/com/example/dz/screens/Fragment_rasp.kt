package com.example.dz.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dz.R
import com.example.dz.adapters.RaspAdapter
import com.example.dz.constants.Constants
import com.example.dz.databinding.FragmentRaspBinding
import com.example.dz.firebase.User
import com.example.dz.viewModels.DataModel
import com.google.firebase.database.*


class Fragment_rasp : Fragment() {

    private lateinit var listName: MutableList<String>
    private lateinit var listDescription: MutableList<String>

    private lateinit var listData: MutableList<String>
    private lateinit var listener: Listener
    private lateinit var mBase: DatabaseReference
    private lateinit var binding: FragmentRaspBinding

    private val adapter = RaspAdapter(this)
    private val dataModel: DataModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        listName = ArrayList()
        listDescription = ArrayList()

        listener = Listener()
        listData = ArrayList()

        mBase = FirebaseDatabase.getInstance().getReference(Constants.USER_KEY)
        mBase.addValueEventListener(listener)

        binding = FragmentRaspBinding.inflate(inflater)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.clearAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

    }
    inner class Listener: ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {

            if (listData.size > 0) listData.clear()

            for(ds in snapshot.children){
                val user = ds.getValue(User::class.java)
                assert(user != null)
                listData.add(user!!.id)
                adapter.getUser(user)

                listName.add("${user.name}(${user.date})")
                listDescription.add(user.description)
            }
        }
        override fun onCancelled(error: DatabaseError){}
    }
    fun setOnItemClick(position: Int) {
        //onClick
        dataModel.nameItem.value = listName[position]
        dataModel.description.value = listDescription[position]

        findNavController().navigate(R.id.action_fragment_rasp2_to_fragmentBigHomeWork)
    }
}