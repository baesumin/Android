package org.techtown.tmdbclient.domain.usecase

import org.techtown.tmdbclient.data.model.tvshow.TvShow
import org.techtown.tmdbclient.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
  suspend fun execute():List<TvShow>? = tvShowRepository.getTvShows()
}