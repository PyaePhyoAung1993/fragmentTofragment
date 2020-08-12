package com.example.newapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.newapp.R
import com.example.newapp.model.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_topheadlines.view.*

class TopHeadlinesAdapter(var articleList: List<Article> = ArrayList()) :
    RecyclerView.Adapter<TopHeadlinesAdapter.NewsViewHolder>()  {


    var mClickListener : ClickListener? = null

    fun setOnclickListener(clickListener: ClickListener){
        this.mClickListener = clickListener

    }
    fun  updateArticle(articleList: List<Article>){
        this.articleList = articleList
        notifyDataSetChanged()
    }

 inner  class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) ,
 View.OnClickListener{

        lateinit var article: Article
//        private var view : View = itemView

     init {
         itemView.setOnClickListener(this)
     }

        fun bind(article : Article) {
            this.article = article
            itemView.t1.text = article.title

//            Picasso.get().load(article.urlToImage)
            Picasso.get()
                .load(article.urlToImage)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.image);

        }

     override fun onClick(view: View) {
         mClickListener?.onClick(article)
     }
 }

    //choose layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_topheadlines,
            parent, false
        )
        return NewsViewHolder(view)
    }

    //count
    override fun getItemCount(): Int {
        return articleList.size

    }

    //position
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(articleList[position])
    }

    interface ClickListener{
        fun onClick(article: Article)
    }



}