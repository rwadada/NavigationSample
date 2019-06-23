package com.example.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.example.android.INavigation
import com.example.android.NavigationHandler
import com.example.main.R

class FirstFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onResume() {
        super.onResume()
        val view: View? = view
        if (view is View) {
            NavigationHandler.navigation = object : INavigation {
                override fun navigateSecond() {
                    findNavController(view)
                        .navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment())
                }

                override fun navigateThird() {
                    findNavController(view)
                        .navigate(FirstFragmentDirections.actionFirstFragmentToThirdFragment())
                }
            }
        }
    }
}