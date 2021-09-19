package com.jianastrero.movie_main_list

import com.jianastrero.core.domain.ProgressState
import com.jianastrero.movie_domain.model.Movie

data class MovieMainListState(
    val progressState: ProgressState = ProgressState.None,
    val moviesCategorizedByGenre: Map<String, List<Movie>> = mapOf()
)