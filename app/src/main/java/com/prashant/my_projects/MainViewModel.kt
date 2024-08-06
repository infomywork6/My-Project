package com.prashant.my_projects

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val movieRepository: MovieRepository) :
    ViewModel() {

    private val _state = MutableStateFlow(MovieViewState())
    val state: StateFlow<MovieViewState> get() = _state

    fun handleIntent(intent: MovieIntent) {
        viewModelScope.launch {
            when (intent) {
                is MovieIntent.LoadMovie -> fetchMovies()
                else -> fetchNews() // MovieIntent.LoadNews
            }
        }
    }

    private suspend fun fetchMovies() {
        _state.value = _state.value.copy(loading = true, error = null)
        try {
            val movies = movieRepository.getMovies()
            _state.value = MovieViewState(loading = false, movie = movies)
        } catch (e: Exception) {
            _state.value = MovieViewState(loading = false, error = e.message ?: "Error In Api")
            Log.d("TAG", "fetchMovies: ${e.message}")
        }
    }

    private fun fetchNews() {

    }
}