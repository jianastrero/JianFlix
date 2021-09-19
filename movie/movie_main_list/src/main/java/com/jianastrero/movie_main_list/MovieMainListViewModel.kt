package com.jianastrero.movie_main_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jianastrero.core.domain.ProgressState
import com.jianastrero.core.domain.Resource
import com.jianastrero.movie_use_case.GetLatestMovieUseCase
import com.jianastrero.movie_use_case.GetMoviesCategorizedByGenreUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * The ViewModel for the MovieMainList Composable
 *
 * @param getLatestMovieUseCase The use case to get latest movie.
 * @param getMoviesCategorizedByGenreUseCase The use case to get movies categorized by genre.
 *
 * @author Jian James P. Astrero
 */
class MovieMainListViewModel(
    private val getLatestMovieUseCase: GetLatestMovieUseCase,
    private val getMoviesCategorizedByGenreUseCase: GetMoviesCategorizedByGenreUseCase
) : ViewModel() {

    private val _state = mutableStateOf(MovieMainListState())
    val state: State<MovieMainListState> = _state

    init {
        getLatestMovie()
    }

    private fun getLatestMovie() {
        getLatestMovieUseCase().onEach { resource ->
            when (resource) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        latestMovie = resource.data
                    )
                }
                is Resource.Loading -> {
                    _state.value = _state.value.copy(
                        latestMovie = null
                    )
                }
                is Resource.Error -> {
                    _state.value = _state.value.copy(
                        latestMovie = null
                    )
                }
            }
        }.launchIn(viewModelScope).invokeOnCompletion {
            getMoviesCategorizedByGenre()
        }
    }

    private fun getMoviesCategorizedByGenre() {
        getMoviesCategorizedByGenreUseCase().onEach { resource ->
            when (resource) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        progressState = ProgressState.Loaded,
                        moviesCategorizedByGenre = resource.data ?: mapOf()
                    )
                }
                is Resource.Loading -> {
                    _state.value = _state.value.copy(
                        progressState = ProgressState.Loading
                    )
                }
                is Resource.Error -> {
                    _state.value = _state.value.copy(
                        progressState = ProgressState.Error(
                            resource.message ?: "An unexpected error had occured"
                        )
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}