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
 * Use-case for Getting movie list categorized by genre
 *
 * @author Jian James P. Astrero
 */
class GetMoviesCategorizedByGenreUseCase : KoinComponent {

    private val repository by inject<MovieRepository>()

    /**
     * Invokable - object could invoke itself to call this method
     */
    operator fun invoke(): Flow<Resource<Map<String, List<Movie>>>> = flow {
        try {
            emit(Resource.Loading<Map<String, List<Movie>>>())

            val movies = repository.getAll()
            val genreList = movies.distinctBy { it.genre }.map { it.genre }.sorted()

            val genreMap = mutableMapOf<String, List<Movie>>()

            genreList.forEach { genre ->
                val genreMovies = movies.filter { it.genre == genre }.sortedByDescending { it.releaseDate }
                genreMap[genre] = genreMovies
            }

            emit(Resource.Success(genreMap as Map<String, List<Movie>>))

        } catch (e: HttpException) {
            emit(Resource.Error.UnexpectedError<Map<String, List<Movie>>>())
        } catch (e: IOException) {
            emit(Resource.Error.NoInternetConnectionError<Map<String, List<Movie>>>())
        } catch (e: Exception) {
            emit(Resource.Error<Map<String, List<Movie>>>(e.localizedMessage ?: "Unexpected error occurred"))
        }
    }
}