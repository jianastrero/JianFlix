package com.jianastrero.movie_use_case

import com.jianastrero.core.domain.Resource
import com.jianastrero.movie_domain.MovieRepository
import com.jianastrero.movie_domain.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception

class SetMovieViewedUseCase : KoinComponent {

    private val repository by inject<MovieRepository>()

    /**
     * Invokable - object could invoke itself to call this method
     */
    operator fun invoke(id: Int): Flow<Resource<Movie>> = flow {
        try {
            emit(Resource.Loading<Movie>())

            val movie = repository.getById(id)
            movie.viewed = true

            val updatedMovie = repository.update(movie)

            emit(Resource.Success(updatedMovie))

        } catch (e: HttpException) {
            emit(Resource.Error.UnexpectedError<Movie>())
        } catch (e: IOException) {
            emit(Resource.Error.NoInternetConnectionError<Movie>())
        } catch (e: Exception) {
            emit(Resource.Error<Movie>(e.localizedMessage ?: "Unexpected error occurred"))
        }
    }
}