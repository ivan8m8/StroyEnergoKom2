package ru.is88.stroyenergokom2

open class Event<out T>(private val content: T) {

    private var hasBeenHandled = false

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled)
            null
        else {
            hasBeenHandled = true
            content
        }
    }

    /**
     * Returns the content that might have already been handled.
     */

    fun peekContent(): T = content
}