package com.jianastrero.movie_main_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jianastrero.core.domain.ProgressState
import com.jianastrero.core.domain.Resource
import com.jianastrero.movie_use_case.GetMoviesCategorizedByGenreUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MovieMainListViewModel(
    private val getMoviesCategorizedByGenreUseCase: GetMoviesCategorizedByGenreUseCase
) : ViewModel() {

    private val _state = mutableStateOf(MovieMainListState())
    val state: State<MovieMainListState> = _state

    init {
        getMoviesCategorizedByGenre()
    }

    private fun getMoviesCategorizedByGenre() {
        getMoviesCategorizedByGenreUseCase().onEach { resource ->
            when (resource) {
                is Resource.Success -> {
                    _state.value = MovieMainListState(
                        progressState = ProgressState.Loaded,
                        moviesCategorizedByGenre = resource.data ?: mapOf()
                    )
                }
                is Resource.Loading -> {
                    _state.value = MovieMainListState(
                        progressState = ProgressState.Loading
                    )
                }
                is Resource.Error -> {
                    _state.value = MovieMainListState(
                        progressState = ProgressState.Error(
                            resource.message ?: "An unexpected error had occured"
                        )
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}