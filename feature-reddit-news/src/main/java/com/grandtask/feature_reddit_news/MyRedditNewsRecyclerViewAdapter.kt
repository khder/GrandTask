package com.grandtask.feature_reddit_news

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.grandtask.feature_reddit_news.databinding.FragmentRedditNewsBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyRedditNewsRecyclerViewAdapter(
) : RecyclerView.Adapter<MyRedditNewsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentRedditNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int = 0

    inner class ViewHolder(binding: FragmentRedditNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

}