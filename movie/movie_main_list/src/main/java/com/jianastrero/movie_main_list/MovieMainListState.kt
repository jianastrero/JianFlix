package com.jianastrero.movie_main_list

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
data class MovieMainListState(
    val progressState: ProgressState = ProgressState.None,
    val moviesCategorizedByGenre: Map<String, List<Movie>> = mapOf(),
    val latestMovie: Movie? = null
)