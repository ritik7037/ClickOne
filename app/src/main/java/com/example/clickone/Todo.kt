package com.example.clickone

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import androidx.appcompat.app.AppCompatActivity

class Todo : AppCompatActivity() {
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var taskList: MutableList<Task>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        val taskListView = findViewById<ListView>(R.id.taskListView)
        val editTaskEditText = findViewById<EditText>(R.id.editTask)
        val addButton = findViewById<Button>(R.id.addButton)
        val sharedPreferences = getSharedPreferences("MyTasks", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        taskList = mutableListOf()
        taskAdapter = TaskAdapter(this, taskList)
        taskListView.adapter = taskAdapter

        addButton.setOnClickListener {
            val newTaskTitle = editTaskEditText.text.toString()
            if (newTaskTitle.isNotEmpty()) {
                val newTask = Task(newTaskTitle)
                taskList.add(newTask)
                taskAdapter.notifyDataSetChanged()
                editTaskEditText.text.clear()
                saveTasksToSharedPreferences(editor, taskList)
            }
                
            
        }
        val savedTasksJson = sharedPreferences.getString("taskList", null)
        if (savedTasksJson != null) {
            val gson = Gson()
            val savedTasks: List<Task> = gson.fromJson(savedTasksJson, object : TypeToken<List<Task>>() {}.type)
            taskList.addAll(savedTasks)
            taskAdapter.notifyDataSetChanged()
        }

    }

    private fun saveTasksToSharedPreferences(editor: SharedPreferences.Editor, tasks: List<Task>) {
        val gson = Gson()
        val tasksJson = gson.toJson(tasks)
        editor.putString("taskList", tasksJson)
        editor.apply()
    }

}