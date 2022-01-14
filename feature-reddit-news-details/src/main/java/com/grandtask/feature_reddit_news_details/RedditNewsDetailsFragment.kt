package com.grandtask.feature_reddit_news_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.grandtask.feature_reddit_news_details.databinding.FragmentRedditNewsDetailsBinding

/**
 * A simple [Fragment] subclass.
 * Use the [RedditNewsDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RedditNewsDetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentRedditNewsDetailsBinding.inflate(inflater,container,false)
        binding.article = requireArguments().getParcelable(getString(R.string.article_arg))
        return binding.root
    }
}