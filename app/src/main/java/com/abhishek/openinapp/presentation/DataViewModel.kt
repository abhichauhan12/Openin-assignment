package com.abhishek.openinapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhishek.openinapp.data.network.FetchStatus
import com.abhishek.openinapp.data.network.apiresponse.ApiResponse
import com.abhishek.openinapp.domian.model.Links
import com.abhishek.openinapp.domian.repository.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(
    private val networkRepository: NetworkRepository
): ViewModel() {

    private val _apiData = MutableStateFlow<List<Links>>(value = ArrayList())
    val apiData = _apiData.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

//    init {
//        getData()
//    }

    fun getData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {

                val response = networkRepository.getData()
                response.data?.let { apiResponse ->
                    val links = apiResponse.data.top_links.map {
                        it.toLinks()
                    }
                    _apiData.value = links

                }

                // handle error (401 UNAUTHORIZED)
                if (response.status is FetchStatus.FAILURE){
                    _error.value = response.status.message
                }
            }
        }
    }


}