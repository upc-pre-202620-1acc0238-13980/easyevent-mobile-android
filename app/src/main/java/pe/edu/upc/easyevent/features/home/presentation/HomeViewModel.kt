package pe.edu.upc.easyevent.features.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pe.edu.upc.easyevent.features.home.application.GetEventsUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getEvents: GetEventsUseCase) : ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())
    val state: StateFlow<HomeUiState> = _state.asStateFlow()

    fun loadEvents() {
        _state.update { currentState ->
            currentState.copy(isLoading = true, errorMessage = null)
        }

        viewModelScope.launch (Dispatchers.IO) {
            val result = getEvents()

            result.fold(
                onSuccess = { events ->
                    _state.update { currentState ->
                        currentState.copy(isLoading = false, events = events, errorMessage = null)
                    }
                },
                onFailure = { exception ->
                    _state.update { currentState ->
                        currentState.copy(isLoading = false, errorMessage = exception.message)
                    }
                }
            )
        }
    }

    init {
        loadEvents()
    }
}