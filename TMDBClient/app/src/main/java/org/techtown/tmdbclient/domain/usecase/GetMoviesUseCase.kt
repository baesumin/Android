package org.techtown.tmdbclient.domain.usecase

import org.techtown.tmdbclient.data.model.movie.Movie
import org.techtown.tmdbclient.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
  suspend fun execute():List<Movie>? = movieRepository.getMovies()
}