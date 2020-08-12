package com.example.newapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newapp.R
import com.example.newapp.model.Article
import kotlinx.android.synthetic.main.item_nextheadline.view.*

class NextHeadlinesAdapter(var articleList: List<Article>) :
    RecyclerView.Adapter<NextHeadlinesAdapter.NextViewHolder>() {

    class NextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bind(article: Article) {
            itemView.t2.text = article.author
            itemView.t3.text = article.description
            itemView.t4.text = article.description

//

        }
    }

    //choose layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NextViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_nextheadline,
            parent, false
        )
        return NextViewHolder(view)
    }

    //count
    override fun getItemCount(): Int {
        return articleList.size

    }

    //position
    override fun onBindViewHolder(holder: NextViewHolder, position: Int) {
        holder.bind(articleList[position])
    }
}