package com.kanneki.boxwithconstraints

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _items = mutableStateListOf<CustomData>()
    val items: List<CustomData> get() = _items

    init {
        getData()
    }

    private fun getData() {
        (0..10).forEach { index ->
            val data = CustomData(
                id = index,
                image = "https://picsum.photos/id/237/200/300",
                title = "Lorem Ipsum",
                description = "android kotlin jetpack java okhttp room ktor retrofit sharedPreference hilt dataStore koin rxjava coroutine compose"
            )
            _items.add(data)
        }
    }
}

data class CustomData(
    val id: Int,
    val image: String,
    val title: String,
    val description: String
)