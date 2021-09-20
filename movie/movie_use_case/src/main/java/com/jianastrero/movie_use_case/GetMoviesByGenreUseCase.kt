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

/**
 * Use-case for Getting movies
 *
 * @author Jian James P. Astrero
 */
class GetMoviesByGenreUseCase : KoinComponent {

    private val repository by inject<MovieRepository>()

    /**
     * Invokable - object could invoke itself to call this method
     */
    operator fun invoke(genre: String): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading<List<Movie>>())

            val movies = repository.getMoviesByGenre(genre)

            emit(Resource.Success(movies))

        } catch (e: HttpException) {
            emit(Resource.Error.UnexpectedError<List<Movie>>())
        } catch (e: IOException) {
            emit(Resource.Error.NoInternetConnectionError<List<Movie>>())
        } catch (e: Exception) {
            emit(Resource.Error<List<Movie>>(e.localizedMessage ?: "Unexpected error occurred"))
        }
    }
}