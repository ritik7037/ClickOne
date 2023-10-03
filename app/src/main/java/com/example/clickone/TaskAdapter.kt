package com.example.clickone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView

class TaskAdapter(private val context: Context, private val tasks: MutableList<Task>) : BaseAdapter() {

    override fun getCount(): Int {
        return tasks.size
    }

    override fun getItem(position: Int): Task {
        return tasks[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.task_item, parent, false)
        val task = getItem(position)

        val taskTitleTextView = view.findViewById<TextView>(R.id.taskTitle)
        val taskCheckBox = view.findViewById<CheckBox>(R.id.taskCheckBox)

        taskTitleTextView.text = task.title
        taskCheckBox.isChecked = task.isCompleted
        val deleteButton = view.findViewById<ImageButton>(R.id.deleteButton)
        taskCheckBox.setOnCheckedChangeListener { _, isChecked ->
            task.isCompleted = isChecked

            deleteButton.setOnClickListener {
                tasks.remove(task)
                notifyDataSetChanged()
            }
        }

        return view
    }
}