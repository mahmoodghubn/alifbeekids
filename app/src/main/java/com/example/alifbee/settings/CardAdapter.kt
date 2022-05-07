package com.example.alifbee.settings

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.alifbee.R

class CardAdapter(
    var context: Context,
    var arrayList: ArrayList<CardItem>
) : BaseAdapter() {

    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(p0: Int): Any {
        return arrayList.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View = View.inflate(context, R.layout.settings_card, null)
        val card: ImageView = view.findViewById(R.id.appIcon_image_view)
        val title: TextView = view.findViewById(R.id.title)
        val detail:TextView = view.findViewById(R.id.detail)
        val link:TextView = view.findViewById(R.id.link)
        card.setImageResource(arrayList[p0].icon_resource)
        title.text = arrayList[p0].title
        detail.text = arrayList[p0].details
        link.text = arrayList[p0].link
        return view
    }
}

