package com.jianastrero.movie_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jianastrero.constant.StateConstants
import com.jianastrero.core.domain.ProgressState
import com.jianastrero.core.domain.Resource
import com.jianastrero.core.util.log
import com.jianastrero.movie_use_case.GetLatestMovieUseCase
import com.jianastrero.movie_use_case.GetMovieUseCase
import com.jianastrero.movie_use_case.GetMoviesCategorizedByGenreUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * The ViewModel for the MovieMainList Composable
 *
 * @param getMovieUseCase The use case to get the movie.
 * @param savedStateHandle The saved state handle to hanldle state changes and receiving data from ui.
 *
 * @author Jian James P. Astrero
 */
class MovieDetailViewModel(
    private val getMovieUseCase: GetMovieUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(MovieDetailState())
    val state: State<MovieDetailState> = _state

    init {
        savedStateHandle.get<Int>(StateConstants.PARAM_MOVIE_ID)?.let { movieId ->
            getMovie(movieId)
        }
    }

    private fun getMovie(movieId: Int) {
        getMovieUseCase(movieId).onEach { resource ->
            when (resource) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        movie = resource.data
                    )
                }
                is Resource.Loading -> {
                    _state.value = _state.value.copy(
                        movie = null
                    )
                }
                is Resource.Error -> {
                    _state.value = _state.value.copy(
                        movie = null
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}