package org.techtown.tmdbclient.domain.usecase

import org.techtown.tmdbclient.data.model.movie.Movie
import org.techtown.tmdbclient.domain.repository.MovieRepository


class UpdateMoviesUsecase(private val movieRepository: MovieRepository) {
  suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}