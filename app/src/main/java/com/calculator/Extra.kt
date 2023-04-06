package com.calculator

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_extra.*

class Extra : AppCompatActivity() {

    private lateinit var notes: MutableList<Note>
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var adapter: NoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extra)
        val message = intent.getStringExtra("result")
        sharedPreferences = getSharedPreferences("MyNotes", Context.MODE_PRIVATE)
        notes = loadNotes()
        edit_text.setText(message)


        val recyclerView = findViewById<RecyclerView>(R.id.notes_list)

        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL)
        recyclerView.addItemDecoration(dividerItemDecoration)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = NoteAdapter(notes)
        recyclerView.adapter = adapter

        save_button.setOnClickListener {
            val text = edit_text.text.toString()
            if (text.isNotBlank()) {
                notes.add(Note(text))
                adapter.notifyItemInserted(notes.lastIndex)
                edit_text.text.clear()
                saveNotes(notes)
            }
        }

    }


    private fun saveNotes(notes: List<Note>) {
        val editor = sharedPreferences.edit()
        val jsonNotes = Gson().toJson(notes)
        editor.putString("notes", jsonNotes)
        editor.apply()
    }

    private fun loadNotes(): MutableList<Note> {
        val jsonNotes = sharedPreferences.getString("notes", "[]")
        val type = object : TypeToken<List<Note>>() {}.type
        return Gson().fromJson(jsonNotes, type)
    }


    private class NoteAdapter(private val notes: MutableList<Note>) :
        RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

        fun removeAt(position: Int) {
            notes.removeAt(position)
            notifyItemRemoved(position)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val note = notes[position]
            holder.text.text = note.text
        }

        override fun getItemCount() = notes.size

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val text: TextView = itemView.findViewById(R.id.note_text)
            val deleteButton: Button = itemView.findViewById(R.id.delete_button)

            init {
                deleteButton.setOnClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        (itemView.context as Extra).adapter.removeAt(position)
                        (itemView.context as Extra).saveNotes((itemView.context as Extra).notes)
                    }
                }
            }
        }
    }
}