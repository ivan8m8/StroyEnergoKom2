package ru.is88.stroyenergokom2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// instead of using callback
// https://developer.android.com/topic/libraries/architecture/viewmodel.html#sharing
class SharedViewModel: ViewModel() {

    val buttonClicked by lazy { MutableLiveData<Event<Any>>() }

    fun onButtonClick() {
        buttonClicked.value = Event(Any())
    }
}