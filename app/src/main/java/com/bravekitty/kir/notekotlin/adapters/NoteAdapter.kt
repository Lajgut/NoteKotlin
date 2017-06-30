package com.bravekitty.kir.notekotlin.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bravekitty.kir.notekotlin.R
import com.bravekitty.kir.notekotlin.models.NoteModel
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter
import kotlinx.android.synthetic.main.item_note.view.*


class NoteAdapter(
        private val list: MutableList<NoteModel>,
        data: OrderedRealmCollection<NoteModel>?,
        autoUpdate: Boolean
                            )
    : RealmRecyclerViewAdapter<NoteModel, NoteAdapter.MyViewHolder>(data, autoUpdate) {

    private var mContext: Context? = null

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal fun bind(listIndex: Int) {
            /**
             * initialize containers and listeners
             */
            itemView.text.text = list[listIndex].text
            itemView.header.text = list[listIndex].header

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        mContext = parent.context
        val shouldAttachToParentImmediately = false
        val adapterView = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, shouldAttachToParentImmediately)
        return MyViewHolder(adapterView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d("onBindViewHolder ", "#" + position)
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    /**
     * remove 1 element by position
     */
    fun removeItem(position: Int) {
        list.removeAt(position)
        notifyDataSetChanged()
    }

    /**
     * add only 1 element
     */
    fun addItem(item: NoteModel) {
        list.add(item)
        notifyDataSetChanged()
    }

    /**
     * add all elements
     */
    fun addAllItem(itemList: List<NoteModel>) {
        list.addAll(itemList)
        notifyDataSetChanged()
    }
}