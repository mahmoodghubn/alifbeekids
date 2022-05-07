package com.example.alifbee.parentlock

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import com.example.alifbee.R

class KeyboardItemAdapter(
    var context: Context,
    var mCallback: OnKeyClickListener,
    var arrayList: ArrayList<Int>
) : BaseAdapter() {

    interface OnKeyClickListener {
        fun onKeyClicked(position: Int)
    }

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
        val view: View = View.inflate(context, R.layout.keyboard_key, null)
        val keyboardKey: ImageButton = view.findViewById(R.id.keyboard_key_image_button)
        keyboardKey.setImageResource(arrayList.get(p0))
        if (p0 == 9) {
            view.visibility = View.INVISIBLE
        }
        keyboardKey.setOnClickListener {
            mCallback.onKeyClicked(p0)
        }

        return view
    }
}