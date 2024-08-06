package com.prashant.my_projects

data class MovieViewState(
    val loading: Boolean = false,
    val movie: List<Movie> = emptyList(),
    val error: String? = null
)
