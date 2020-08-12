package com.example.newapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newapp.R
import com.example.newapp.adapter.NextHeadlinesAdapter
import com.example.newapp.adapter.TopHeadlinesAdapter
import com.example.newapp.model.Article
import com.example.newapp.model.News
import com.example.newapp.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_top_headlines.*
import kotlinx.android.synthetic.main.item_topheadlines.*


class TopHeadlinesFragment : Fragment() , TopHeadlinesAdapter.ClickListener {

    lateinit var viewModel: NewsViewModel
     var topHeadlinesAdapter: TopHeadlinesAdapter = TopHeadlinesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_headlines, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

//        viewModel.loadResult()

//        topHeadlinesrecycler.layoutManager = LinearLayoutManager(context)





        topHeadlinesrecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = topHeadlinesAdapter
        }
        topHeadlinesAdapter.setOnclickListener(this)




        observeViewmodel()

    }

        //        var articleList: List<Article>
        fun observeViewmodel() {
            viewModel.getResult()
                .observe(viewLifecycleOwner, Observer<News> { news ->
                    topHeadlinesAdapter.updateArticle(news.articles)

                    Log.d("News",news.articles.toString())
                }
                )

//        recycleView1.apply {
//            layoutManager = LinearLayoutManager(context)
//            adapter =  TopHeadlinesAdapter(
//        }

            viewModel.getLoading().observe(
                viewLifecycleOwner, Observer { isLoading ->
                    if (isLoading) {
                       progress.visibility =  View.VISIBLE
                    } else {
                       progress.visibility =  View.GONE
                    }
                }
            )

//
            viewModel.getErrorStatus().observe(
                viewLifecycleOwner, Observer { status ->
                    if (status) {
                        viewModel.getErrorStatus().observe(
                            viewLifecycleOwner, Observer { message ->
                                txtError.text = message.toString()
                            }
                        )

                    }
                }
            )


        }

    override fun onResume() {
        super.onResume()
        viewModel.loadResult()
    }

    override fun onClick(article: Article) {
        var action = TopHeadlinesFragmentDirections.actionTopHeadlinesFragmentToDetailFragment(article.title)
        findNavController().navigate(action)
    }
}



