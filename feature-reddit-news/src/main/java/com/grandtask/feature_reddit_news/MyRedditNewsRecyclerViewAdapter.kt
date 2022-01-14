package com.grandtask.feature_reddit_news

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.grandtask.feature_reddit_news.databinding.FragmentRedditNewsBinding
import com.grandtask.feature_reddit_news.databinding.RedditNewsRowBinding
import com.grandtask.utils.Article

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyRedditNewsRecyclerViewAdapter(private val articles:List<Article>,
private val onCLick:(article: Article)->Unit)
    : RecyclerView.Adapter<MyRedditNewsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            RedditNewsRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.article = articles[position]
        holder.binding.root.setOnClickListener {
            onCLick.invoke(articles[position])
        }
    }

    override fun getItemCount(): Int = articles.size

    inner class ViewHolder(val binding:RedditNewsRowBinding ) :
        RecyclerView.ViewHolder(binding.root) {

    }

}