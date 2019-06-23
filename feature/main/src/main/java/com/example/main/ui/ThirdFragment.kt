package com.example.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.android.INavigation
import com.example.android.NavigationHandler
import com.example.main.R

class ThirdFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onResume() {
        super.onResume()
        val view: View? = view
        if (view is View) {
            NavigationHandler.navigation = object : INavigation {
                override fun navigateFirst() {
                    Navigation.findNavController(view)
                        .navigate(ThirdFragmentDirections.actionThirdFragmentToFirstFragment())
                }

                override fun navigateSecond() {
                    Navigation.findNavController(view)
                        .navigate(ThirdFragmentDirections.actionThirdFragmentToSecondFragment())
                }
            }
        }
    }
}