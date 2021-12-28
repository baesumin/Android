package org.techtown.tmdbclient.domain.usecase

import org.techtown.tmdbclient.data.model.artist.Artist
import org.techtown.tmdbclient.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
  suspend fun execute():List<Artist>? = artistRepository.getArtists()
}