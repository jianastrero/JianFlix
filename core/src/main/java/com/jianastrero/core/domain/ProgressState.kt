package com.jianastrero.core.domain

sealed class ProgressState {

    object None : ProgressState()
    object Loading : ProgressState()
    object Loaded : ProgressState()
    class Error(val message: String) : ProgressState()

}