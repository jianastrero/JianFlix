package com.jianastrero.movie_detail

import com.jianastrero.core.domain.ProgressState
import com.jianastrero.movie_domain.model.Movie

/**
 * The State for MovieMainList in its ViewModel
 *
 * @param progressState The ProgressState of this State
 * @param moviesCategorizedByGenre Movies categorized by Genre
 * @param latestMovie The latest movie from the list
 *
 * @author Jian James P. Astrero
 */
data class MovieDetailState(
    val progressState: ProgressState = ProgressState.None,
    val movie: Movie? = null
)