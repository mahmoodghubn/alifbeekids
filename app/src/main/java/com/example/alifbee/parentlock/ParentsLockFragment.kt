package com.example.alifbee.parentlock

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.*
import android.widget.GridView
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.alifbee.R

class ParentsLockFragment : Fragment(), KeyboardItemAdapter.OnKeyClickListener {
    private lateinit var gridView: GridView
    private lateinit var imageButton: ImageButton

    private lateinit var keyboardItemAdapter: KeyboardItemAdapter
    private lateinit var arrayList: ArrayList<Int>
    private lateinit var textView1: TextView
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gridView = view.findViewById(R.id.keyboard_grid_view)
        imageButton = view.findViewById(R.id.back_button_image_view)
        imageButton.setOnClickListener {
            view.findNavController().navigateUp()
        }
        textView1 = view.findViewById(R.id.first_number_text_view)!!
        textView2 = view.findViewById(R.id.second_number_text_view)!!
        textView3 = view.findViewById(R.id.third_number_text_view)!!
        arrayList = ArrayList()
        addData()
        keyboardItemAdapter = KeyboardItemAdapter(requireContext(), this, arrayList)
        gridView.adapter = keyboardItemAdapter
    }

    private fun addData() {
        arrayList.add(R.drawable.ic_sicurity_password_chieck)
        arrayList.add(R.drawable.ic_sicurity_password_chieck2)
        arrayList.add(R.drawable.ic_sicurity_password_chieck3)
        arrayList.add(R.drawable.ic_sicurity_password_chieck4)
        arrayList.add(R.drawable.ic_sicurity_password_chieck5)
        arrayList.add(R.drawable.ic_sicurity_password_chieck6)
        arrayList.add(R.drawable.ic_sicurity_password_chieck7)
        arrayList.add(R.drawable.ic_sicurity_password_chieck8)
        arrayList.add(R.drawable.ic_sicurity_password_chieck9)
        arrayList.add(R.drawable.ic_sicurity_password_chieck9)
        arrayList.add(R.drawable.ic_sicurity_password_chieck0)
        arrayList.add(R.drawable.ic_sicurity_password_chieck__1_)

    }


    private fun handleClick(l: Int) {
        val text1 = textView1.text
        val text2 = textView2.text
        val text3 = textView3.text

        if (l < 11) {//input number is clicked
            var x: Int = l + 1
            if (l == 10) {
                x = 0
            }
            when (true) {
                text1.equals("") -> textView1.text = x.toString()
                text2.equals("") -> textView2.text = x.toString()
                text3.equals("") -> {
                    textView3.text = x.toString()
                    checkIfAllInputsAreTrue(text1, text2, x.toString())
                }
            }
        } else {//erase button is clicked
            when (true) {
                !text3.equals("") -> textView3.text = ""
                !text2.equals("") -> textView2.text = ""
                !text1.equals("") -> textView1.text = ""
            }
        }
    }

    private fun checkIfAllInputsAreTrue(
        text1: CharSequence,
        text2: CharSequence,
        text3: CharSequence
    ) {
        if (text1[0] == '4' && text2[0] == '9' && text3[0] == '6') {
            //navigate
            view?.findNavController()?.navigate(R.id.action_parentsLockFragment_to_settingsFragment)

        } else {
            //wrong entry
        }
    }

    @SuppressLint("SourceLockedOrientationActivity")
    @Suppress("DEPRECATION")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.window?.decorView?.systemUiVisibility =
            (
                    View.SYSTEM_UI_FLAG_IMMERSIVE
                            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

                            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    )

        activity?.apply {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }


        return inflater.inflate(R.layout.fragment_parents_lock, container, false)
    }

    override fun onKeyClicked(position: Int) {
        handleClick(position)
    }
}