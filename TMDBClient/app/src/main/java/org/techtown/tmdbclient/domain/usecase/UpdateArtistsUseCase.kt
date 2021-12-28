package org.techtown.tmdbclient.domain.usecase

import org.techtown.tmdbclient.data.model.artist.Artist
import org.techtown.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
  suspend fun execute():List<Artist>? = artistRepository.updateArtists()
}