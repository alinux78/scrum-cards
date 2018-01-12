package com.example.mihai.scrumcards

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button

/**
 * Created by mihai on 1/11/18.
 */
class ScrumCardsAdapter(private val context: MainActivity) : BaseAdapter() {


    companion object {
        val CARDS = arrayOf("0", "1/2", "1", "2", "3", "5", "8", "13", "21", "34", "100", "?")
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var button : Button
        if (convertView == null) {
            button = Button(context, null, 0, R.style.CardButtonStyle)
            button.height = 410
            button.setOnClickListener(context::onCardClick)
        } else {
            button = convertView as Button
        }
        button.text = CARDS[position]
        return button;
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return CARDS.size
    }
}