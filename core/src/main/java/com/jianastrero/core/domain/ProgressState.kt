package com.jianastrero.core.domain

/**
 * ProgressState used by ViewModel's
 *
 * @author Jian James P. Astrero
 */
sealed class ProgressState {

    /**
     * Progress State is loading
     *
     * @author Jian James P. Astrero
     */
    object Loading : ProgressState()

    /**
     * Progress State is loaded
     *
     * @author Jian James P. Astrero
     */
    object Loaded : ProgressState()

    /**
     * Progress State error
     *
     * @author Jian James P. Astrero
     */
    class Error(val message: String) : ProgressState()

}