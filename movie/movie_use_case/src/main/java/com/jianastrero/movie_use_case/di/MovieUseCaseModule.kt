package com.jianastrero.movie_use_case.di

import com.jianastrero.movie_use_case.*
import org.koin.dsl.module

val movieUseCaseModule = module {

    factory { GetMoviesUseCase() }
    factory { GetMovieUseCase() }
    factory { GetMoviesCategorizedByGenreUseCase() }
    factory { GetLatestMovieUseCase() }
    factory { SetMovieViewedUseCase() }

}