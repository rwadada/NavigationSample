package com.example.android

import androidx.lifecycle.MutableLiveData

object NavigationHandler {
    var navigation = object : INavigation{}
    val currentPosition: MutableLiveData<Int> = MutableLiveData()

    var firstPageId = 0
    var secondPageId = 1
    var thirdPageId = 2
}