package com.example.capiter.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<T> : ViewModel() {

    protected abstract val _viewState: MutableLiveData<T>

    val viewState: LiveData<T> get() = _viewState

    open fun setState(default: T, block: T.() -> T) {
        _viewState.postValue(block(_viewState.value ?: default))
    }
}