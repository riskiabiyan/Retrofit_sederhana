package com.riskiabiyan.retrofit_5190411359

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_post.view.*

class CommentAdapter(private val listComment: ArrayList<CommentResponse>) : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return CommentViewHolder(view)
    }

    override fun getItemCount(): Int = listComment.size

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
       holder.bind(listComment[position])
    }

    inner class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(commentResponse: CommentResponse){
            with(itemView){
                val text = "postId: ${commentResponse.postId}\n" +
                        "id: ${commentResponse.id}\n" +
                        "name: ${commentResponse.name}\n" +
                        "emai: ${commentResponse.email}\n" +
                        "body: ${commentResponse.body}\n"
                tvText.text = text
            }
        }
    }

}