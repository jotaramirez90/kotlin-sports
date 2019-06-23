package es.jota.sports.features.sports.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import es.jota.sports.R
import es.jota.sports.features.sports.ui.viewmodels.SportsViewModel
import es.jota.sports.features.sports.ui.viewmodels.SportsViewModel.SportHeaderViewModel
import es.jota.sports.features.sports.ui.viewmodels.SportsViewModel.SportPlayerViewModel
import kotlinx.android.synthetic.main.item_header.view.*
import kotlinx.android.synthetic.main.item_player.view.*

class SportsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_PLAYER = 1
    }

    private var items: List<SportsViewModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            TYPE_PLAYER -> PlayerViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_player,
                    parent,
                    false
                )
            )
            else -> HeaderViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_header,
                    parent,
                    false
                )
            )
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            TYPE_PLAYER -> (holder as PlayerViewHolder).bind(items[position] as SportPlayerViewModel)
            else -> (holder as HeaderViewHolder).bind(items[position] as SportHeaderViewModel)
        }
    }

    override fun getItemViewType(position: Int) =
        when (items[position]) {
            is SportHeaderViewModel -> TYPE_HEADER
            is SportPlayerViewModel -> TYPE_PLAYER
        }

    override fun getItemCount(): Int = items.size

    fun updateData(items: List<SportsViewModel>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: SportHeaderViewModel) {
            itemView.tv_header.text = item.title
        }
    }

    inner class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: SportPlayerViewModel) {
            item.image?.let {
                Picasso.get().load(it).into(itemView.iv_player)
            }
            itemView.tv_player.text = "${item.name} ${item.surname}"
        }
    }
}