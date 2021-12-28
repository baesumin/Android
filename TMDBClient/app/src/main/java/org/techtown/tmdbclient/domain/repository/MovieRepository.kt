package org.techtown.tmdbclient.domain.repository

import org.techtown.tmdbclient.data.model.movie.Movie

interface MovieRepository {

  suspend fun getMovies():List<Movie>?
  suspend fun updateMovies():List<Movie>?
}