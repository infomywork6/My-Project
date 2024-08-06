package com.prashant.my_projects

import kotlinx.coroutines.delay
import javax.inject.Inject

class MovieRepository @Inject constructor() {
    suspend fun getMovies(): List<Movie> {
        delay(1000)
        return listOf(
            Movie(1, "Jay ho", "2021"),
            Movie(2, "Bhola", "2022"),
            Movie(3, "Dil se", "2023"),
            Movie(4, "Himmat", "2024"),
        )
    }
}