package com.jianastrero.di

import com.jianastrero.movie_data.MovieRepositoryImpl
import com.jianastrero.movie_data.local.MovieDao
import com.jianastrero.movie_data.remote.ITunesApi
import com.jianastrero.movie_domain.MovieRepository
import org.koin.dsl.module

/**
 * Movie Module Instance for dependency injection
 *
 * @author Jian James P. Astrero
 */
val movieModule = module {

    fun provideMovieRepository(
        iTunesApi: ITunesApi,
        movieDao: MovieDao
    ): MovieRepository =
        MovieRepositoryImpl(iTunesApi, movieDao)

    single { provideMovieRepository(get(), get()) }

}