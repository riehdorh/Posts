package io.posts.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.makeramen.roundedimageview.RoundedImageView
import com.squareup.picasso.Picasso
import io.posts.R
import io.posts.dto.GetPost

class PostsHolder(view: View) : RecyclerView.ViewHolder(view)

class PostAdapter(val listPost: GetPost): RecyclerView.Adapter<PostsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)

        return PostsHolder(view)
    }

    override fun getItemCount(): Int = listPost.posts.size

    override fun onBindViewHolder(holder: PostsHolder, position: Int) {
        val list = listPost.posts[position]
        val image: RoundedImageView = holder.itemView.findViewById(R.id.userImage)
        val name: TextView = holder.itemView.findViewById(R.id.username)
        val content: TextView = holder.itemView.findViewById(R.id.message)
        val like: TextView = holder.itemView.findViewById(R.id.like)
        val comment: TextView = holder.itemView.findViewById(R.id.comment)
        val share: TextView = holder.itemView.findViewById(R.id.share)

        Picasso.get().load(list.author.avatar).into(image)
        name.text = list.author.name
        content.text = list.content
        like.text = list.likes.toString()
        comment.text = list.comments.toString()
        share.text = list.shares.toString()
    }
}