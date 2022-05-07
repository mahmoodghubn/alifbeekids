package com.example.alifbee.category

import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.alifbee.R


class CategoryFragment : Fragment() {
    private var index: Int = 0
    private lateinit var previousImageButton: ImageButton
    private lateinit var nextImageButton: ImageButton
    private lateinit var arrayList: ArrayList<Int>
    private lateinit var childImageView: ImageView
    private lateinit var muteImageButton: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            activity?.window?.insetsController?.let {
                it.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                it.hide(WindowInsets.Type.systemBars())
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                @Suppress("DEPRECATION")
                activity?.window?.decorView?.systemUiVisibility = (
                        // Do not let system steal touches for showing the navigation bar
                        View.SYSTEM_UI_FLAG_IMMERSIVE
                                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

                                // Hide the nav bar and status bar
                                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                or View.SYSTEM_UI_FLAG_FULLSCREEN

                                // Keep the app content behind the bars even if user swipes them up
                                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

                        )
            }
        }

        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageButton = view.findViewById<ImageButton>(R.id.more_by_us_image_view)
        imageButton?.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_categoryFragment_to_parentsLockFragment)
        }

        childImageView = view.findViewById(R.id.child_image_view)
        buildList()

        previousImageButton = view.findViewById(R.id.monofication_Left)
        previousImageButton.setOnClickListener {
            handleLeftClick()
        }

        nextImageButton = view.findViewById(R.id.monofication_right)
        nextImageButton.setOnClickListener {
            handleRightClick()
        }


        muteImageButton = view.findViewById(R.id.mute_image_view)
        muteImageButton.setOnClickListener {
            handleMuteClick()
        }
        val sharedPref = requireActivity().getPreferences(
            Context.MODE_PRIVATE
        )
        val status = sharedPref?.getInt("mute", 1)
        if (status == 0) {
            muteImageButton.setImageResource(R.drawable.ic_off1)
        }
    }

    private fun handleMuteClick() {
        val sharedPref = requireActivity().getPreferences(
            Context.MODE_PRIVATE
        )
        val status = sharedPref?.getInt("mute", 1)
        if (status == 0) {
            with(sharedPref.edit()) {
                this?.putInt("mute", 1)
                this?.apply()
            }
            muteImageButton.setImageResource(R.drawable.ic_on)
        } else {
            with(sharedPref?.edit()) {
                this?.putInt("mute", 0)
                this?.apply()
            }
            muteImageButton.setImageResource(R.drawable.ic_off1)
        }

    }

    private fun buildList() {
        arrayList = ArrayList()
        arrayList.add(R.drawable.music)
        arrayList.add(R.drawable.ic_game)
        arrayList.add(R.drawable.ic_video)
    }

    private fun handleRightClick() {
        when (index) {
            0 -> {
                ++index
                previousImageButton.visibility = View.VISIBLE
            }
            1 -> {
                ++index
                nextImageButton.visibility = View.INVISIBLE
            }
            2 -> {
                //image button is invisible
            }
        }
        childImageView.setImageResource(arrayList.get(index))

    }

    private fun handleLeftClick() {
        when (index) {
            0 -> {
                // image button is invisible
            }
            1 -> {
                --index
                previousImageButton.visibility = View.INVISIBLE
            }
            2 -> {
                --index
                nextImageButton.visibility = View.VISIBLE
            }
        }
        childImageView.setImageResource(arrayList[index])
    }


}