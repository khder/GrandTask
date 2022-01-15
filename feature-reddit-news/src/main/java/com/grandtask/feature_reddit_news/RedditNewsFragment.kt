package com.grandtask.feature_reddit_news

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.grandtask.core.di.ObjectsProvider
import com.grandtask.feature_reddit_news.databinding.FragmentRedditNewsBinding
import com.grandtask.utils.Article
import com.grandtask.utils.RedditNewsInteractions
import com.grandtask.utils.Status

/**
 * A fragment representing a list of Items.
 */
class RedditNewsFragment : Fragment() {

    private lateinit var viewModel: RedditNewsViewModel
    private var binding: FragmentRedditNewsBinding?=null
    private lateinit var redditNewsInteractions: RedditNewsInteractions

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRedditNewsBinding.inflate(inflater,container,false)
        return binding!!.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val activity:Activity = context as Activity
        redditNewsInteractions = activity as RedditNewsInteractions
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupViewModel()
        setupObservers()
    }
    private fun setupUI() {
        binding!!.list.addItemDecoration(
            DividerItemDecoration(
                binding!!.list.context,
                (binding!!.list.layoutManager as LinearLayoutManager).orientation
            )
        )
    }
    private fun setupViewModel(){
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(ObjectsProvider.getUseCaseObject(requireContext().applicationContext))
        ).get(RedditNewsViewModel::class.java)
    }

    private fun setupObservers(){
        viewModel.getArticles().observe(viewLifecycleOwner,{
            it?.let {
                resource ->
                when(resource.status){
                    Status.SUCCESS -> {
                        binding!!.list.visibility = View.VISIBLE
                        binding!!.progressCircular.visibility = View.GONE
                        binding!!.list.adapter = MyRedditNewsRecyclerViewAdapter(resource.data!!,
                        ::onClick)
                    }
                    Status.ERROR -> {
                        binding!!.list.visibility = View.VISIBLE
                        binding!!.progressCircular.visibility = View.GONE
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        binding!!.progressCircular.visibility = View.VISIBLE
                        binding!!.list.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun onClick(article: Article){
        redditNewsInteractions.
            openRedditNewsDetails(article)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}