package pe.edu.upc.easyevent.features.home.presentation

import pe.edu.upc.easyevent.features.home.domain.Event

data class HomeUiState(
    val isLoading: Boolean = false,
    val events: List<Event> = emptyList(),
    val errorMessage: String? = null
)
