package org.techtown.tmdbclient.data.repository.artist.datasourceImpl

import org.techtown.tmdbclient.data.api.TMDBService
import org.techtown.tmdbclient.data.model.artist.ArtistList
import org.techtown.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
  private val tmdbService: TMDBService,
  private val apiKey: String
) : ArtistRemoteDatasource {
  override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularTvArtists(apiKey)


}