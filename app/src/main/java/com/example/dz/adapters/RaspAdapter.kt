package com.example.dz.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dz.R
import com.example.dz.databinding.CardviewRecyclerBinding
import com.example.dz.firebase.User
import com.example.dz.screens.Fragment_rasp

class RaspAdapter(private val rasp_frag: Fragment_rasp): RecyclerView.Adapter<RaspAdapter.ReadHolder>() {
    private val listRead = ArrayList<User>()
    class ReadHolder(item: View): RecyclerView.ViewHolder(item){
        val binding = CardviewRecyclerBinding.bind(item)
        fun bind(new: User) = with(binding){
            subjectHomework.text = new.name
            dataTime.text = new.date
            briefHomework.text = new.theme
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReadHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_recycler, parent, false)
        return ReadHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ReadHolder, position: Int) {
        holder.bind(listRead[position])
        holder.binding.cardView.setOnClickListener{
            rasp_frag.setOnItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return listRead.size
    }
    fun getUser(user: User){
        listRead.add(user)
        notifyDataSetChanged()
    }
    fun clearAdapter(){
        listRead.clear()
    }
}