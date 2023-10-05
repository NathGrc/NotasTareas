
package com.nath.notas_tareas.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nath.notas_tareas.network.NotitasApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

/**
 * UI state for the Home
 */
sealed interface NotitasUiState {
    data class Success(val listaCom: String) : NotitasUiState
    object Error : NotitasUiState
    object Loading : NotitasUiState
}

class NotitasViewModel : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var notitasUiState: NotitasUiState by mutableStateOf(NotitasUiState.Loading)
        private set

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getNotas()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [MutableList].
     */
    fun getNotas() {
        viewModelScope.launch {
            notitasUiState = NotitasUiState.Loading
            notitasUiState = try {
                val listResult = NotitasApi.retrofitService.Get()
                NotitasUiState.Success(
                    "Success: ${listResult.size} Mars photos retrieved"
                )
            } catch (e: IOException) {
                NotitasUiState.Error
            } catch (e: HttpException) {
                NotitasUiState.Error
            }
        }
    }
}
