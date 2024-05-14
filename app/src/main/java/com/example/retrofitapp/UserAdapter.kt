package com.example.retrofitapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapp.databinding.ItemTodoBinding

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private val todoList = arrayListOf<UserModel>()
    lateinit var onClickItem:(String)->Unit

    inner class UserViewHolder(val itemTodoBinding: ItemTodoBinding) :
        RecyclerView.ViewHolder(itemTodoBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val todo = todoList[position]

        holder.itemTodoBinding.textView.text = todo.todo
        holder.itemTodoBinding.cardView.setOnClickListener {
            onClickItem(todo.id.toString())
        }
    }

    fun updateList(myList:ArrayList<UserModel>){
        todoList.clear()
        todoList.addAll(myList)
        notifyDataSetChanged()
    }

}