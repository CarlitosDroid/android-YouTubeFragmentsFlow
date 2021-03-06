package com.carlitosdroid.android_youtubefragmentsflow.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.carlitosdroid.android_youtubefragmentsflow.R
import kotlinx.android.synthetic.main.item_home.view.*

class HomeAdapter(var homeList: MutableList<String>,
                  val onHomeItemClickListener: (String) -> Unit) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder =
            HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false))

    override fun getItemCount(): Int = homeList.size


    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(homeList[position])
    }

    inner class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view),
            View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(setting: String) {
            itemView.tvTitle.text = setting
        }

        override fun onClick(p0: View?) {
            onHomeItemClickListener("")
        }
    }
}