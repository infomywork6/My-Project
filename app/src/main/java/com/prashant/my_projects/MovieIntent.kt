package com.prashant.my_projects

sealed class MovieIntent {
    data object LoadMovie : MovieIntent()
    data object LoadNews : MovieIntent()
}
