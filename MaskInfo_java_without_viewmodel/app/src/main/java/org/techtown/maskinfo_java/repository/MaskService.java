package org.techtown.maskinfo_java.repository;

import org.techtown.maskinfo_java.model.StoreInfo;

import retrofit2.Call;
import retrofit2.http.GET;

// https://gist.githubusercontent.com/junsuk5/bb7485d5f70974deee920b8f0cd1e2f0/raw/063f64d9b343120c2cb01a6555cf9b38761b1d94
public interface MaskService {
    String BASE_URL = "https://gist.githubusercontent.com/junsuk5/bb7485d5f70974deee920b8f0cd1e2f0/";

    @GET("raw/")
    Call<StoreInfo> fetchStoreInfo();
}
