package com.example.alifbee.settings

import android.os.Bundle
import android.view.*
import android.widget.ImageButton
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.alifbee.R


class SettingsFragment : Fragment() {
    private lateinit var listView: ListView
    private lateinit var arrayList: ArrayList<CardItem>
    private lateinit var backButton: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listView = view.findViewById(R.id.card_list_view)
        backButton = view.findViewById(R.id.back_button_image_button)
        backButton.setOnClickListener {
            view.findNavController().navigateUp()
        }
        buildList()
        val adapter = CardAdapter(requireContext(), arrayList)
        listView.adapter = adapter

    }

    private fun buildList() {
        arrayList = ArrayList()
        arrayList.add(CardItem(R.drawable.img,"AlifBee - Learn Arabic\n The Easy Way"))
        arrayList.add(CardItem(R.drawable.img2,"AlifBee - Arabic Word \n Treasure"))
        arrayList.add(CardItem(R.drawable.img3,"AlifBee - Arabic Word \n Treasure"))
        arrayList.add(CardItem(R.drawable.img4,"AlifBee - Arabic Word \n Treasure"))

    }

}