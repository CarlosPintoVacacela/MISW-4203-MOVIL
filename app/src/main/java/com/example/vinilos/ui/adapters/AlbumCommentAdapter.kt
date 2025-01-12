package com.example.vinilos.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vinilos.R
import com.example.vinilos.databinding.AlbumCommentBinding
import com.example.vinilos.databinding.AlbumPerformerBinding
import com.example.vinilos.models.Comment
import com.example.vinilos.models.Performer

class AlbumCommentAdapter : RecyclerView.Adapter<AlbumCommentAdapter.AlbumCommentViewHolder>(){

    var comments :List<Comment> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumCommentViewHolder {
        val withDataBinding: AlbumCommentBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            AlbumCommentViewHolder.LAYOUT,
            parent,
            false)
        return AlbumCommentViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: AlbumCommentViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.comment = comments[position]
        }
    }

    override fun getItemCount(): Int {
        return comments.size
    }


    class AlbumCommentViewHolder(val viewDataBinding: AlbumCommentBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {
        companion object {
            @LayoutRes
            val LAYOUT = R.layout.album_comment
        }
    }
}