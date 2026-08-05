package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.api.ApiService
import com.example.data.db.CuratorDatabase
import com.example.data.db.SavedArtworkEntity
import com.example.data.model.ArtMovement
import com.example.data.model.Artwork
import com.example.data.model.Museum
import com.example.data.repository.ArtworkRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface UiState<out T> {
    data object Loading : UiState<Nothing>
    data class Success<T>(val data: T) : UiState<T>
    data class Error(val message: String) : UiState<Nothing>
}

class CuratorViewModel(application: Application) : AndroidViewModel(application) {

    private val db = CuratorDatabase.getDatabase(application)
    private val repository = ArtworkRepository(ApiService(), db.savedArtworkDao())

    private val _masterpiece = MutableStateFlow<Artwork?>(null)
    val masterpiece: StateFlow<Artwork?> = _masterpiece.asStateFlow()

    private val _artworksState = MutableStateFlow<UiState<List<Artwork>>>(UiState.Loading)
    val artworksState: StateFlow<UiState<List<Artwork>>> = _artworksState.asStateFlow()

    private val _searchResultsState = MutableStateFlow<UiState<List<Artwork>>>(UiState.Success(emptyList()))
    val searchResultsState: StateFlow<UiState<List<Artwork>>> = _searchResultsState.asStateFlow()

    val savedArtworks: StateFlow<List<SavedArtworkEntity>> = repository.savedArtworks
        .let { flow ->
            val state = MutableStateFlow<List<SavedArtworkEntity>>(emptyList())
            viewModelScope.launch {
                flow.collect { state.value = it }
            }
            state.asStateFlow()
        }

    private val _selectedFilter = MutableStateFlow("All")
    val selectedFilter: StateFlow<String> = _selectedFilter.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    val artMovements: List<ArtMovement> = repository.getArtMovements()
    val museums: List<Museum> = repository.getMuseums()

    init {
        loadHomeData()
        performSearch("")
    }

    fun loadHomeData() {
        viewModelScope.launch {
            _masterpiece.value = repository.getMasterpieceOfTheDay()
            _artworksState.value = UiState.Loading
            val result = repository.getArtworks()
            if (result.isSuccess) {
                _artworksState.value = UiState.Success(result.getOrDefault(emptyList()))
            } else {
                _artworksState.value = UiState.Error(result.exceptionOrNull()?.message ?: "Failed to load artworks")
            }
        }
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
        performSearch(query)
    }

    fun onFilterSelected(filter: String) {
        _selectedFilter.value = filter
        if (filter == "All") {
            performSearch(_searchQuery.value)
        } else {
            val combinedQuery = if (_searchQuery.value.isNotBlank()) "${_searchQuery.value} $filter" else filter
            performSearch(combinedQuery)
        }
    }

    private fun performSearch(query: String) {
        viewModelScope.launch {
            _searchResultsState.value = UiState.Loading
            val result = repository.searchArtworks(query)
            if (result.isSuccess) {
                val list = result.getOrDefault(emptyList())
                _searchResultsState.value = UiState.Success(list)
            } else {
                _searchResultsState.value = UiState.Error(result.exceptionOrNull()?.message ?: "Search failed")
            }
        }
    }

    fun toggleFavorite(artwork: Artwork) {
        viewModelScope.launch {
            repository.toggleFavorite(artwork)
            // Refresh masterpiece favorite state if matched
            if (_masterpiece.value?.id == artwork.id) {
                _masterpiece.value = _masterpiece.value?.copy(isFavorite = !artwork.isFavorite)
            }
            // Refresh current list favorite flags
            if (_artworksState.value is UiState.Success) {
                val current = (_artworksState.value as UiState.Success<List<Artwork>>).data
                val updated = current.map {
                    if (it.id == artwork.id) it.copy(isFavorite = !it.isFavorite) else it
                }
                _artworksState.value = UiState.Success(updated)
            }
            if (_searchResultsState.value is UiState.Success) {
                val current = (_searchResultsState.value as UiState.Success<List<Artwork>>).data
                val updated = current.map {
                    if (it.id == artwork.id) it.copy(isFavorite = !it.isFavorite) else it
                }
                _searchResultsState.value = UiState.Success(updated)
            }
        }
    }

    fun updateNotes(id: String, notes: String) {
        viewModelScope.launch {
            repository.updateNotes(id, notes)
        }
    }
}
