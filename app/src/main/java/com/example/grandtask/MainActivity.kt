package com.example.grandtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.grandtask.databinding.ActivityMainBinding
import com.grandtask.utils.Article
import com.grandtask.utils.RedditNewsInteractions

class MainActivity : AppCompatActivity(),RedditNewsInteractions {
    private val navController:NavController by lazy {
        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment)
            .navController
    }
    private var binding: ActivityMainBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        binding!!.backArrowImage.setOnClickListener {
            navigateBack()
        }
    }

    private fun navigateBack(){
        navController.navigateUp()
        binding!!.titleText.text = getString(R.string.kotlin_news_title)
        binding!!.backArrowImage.visibility = View.GONE
    }

    override fun openRedditNewsDetails(article: Article) {
        binding!!.backArrowImage.visibility = View.VISIBLE
        binding!!.titleText.text = article.title
        val bundle:Bundle = bundleOf(getString(R.string.article_arg) to article)
        navController.navigate(R.id.action_redditNewsFragment_to_redditNewsDetailsFragment
            ,bundle)

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun onBackPressed() {
       if(binding!!.backArrowImage.visibility == View.VISIBLE) {
           navigateBack()
       }else{
           finish()
       }
    }
}