package com.jianastrero.movie_use_case.di

import com.jianastrero.movie_use_case.*
import org.koin.dsl.module

val movieUseCaseModule = module {

    factory { GetLatestMovieUseCase() }
    factory { GetMoviesByGenreUseCase() }
    factory { GetMoviesCategorizedByGenreUseCase() }
    factory { GetMoviesUseCase() }
    factory { GetMovieUseCase() }
    factory { SetMovieViewedUseCase() }

}