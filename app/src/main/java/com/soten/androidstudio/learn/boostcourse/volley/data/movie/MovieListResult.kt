package com.soten.androidstudio.learn.boostcourse.volley.data.movie

data class MovieListResult(

    val boxofficeType: String,
    val showRange: String,
    val dailyBoxOfficeList: ArrayList<Movie>

)
