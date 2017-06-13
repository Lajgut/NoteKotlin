package com.bravekitty.kir.notekotlin.base_component

import android.support.v7.widget.RecyclerView

open abstract class BaseRecyclerAdapter<VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    //var onItemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(pos: Int)

    }

    /*fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }*/

}