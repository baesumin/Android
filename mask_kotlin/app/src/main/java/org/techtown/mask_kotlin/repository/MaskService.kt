package org.techtown.mask_kotlin.repository

import org.techtown.mask_kotlin.model.StoreInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MaskService {
    @GET("raw/?m=5000")
    suspend fun fetchStoreInfo(
        @Query("lat") lat: Double,
        @Query("lng") lng: Double
    ): StoreInfo

    companion object {
        const val BASE_URL =
            "https://gist.githubusercontent.com/junsuk5/bb7485d5f70974deee920b8f0cd1e2f0/"
    }
}