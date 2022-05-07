package com.example.alifbee.splash

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.alifbee.R

class SplashFragment : Fragment() {

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
        Handler().postDelayed({
            view?.findNavController()?.navigate(R.id.action_splashFragment_to_categoryFragment)
        }, 2000)

        return inflater.inflate(R.layout.fragment_splash, container, false)

    }

}