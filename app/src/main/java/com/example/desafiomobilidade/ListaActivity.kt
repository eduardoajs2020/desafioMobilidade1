package com.example.desafiomobilidade

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView


class TuplaAdapter(private val context: Context, private val tuplas: List<Tupla>) :
    RecyclerView.Adapter<TuplaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_tupla, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tupla = tuplas[position]
        holder.bind(tupla)
    }

    override fun getItemCount(): Int {
        return tuplas.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvApelido: TextView = itemView.findViewById(R.id.tv_apelido)
        private val tvPat: TextView = itemView.findViewById(R.id.tv_pat)

        fun bind(tupla: Tupla) {
            tvApelido.text = tupla.apelido
            tvPat.text = tupla.pat.toString()
        }
    }
}

data class Tupla(val apelido: String, val pat: Any)

class MainActivity1 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

}
