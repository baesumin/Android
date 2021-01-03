package org.techtown.mask_kotlin

import android.location.Location
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.techtown.mask_kotlin.model.Store
import org.techtown.mask_kotlin.repository.MaskService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel : ViewModel() {
    val itemLiveData = MutableLiveData<List<Store>>()
    val loadingLiveData = MutableLiveData<Boolean>()
    var location: Location? = null

    private val service: MaskService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(MaskService.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build();

        service = retrofit.create(MaskService::class.java)

        fetchStoreInfo()
    }

    fun fetchStoreInfo(){
        // 로딩 시작
        loadingLiveData.setValue(true);

        viewModelScope.launch {
            val storeInfo = service.fetchStoreInfo(37.54479207942774, 127.05543016589836)
            itemLiveData.value = storeInfo.stores

            // 로딩 끝
            loadingLiveData.value = false;
        }

    }
}