package com.jianastrero.movie_detail

import com.jianastrero.core.domain.ProgressState
import com.jianastrero.movie_domain.model.Movie

/**
 * The State for MovieMainList in its ViewModel
 *
 * @param progressState The ProgressState of this State
 * @param movie Movie
 * @param movies The list of suggested movies
 *
 * @author Jian James P. Astrero
 */
data class MovieDetailState(
    val progressState: ProgressState = ProgressState.Loading,
    val movie: Movie? = null,
    val movies: List<Movie> = listOf()
)