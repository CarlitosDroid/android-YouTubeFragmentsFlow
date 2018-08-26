package com.carlitosdroid.android_youtubefragmentsflow.ui.subscriptions

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.carlitosdroid.android_youtubefragmentsflow.R
import kotlinx.android.synthetic.main.item_subscription.view.*

class SubscriptionsAdapter(var settingsList: MutableList<String>,
                           val onSettingItemClickListener: (String) -> Unit) : RecyclerView.Adapter<SubscriptionsAdapter.SubscriptionViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriptionViewHolder =
            SubscriptionViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_subscription, parent, false))


    override fun getItemCount(): Int = settingsList.size

    override fun onBindViewHolder(holder: SubscriptionViewHolder, position: Int) {
        holder.bind(settingsList[position])
        with(settingsList[position]) {
            holder.bind(this)
        }
    }

    inner class SubscriptionViewHolder(view: View) : RecyclerView.ViewHolder(view),
            View.OnClickListener, View.OnLongClickListener {

        init {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }

        fun bind(setting: String) {
            itemView.tvTitle.text = setting
        }

        override fun onClick(p0: View?) {
            //onLastSearchItemClickListener(lastSearchEntity)
        }

        override fun onLongClick(p0: View?): Boolean {
            //onLastSearchItemLongClickListener(lastSearchEntity)
            return true
        }
    }
}